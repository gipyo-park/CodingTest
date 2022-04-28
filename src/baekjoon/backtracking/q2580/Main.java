package baekjoon.backtracking.q2580;

/**
 *  스도쿠
 *   - 9x9의 스도쿠 판이 주어질 때 빈 칸이 채워진 최종 모습을 출력
 *   - https://www.acmicpc.net/problem/2580
 */

import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static int[][] sudoku;

    static int probCnt, solveCnt;
    static String[] prob;

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

        int x = Integer.parseInt(prob[solveCnt].split(",")[0]);
        int y = Integer.parseInt(prob[solveCnt].split(",")[1]);

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
        String tmp = "";

        for(int i=0; i<9; i++) {
            in = br.readLine().split(" ");

            for(int j=0; j<9; j++) {
                sudoku[i][j] = Integer.parseInt(in[j]);

                if(sudoku[i][j] == 0) {
                    tmp += i + "," + j + " ";
                    probCnt++;
                }
            }
        }

        prob = tmp.split(" ");

        doBackTracking();

        bw.flush();

        bw.close();
        br.close();
    }
}
