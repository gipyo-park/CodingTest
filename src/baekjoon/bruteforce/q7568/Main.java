package baekjoon.bruteforce.q7568;

/**
 *  덩치
 *   - N명의 집단에서 키와 몸무게를 비교하여 덩치 등수를 계산
 *   - https://www.acmicpc.net/problem/7568
 */

import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static int n;

    static int[][] person;

    public static void calcRank() throws IOException {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i == j) {
                    continue;
                }

                if(person[i][0] < person[j][0] && person[i][1] < person[j][1]) {
                    person[i][2]++;
                }
            }
        }

        for(int i=0; i<n; i++) {
            bw.write((person[i][2] + 1) + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        person = new int[n][3];

        for(int i=0; i<n; i++) {
            String[] in = br.readLine().split(" ");

            person[i][0] = Integer.parseInt(in[0]);
            person[i][1] = Integer.parseInt(in[1]);
        }

        calcRank();

        bw.flush();

        bw.close();
        br.close();
    }
}
