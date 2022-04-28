package baekjoon.backtracking.q2798;

/**
 *  블랙잭 (ver. Back-Tracking)
 *   - N장의 카드 중 세 장의 카드를 뽑았을 때 합이 M을 넘지 않는 최대의 수
 *   - https://www.acmicpc.net/problem/2798
 */

import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static int n, m;
    static int[] card;

    static int answer;

    static int[] arr;
    static boolean[] visited;

    public static void calcMaximumSum(int depth) {
        if(depth == 3) {
            if(answer < arr[0] + arr[1] + arr[2] && arr[0] + arr[1] + arr[2] <= m) {
                answer = arr[0] + arr[1] + arr[2];
            }
            return;
        }

        for(int i=0; i<n; i++) {
            if(visited[i]) {
                continue;
            }

            visited[i] = true;
            arr[depth] = card[i];

            calcMaximumSum(depth+1);

            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = br.readLine().split(" ");

        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);

        String[] in2 = br.readLine().split(" ");

        card = new int[n];

        for(int i=0; i<n; i++) {
            card[i] = Integer.parseInt(in2[i]);
        }

        arr = new int[3];
        visited = new boolean[n];

        calcMaximumSum(0);

        bw.write(answer + "");

        bw.flush();

        bw.close();
        br.close();
    }
}
