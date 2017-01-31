package boj_10886;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 10886번 (0 = not cute / 1 = cute) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/10886
 * @author devetude
 */
public class Main {
	// 귀여움 상수
	private static final int IS_CUTE = 1;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int res = 0;

		for (int i = 0; i < N; i++) {
			// 귀여울 경우 +1
			if (Integer.parseInt(br.readLine()) == IS_CUTE) {
				res++;
			}

			// 귀엽지 않을 경우 -1
			else {
				res--;
			}
		}

		br.close();

		// 결과 값 출력
		if (res > 0) {
			System.out.println("Junhee is cute!");
		}

		else {
			System.out.println("Junhee is not cute!");
		}
	}
}