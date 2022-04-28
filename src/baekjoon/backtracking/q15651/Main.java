package baekjoon.backtracking.q15651;

/**
 *  N과 M(3)
 *   - 1부터 N까지 자연수 중에서 M개를 고른 수열
 *   - https://www.acmicpc.net/problem/15651
 */

import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static int[] arr;
//    static boolean[] visited;

    public static void doBackTracking(int n, int m, int depth) throws IOException {
        if(m == depth) {
            for(int i=0; i<m; i++) {
                bw.write(arr[i] + " ");
            }
            bw.newLine();

            return;
        }

        for(int i=1; i<=n; i++) {
//            if(visited[i]) {
//                continue;
//            }

//            visited[i] = true;
            arr[depth] = i;
            doBackTracking(n, m, depth+1);
//            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inStr = br.readLine().split(" ");
        int n = Integer.parseInt(inStr[0]);
        int m = Integer.parseInt(inStr[1]);

        arr = new int[n+1];
//        visited = new boolean[n+1];

        doBackTracking(n, m, 0);

        bw.flush();

        bw.close();
        br.close();
    }
}