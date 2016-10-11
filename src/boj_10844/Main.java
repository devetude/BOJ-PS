package boj_10844;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 10844번 (쉬운 계단 수) 문제풀이
 * 
 * @see https://www.acmicpc.net/submit/10844
 * @author devetude
 */
public class Main {
	// 모듈라 연산 상수
	private static final int MOD = 1_000_000_000;

	// 캐시 배열 ([N][사용한 숫자] = 계단 수의 갯수)
	private static int[][] cache = null;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();

		// 캐시 배열 초기화
		cache = new int[N + 1][10];

		// 계단 수의 갯수를 담는 변수
		int counts = 0;

		// 첫째 자리는 1부터 9까지 가능하므로 루프를 돌면서 계단수의 갯수를 셈
		// (계산 결과가 매우 크므로 1000000000로 모듈라 연산)
		for (int i = 1; i <= 9; i++) {
			counts += count(N - 1, i);
			counts %= MOD;
		}

		// 결과 값 출력
		System.out.println(counts);
	}

	/**
	 * 계단 수의 갯수를 세는 재귀 메소드
	 * 
	 * @param N
	 * @param num
	 * @return
	 */
	private static int count(int N, int num) {
		// 기저조건1 : 숫자의 범위는 0부터 9까지 이므로 그 외에는 계단 수로 인정하지 않기에 0을 리턴
		if (num < 0 || num > 9) {
			return 0;
		}

		// 기저조건2 : 모든 자리를 다 매꾸었을 경우 1개의 경우가 완성되므로 1을 리턴
		if (N == 0) {
			return 1;
		}

		// 캐시 배열에 값이 있는 경우 캐시 값을 사용
		if (cache[N][num] != 0) {
			return cache[N][num];
		}

		// 결과 값을 캐시 배열에 저장하고 리턴
		// 계단 수는 현재 숫자의 값 보다 1 크거나 혹은 1 작아야 함
		// 점화식 : dp[i][j] = f(i - 1, j - 1) + f(i - 1, j + 1)
		// (계산 결과가 매우 크므로 1000000000로 모듈라 연산)
		return cache[N][num] = (count(N - 1, num - 1) % MOD + count(N - 1, num + 1) % MOD) % MOD;
	}
}