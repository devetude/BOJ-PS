package boj_11051;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 11051번 (이항 계수 2) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/11051
 * @author devetude
 */
public class Main {
	// 캐시 변수
	private static int[][] cache = null;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		br.close();

		// 캐시 변수 초기화
		cache = new int[N + 1][K + 1];

		// 결과 값 출력
		System.out.println(bino(N, K));
	}

	/**
	 * 이항계수를 구하는 재귀 메소드
	 * 
	 * @param N
	 * @param K
	 * @return
	 */
	private static int bino(int N, int K) {
		// 기저조건 : K == 0이거나 N == K일 경우 1을 리턴
		if (K == 0 || N == K) {
			return 1;
		}

		// 캐시 값이 있을 경우 캐시 값을 리턴
		if (cache[N][K] != 0) {
			return cache[N][K];
		}

		// 재귀 호출
		return cache[N][K] = (bino(N - 1, K - 1) + bino(N - 1, K)) % 10007;
	}
}