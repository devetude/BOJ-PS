package boj_11057;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 11057번 (오르막 수) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/11057
 * @author devetude
 */
public class Main {
	// 모듈라 상수
	private static final int MOD = 10_007;

	// 캐시 배열 ([0 ~ 9][숫자의 길이] = 경우의 수)
	private static int[][] cache = null;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();

		// 캐시 배열 초기화
		cache = new int[11][N];

		// 경우의 수 변수
		int counts = 0;

		// 루프를 돌며 경우의 수를 셈
		// (결과 값이 매우 크므로 모듈라 상수를 이용하여 나눔)
		for (int i = 0; i <= 9; i++) {
			counts += count(N, i, 1);
			counts %= MOD;
		}

		// 결과 값 출력
		System.out.println(counts);
	}

	/**
	 * 오르막 수의 갯수를 새는 재귀 메소드
	 * 
	 * @param N
	 * @param beforeNum
	 * @param size
	 * @return
	 */
	private static int count(int N, int beforeNum, int length) {
		// 기저조건 : 숫자의 길이가 N과 같을 경우 1가지 경우 임으로 1을 리턴
		if (length == N) {
			return 1;
		}

		// 캐시 배열에 값이 있는 경우 캐시 값을 사용
		if (cache[beforeNum][length] != 0) {
			return cache[beforeNum][length];
		}

		// 경우의 수 변수
		int counts = 0;

		// 루프를 돌며 경우의 수를 셈
		// (결과 값이 매우 크므로 모듈라 상수를 이용하여 나눔)
		for (int i = beforeNum; i <= 9; i++) {
			counts += count(N, i, length + 1);
			counts %= MOD;
		}

		// 결과 값을 캐시에 저장 및 리턴
		return cache[beforeNum][length] = counts;
	}
}