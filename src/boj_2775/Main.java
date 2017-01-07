package boj_2775;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 2775번 (부녀회장이 될테야) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2775
 * @author devetude
 */
public class Main {
	// 개행 문자열 상수
	private static final String NEW_LINE = "\n";

	// 캐시 배열 (cache[k][n] = k층 n호에 사는 사람 수)
	private static int[][] cache = null;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// 결과 값을 저장 할 버퍼 초기화
		StringBuilder sb = new StringBuilder();

		while (T-- != 0) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());

			// 캐시 배열 초기화
			cache = new int[k + 1][n + 1];

			// 버퍼를 이용해 결과 값을 만듬
			sb.append(getPeopleCnt(k, n)).append(NEW_LINE);
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}

	/**
	 * k층 n호에 사는 사람 수를 계산하는 재귀 메소드
	 * 
	 * @param k
	 * @param n
	 * @return
	 */
	private static int getPeopleCnt(int k, int n) {
		// 기저조건 : 0층 일 경우 호수 만큼 사람 수 리턴
		if (k == 0) {
			return n;
		}

		// 캐시 값이 있는 경우 캐시 값 사용
		if (cache[k][n] != 0) {
			return cache[k][n];
		}

		int peopleCnt = 0;

		// k층 n호에 사는 사람 수 계산
		for (int i = 1; i <= n; i++) {
			peopleCnt += getPeopleCnt(k - 1, i);
		}

		// 결과 값을 캐시에 저장 후 리턴
		return cache[k][n] = peopleCnt;
	}
}