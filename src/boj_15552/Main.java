package boj_15552;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 백준 온라인 저지 15552번 (빠른 A+B) 문제풀이
 *
 * @author devetude
 * @see https://www.acmicpc.net/problem/15552
 */
public class Main {
    private static final char SPACE = ' ';
    private static final char NEW_LINE = '\n';
    private static final int ASCII_1_CODE = 48;

    public static void main(String args[]) {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int t = Integer.parseInt(br.readLine());

            while (0 < t--) {
                bw.write(String.valueOf(read(br, SPACE) + read(br, NEW_LINE)));
                bw.write(NEW_LINE);
            }

            bw.flush();
        } catch (Exception ignored) {
        }
    }

    private static int read(BufferedReader br, char eor) throws IOException {
        StringBuilder sb = new StringBuilder();
        int i;
        while ((i = br.read()) != eor) sb.append(i - ASCII_1_CODE);
        return Integer.parseInt(sb.toString());
    }
}
