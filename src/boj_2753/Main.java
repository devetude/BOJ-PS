package boj_2753;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 2753 (윤년) 문제풀이
 *
 * @author devetude
 * @see https://www.acmicpc.net/problem/2753
 */
public class Main {
    private static final int TRUE = 1;
    private static final int FALSE = 0;

    public static void main(String args[]) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int year = Integer.parseInt(br.readLine());

            if (year % 4 != 0) {
                System.out.print(FALSE);
                return;
            }

            if (year % 100 == 0 && year % 400 != 0) {
                System.out.print(FALSE);
                return;
            }

            System.out.print(TRUE);
        } catch (Exception ignored) {
        }
    }
}
