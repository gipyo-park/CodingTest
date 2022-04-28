package baekjoon.backtracking.q15652;

/**
 *  N과 M(4)
 *   - 1부터 N까지 자연수 중에서 M개를 고른 수열 (단, 수열은 비내림차순을 만족해야 한다.)
 *   - https://www.acmicpc.net/problem/15652
 */

import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static int[] arr;
    static boolean[] visited;

    public static void doBackTracking(int n, int m, int depth) throws IOException {
        if(m == depth) {
            for(int i=0; i<m; i++) {
                bw.write(arr[i] + " ");
            }
            bw.newLine();

            return;
        }

        for(int i=1; i<=n; i++) {
            if(visited[i]) {
                continue;
            }

            // 시작 숫자 미만의 수를 모두 방문 처리한다. (비내림차순 유지)
            for(int j=1; j<i; j++) {
                visited[j] = true;
            }

            arr[depth] = i;
            doBackTracking(n, m, depth+1);

            for(int j=1; j<i; j++) {
                visited[j] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inStr = br.readLine().split(" ");
        int n = Integer.parseInt(inStr[0]);
        int m = Integer.parseInt(inStr[1]);

        arr = new int[n+1];
        visited = new boolean[n+1];

        doBackTracking(n, m, 0);

        bw.flush();

        bw.close();
        br.close();
    }
}