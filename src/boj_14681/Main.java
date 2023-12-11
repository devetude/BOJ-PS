package boj_14681;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 14681번 (사분면 고르기) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/14681
 * @author devetude
 */
public class Main {
    private static final int QUADRANT_1 = 1;
    private static final int QUADRANT_2 = 2;
    private static final int QUADRANT_3 = 3;
    private static final int QUADRANT_4 = 4;

    public static void main(String args[]) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int x = Integer.parseInt(br.readLine());
            int y = Integer.parseInt(br.readLine());

            int quadrant = 0 < x
                    ? 0 < y ? QUADRANT_1 : QUADRANT_4
                    : 0 < y ? QUADRANT_2 : QUADRANT_3;
            System.out.print(quadrant);
        } catch (Exception ignored) {
        }
    }
}
