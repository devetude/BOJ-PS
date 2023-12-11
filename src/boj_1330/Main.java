package boj_1330;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 1330 (두 수 비교하기) 문제풀이
 *
 * @author devetude
 * @see https://www.acmicpc.net/problem/1330
 */
public class Main {
    private static final String SPACE = " ";
    private static final String EQUAL_TO = "==";
    private static final String LESS_THAN = "<";
    private static final String GREATER_THAN = ">";

    public static void main(String args[]) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = br.readLine().split(SPACE);

            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);

            System.out.print(a == b ? EQUAL_TO : a < b ? LESS_THAN : GREATER_THAN);
        } catch (Exception ignored) {
        }
    }
}
