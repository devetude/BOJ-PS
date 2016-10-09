package boj_11727;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 11727번 (2×n 타일링 2) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/11727
 * @author devetude
 */
public class Main {
	// 캐시 배열
	private static int[] cache = null;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();

		// 캐시 배열 초기화
		cache = new int[n + 1];

		// 결과 값 출력
		System.out.println(fill(n));
	}

	/**
	 * 타일을 채우는 재귀 메소드
	 * 
	 * @param n
	 * @return
	 */
	private static int fill(int n) {
		// 기저조건 : n이 0 또는 1일 경우 1을 리턴
		if (n == 0 || n == 1) {
			return 1;
		}

		// 캐시 배열에 값이 있을 경우 캐시 값을 이용
		if (cache[n] != 0) {
			return cache[n];
		}

		// 점화식 : f(n) = f(n - 1) + 2f(n - 2) (단, n은 2 이상)
		return cache[n] = (fill(n - 1) + 2 * fill(n - 2)) % 10007;
	}
}