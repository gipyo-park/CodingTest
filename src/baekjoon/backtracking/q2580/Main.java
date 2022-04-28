package baekjoon.backtracking.q2580;

/**
 *  스도쿠
 *   - 9x9의 스도쿠 판이 주어질 때 빈 칸이 채워진 최종 모습을 출력
 *   - https://www.acmicpc.net/problem/2580
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static int[][] sudoku;

    static int probCnt, solveCnt;
    static List<Point> prob;

    static boolean isEnd;

    public static void doBackTracking() throws IOException {
        if(isEnd) {
            return;
        }

        if(solveCnt == probCnt) {
            for(int i=0; i<9; i++) {
                for(int j=0; j<9; j++) {
                    bw.write(sudoku[i][j] + " ");
                }

                bw.newLine();
            }

            isEnd = true;

            return;
        }

        int x = prob.get(solveCnt).getX();
        int y = prob.get(solveCnt).getY();

        for(int j=1; j<=9; j++) {
            boolean chkA = true;
            boolean chkB = true;

            // 가로, 세로 방향 체크
            for(int k=0; k<9; k++) {
                if(j == sudoku[x][k] || j  == sudoku[k][y]) {
                    chkA = false;
                    break;
                }
            }

            if(!chkA) {
                continue;
            }

            // 3x3 영역 체크
            for(int kx=3*(x/3); kx<3*(x/3)+3; kx++) {
                for(int ky=3*(y/3); ky<3*(y/3)+3; ky++) {
                    if(j == sudoku[kx][ky]) {
                        chkB = false;
                        break;
                    }
                }

                if(!chkB) {
                    break;
                }
            }

            if(chkA && chkB) {
                sudoku[x][y] = j;
                solveCnt++;

                ///////////////////////////////////////////////////////////////////////////

                doBackTracking();

                ///////////////////////////////////////////////////////////////////////////

                solveCnt--;
                sudoku[x][y] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sudoku = new int[9][9];

        String[] in;

        prob = new ArrayList<>();

        for(int i=0; i<9; i++) {
            in = br.readLine().split(" ");

            for(int j=0; j<9; j++) {
                sudoku[i][j] = Integer.parseInt(in[j]);

                if(sudoku[i][j] == 0) {
                    prob.add(new Point(i, j));

                    probCnt++;
                }
            }
        }

        doBackTracking();

        bw.flush();

        bw.close();
        br.close();
    }
}
