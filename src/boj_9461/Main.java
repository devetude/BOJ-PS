package boj_9461;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 9461번 (파도반 수열) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/9461
 * @author devetude
 */
public class Main {
	// 캐시 배열
	private static long[] cache = new long[101];

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		// 캐시 배열 초기화 (1항부터 3항까지는 1로 초기화)
		cache[1] = cache[2] = cache[3] = 1;

		for (int i = 0; i < T; i++) {
			// 파도반 수열을 결과 값을 버퍼에 저장
			sb.append(padovan(Integer.parseInt(br.readLine()))).append("\n");
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}

	/**
	 * 파도반 수열 재귀 메소드
	 * 
	 * @param n
	 * @return
	 */
	private static long padovan(int n) {
		// 캐시 배열에 값이 있을 경우 캐시 값을 사용
		if (cache[n] != 0) {
			return cache[n];
		}

		// 파도반 수열의 점화식 : f(n) = f(n - 3) + f(n - 2) (단, n >= 4)
		return cache[n] = padovan(n - 3) + padovan(n - 2);
	}
}