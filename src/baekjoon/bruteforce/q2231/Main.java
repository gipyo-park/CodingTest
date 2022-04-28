package baekjoon.bruteforce.q2231;

/**
 *  분해합
 *   - 자연수 N이 주어졌을 때 가장 작은 생성자 (N + N의 각 자리수)
 *   - https://www.acmicpc.net/problem/2231
 */

import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static int n;

    public static void calcMinimumConstructor() throws IOException {
        int tmp, sum, answer = Integer.MAX_VALUE;

        for(int i=n-1; i>=0; i--) {
            sum = i;
            tmp = i;

            while(tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }

            if(sum == n && i < answer) {
                answer = i;
            }
        }

        if(answer == Integer.MAX_VALUE) {
            bw.write(0 + "");
        }
        else {
            bw.write(answer + "");
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        calcMinimumConstructor();

        bw.flush();

        bw.close();
        br.close();
    }
}
