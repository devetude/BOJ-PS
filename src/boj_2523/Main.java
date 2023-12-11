package boj_2523;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 백준 온라인 저지 2523번 (별 찍기 - 13) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2523
 * @author devetude
 */
public class Main {
    private static final String STAR = "*";
    private static final String NEW_LINE = "\n";

    public static void main(String args[]) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());

            for (int i = 1; i < n; i++) {
                for (int j = 1; j <= i; j++) {
                    bw.write(STAR);
                }
                bw.write(NEW_LINE);
            }
            for (int i = 1; i <= n; i++) {
                bw.write(STAR);
            }
            bw.write(NEW_LINE);
            for (int i = n - 1; 0 < i; i--) {
                for (int j = 1; j <= i; j++) {
                    bw.write(STAR);
                }
                bw.write(NEW_LINE);
            }

            bw.flush();
        } catch (Exception ignored) {
        }
    }
}
