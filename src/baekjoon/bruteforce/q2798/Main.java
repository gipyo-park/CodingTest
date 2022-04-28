package baekjoon.bruteforce.q2798;

/**
 *  블랙잭
 *   - N장의 카드 중 세 장의 카드를 뽑았을 때 합이 M을 넘지 않는 최대의 수
 *   - https://www.acmicpc.net/problem/2798
 */

import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static int n, m;
    static int[] card;

    public static void calcMaximumSum() throws IOException {
        int answer = 0;
        int sum = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i==j) {
                    continue;
                }

                for(int k=0; k<n; k++) {
                    if(i==k || j==k) {
                        continue;
                    }

                    sum = card[i] + card[j] + card[k];

                    if(answer < sum && sum <= m) {
                        answer = sum;
                    }
                }
            }
        }

        bw.write(answer + "");
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

        calcMaximumSum();

        bw.flush();

        bw.close();
        br.close();
    }
}
