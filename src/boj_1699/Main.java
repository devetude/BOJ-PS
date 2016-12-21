package boj_1699;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 1699번 (제곱수의 합) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1699
 * @author devetude
 */
public class Main {
	// 캐시 배열 (cache[N] = 제곱수 합의 항 최소 갯수)
	private static int[] cache = null;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();

		// 캐시 배열 초기화
		cache = new int[N + 1];

		// bottom-up 방식으로 밖에 해결이 안됨
		// (문제의 조건에서 N이 최대 100000이기 때문에 top-down 방식을 이용하면 stack overflow 발생)
		for (int i = 0; i <= N; i++) {
			cache[i] = i;

			for (int j = 1; j * j <= i; j++) {
				cache[i] = Math.min(cache[i], cache[i - j * j] + 1);
			}
		}

		// 결과 값 출력
		System.out.println(cache[N]);
	}
}