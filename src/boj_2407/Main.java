package boj_2407;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2407번 (조합) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2407
 * @author devetude
 */
public class Main {
	// 캐시 배열 ([n][m] = 이항계수 결과 값)
	private static BigDecimal[][] cache = null;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		br.close();

		// 캐시 배열 초기화
		cache = new BigDecimal[n + 1][m + 1];

		// 결과 값 출력
		System.out.println(bino(n, m));
	}

	/**
	 * 이항계수를 구하는 재귀 메소드
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	private static BigDecimal bino(int n, int m) {
		// 기저조건 : m이 0 이거나, m이 n과 같을 경우 1을 리턴
		if (m == 0 || m == n) {
			return BigDecimal.ONE;
		}

		// 캐시 배열에 값이 있는 경우 캐시 배열 사용
		if (cache[n][m] != null) {
			return cache[n][m];
		}

		// 캐시 배열에 결과 값 저장 및 리턴
		// 점화식 nCm = n-1Cm-1 + n-1Cm (0 < m < n 일 때만)
		return cache[n][m] = bino(n - 1, m - 1).add(bino(n - 1, m));
	}
}