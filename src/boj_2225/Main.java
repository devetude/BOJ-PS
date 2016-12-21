package boj_2225;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2225번 (합분해) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2225
 * @author devetude
 */
public class Main {
	// 모듈러 상수
	private static final int MOD = 1_000_000_000;

	// 캐시 배열 (cache[N][M] = 0부터 N까지 정수 K개를 더한 합이 N이 되는 경우의 수)
	private static int[][] cache = null;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 캐시 배열 초기화
		cache = new int[N + 1][M + 1];

		// 결과 값 출력
		System.out.println(count(N, M));
	}

	/**
	 * 경우의 수 재귀 메소드
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	private static int count(int n, int m) {
		// 기저조건 : m이 0인 경우
		if (m == 0) {
			// n이 0이면 1 리턴 (가능한 경우의 수)
			if (n == 0) {
				return 1;
			}

			// n이 남아있는 경우 0 리턴 (경우의 수가 아님)
			else {
				return 0;
			}
		}

		// 캐시 값이 있는 경우 캐시 값 사용
		if (cache[n][m] != 0) {
			return cache[n][m];
		}

		// 경우의 수 변수
		int totalCnt = 0;

		// 0부터 n까지 루프를 돌며 가능한 경우의 수를 셈
		for (int i = 0; i <= n; i++) {
			totalCnt += count(n - i, m - 1);

			// int의 범위를 넘어가므로 모듈러 연산 실행
			totalCnt %= MOD;
		}

		// 결과 값을 캐시 배열에 저장 및 리턴
		return cache[n][m] = totalCnt;
	}
}