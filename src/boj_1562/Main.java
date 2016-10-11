package boj_1562;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 1562번 (계단 수) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/1562
 * @author devetude
 */
public class Main {
	// 모듈라 연산 상수
	private static final int MOD = 1_000_000_000;

	// 0과 9의 사용여부 상수 (모두 사용하지 않은 경우, 0만 사용한 경우, 9만 사용한 경우, 둘 다 사용한 경우)
	private static final int USE_NONE = 0;
	private static final int USE_ONLY_0 = 1;
	private static final int USE_ONLY_9 = 2;
	private static final int USE_BOTH = 3;

	// 캐시 배열 ([N][사용한 숫자][0과 9 사용여부] = 0부터 9까지 모든 숫자를 1번 이상 사용한 계단 수의 갯수)
	private static int[][][] cache = null;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();

		// 캐시 배열 초기화
		cache = new int[N + 1][10][4];

		// 조건을 만족하는 계단 수의 갯수를 담는 변수
		int counts = 0;

		// 1부터 9까지 루프를 돌면서 계단 수 중 0부터 9까지 숫자가 모두 들어간 경우의 수를 찾음
		// (계산 결과가 매우 크므로 1000000000로 모듈라 연산)
		for (int i = 1; i <= 9; i++) {
			counts += count(N - 1, i, false, false);
			counts %= MOD;
		}

		// 결과 값 출력
		System.out.println(counts);
	}

	/**
	 * 계단 수 중 0부터 9까지 숫자를 모두 1번 이상 사용한 경우의 수를 세는 재귀 메소드
	 * 
	 * @param N
	 * @param num
	 * @param isZeroChecked
	 * @param isNineChecked
	 * @return
	 */
	private static int count(int N, int num, boolean isZeroChecked, boolean isNineChecked) {
		// 기저조건1 : 숫자의 범위는 0부터 9까지 이므로 그 외에는 계단 수로 인정하지 않기에 0을 리턴
		if (num < 0 || num > 9) {
			return 0;
		}

		// 숫자가 0일 경우 0이 사용됬다는 사실을 저장
		if (num == 0) {
			isZeroChecked = true;
		}

		// 숫자가 9일 경우 9가 사용됬다는 사실을 저장
		if (num == 9) {
			isNineChecked = true;
		}

		// 기저조건2 : 모든 자리를 다 매꾸었을 경우
		if (N == 0) {
			// 0부터 9까지 모든 숫자가 1번 이상 쓰인 경우는 0과 9가 사용되었는지 확인 후 두 숫자가 쓰였다면 1을 리턴
			// (계단 수는 1씩 차이가 나게 증가하거나 감소하는데, 0과 9가 쓰였다는 것은 중간에 모든 숫자를 쓴 것)
			if (isZeroChecked && isNineChecked) {
				return 1;
			}

			// 아닐 경우 0을 리턴
			// (0과 9 중 1개라도 쓰지 않은 경우는 결과에서 제외)
			else {
				return 0;
			}
		}

		// 캐시 배열에 값이 있는 경우 캐시 값을 사용
		// 경우1 : 0과 9 둘 다 쓰지 않은 경우
		if (!isZeroChecked && !isNineChecked) {
			if (cache[N][num][USE_NONE] != 0) {
				return cache[N][num][USE_NONE];
			}
		}

		// 경우2 : 0은 사용했으나 9를 쓰지 않은 경우
		else if (isZeroChecked && !isNineChecked) {
			if (cache[N][num][USE_ONLY_0] != 0) {
				return cache[N][num][USE_ONLY_0];
			}
		}

		// 경우3: 0은 쓰지 않았으나 9는 쓴 경우
		else if (!isZeroChecked && isNineChecked) {
			if (cache[N][num][USE_ONLY_9] != 0) {
				return cache[N][num][USE_ONLY_9];
			}
		}

		// 경우4 : 0과 9 모두 사용한 경우
		else {
			if (cache[N][num][USE_BOTH] != 0) {
				return cache[N][num][USE_BOTH];
			}
		}

		// 결과 값 계산
		// (계산 결과가 매우 크므로 1000000000로 모듈라 연산)
		int res = (count(N - 1, num - 1, isZeroChecked, isNineChecked) % MOD
				+ count(N - 1, num + 1, isZeroChecked, isNineChecked) % MOD) % MOD;

		// 캐시에 결과 값 저장 및 리턴
		// 경우1 : 0과 9 둘 다 쓰지 않은 경우
		if (!isZeroChecked && !isNineChecked) {
			return cache[N][num][USE_NONE] = res;
		}

		// 경우2 : 0은 사용했으나 9를 쓰지 않은 경우
		else if (isZeroChecked && !isNineChecked) {
			return cache[N][num][USE_ONLY_0] = res;
		}

		// 경우3: 0은 쓰지 않았으나 9는 쓴 경우
		else if (!isZeroChecked && isNineChecked) {
			return cache[N][num][USE_ONLY_9] = res;
		}

		// 경우4 : 0과 9 모두 사용한 경우
		else {
			return cache[N][num][USE_BOTH] = res;
		}
	}
}