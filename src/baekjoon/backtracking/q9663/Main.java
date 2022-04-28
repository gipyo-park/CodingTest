package baekjoon.backtracking.q9663;

/**
 *  N-Queen
 *   - 크기가 N X N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 방법의 수
 *   - https://www.acmicpc.net/problem/9663
 */

import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static int n;
    static int[][] arr;
    static int[][] visited;

    static int answer;

    public static void doBackTracking(int depth) throws IOException {
        if(n == depth) {
            /**
             for(int i=0; i<n; i++) {
             for(int j=0; j<n; j++) {
             bw.write(arr[i][j] + " ");
             }
             bw.newLine();
             }

             bw.newLine();
             */

            answer++;

            return;
        }

        for(int i=0; i<n; i++) {
            if(visited[depth][i] > 0) {
                continue;
            }

            // 현재 Cell 방문 처리
            visited[depth][i]++;
            arr[depth][i] = 1;

            // 아래쪽 방향 Cell 방문 처리
            for(int j=depth+1; j<n; j++) {
                visited[j][i]++;
            }

            // 아래쪽 좌우측 방향 Cell 방문 처리
            int lvl = 1;
            for(int j=depth+1; j<n; j++) {
                // 좌측
                if(i-lvl >= 0) {
                    visited[j][i-lvl]++;
                }
                // 우측
                if(i+lvl < n) {
                    visited[j][i+lvl]++;
                }

                lvl++;
            }

            ///////////////////////////////////////////////////////////

            doBackTracking(depth+1);

            ///////////////////////////////////////////////////////////

            visited[depth][i]--;
            arr[depth][i] = 0;

            for(int j=depth+1; j<n; j++) {
                visited[j][i]--;
            }

            lvl = 1;
            for(int j=depth+1; j<n; j++) {
                if(i-lvl >= 0) {
                    visited[j][i-lvl]--;
                }

                if(i+lvl < n) {
                    visited[j][i+lvl]--;
                }

                lvl++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new int[n][n];

        doBackTracking(0);

        bw.write(answer + "");
        bw.flush();

        bw.close();
        br.close();
    }
}
