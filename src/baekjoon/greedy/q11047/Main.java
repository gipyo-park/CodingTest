package baekjoon.greedy.q11047;

/**
 *  동전 0
 *   - 금액 K원을 만드는 데 필요한 동전 개수의 최솟값
 *   - https://www.acmicpc.net/problem/11047
 */

import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static int n, k, answer;

    static int[] money;

    public static void doCalc() throws IOException {
        answer = 0;

        for(int i=n-1; i>=0; i--) {
            while(k >= money[i]) {
                k -= money[i];
                answer++;
            }

            if(k == 0) {
                bw.write(answer + "");
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String in = br.readLine();

        n = Integer.parseInt(in.split(" ")[0]);
        k = Integer.parseInt(in.split(" ")[1]);

        money = new int[n];

        for(int i=0; i<n; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }

        doCalc();

        bw.flush();

        bw.close();
        br.close();
    }
}
