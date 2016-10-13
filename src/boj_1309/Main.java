package boj_1309;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 6398번 (동물원) 문제풀이
 *
 * @see https://www.acmicpc.net/board/view/6398
 * @author devetude
 */
public class Main {
	// 모듈라 상수
	private static final int MOD = 9901;

	// 캐시 배열 ([행] = 경우의 수)
	private static int[] cache = null;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();

		// 캐시 배열 초기화
		cache = new int[N + 1];
		cache[0] = 1;
		cache[1] = 3;

		// 결과 값 출력
		System.out.println(count(N));
	}

	/**
	 * 경우의 수를 구하는 재귀 메소드
	 * 
	 * @param N
	 * @return
	 */
	private static int count(int N) {
		// 캐시 배열에 값이 있을 경우 캐시 값을 사용
		if (cache[N] != 0) {
			return cache[N];
		}

		// 결과 값을 캐시에 저장 및 리턴
		// 점화식 : f(n) = f(n - 2) + 2 * f(n - 1) (단, n은 2 이상)
		return cache[N] = (count(N - 2) + 2 * count(N - 1)) % MOD;
	}
}