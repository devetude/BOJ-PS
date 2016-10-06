package boj_1463;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 1463번 (1로 만들기) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/1463
 * @author devetude
 */
public class Main {
	// 캐시 변수
	private static int[] cache = null;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();

		// 캐시 변수 할당
		cache = new int[N + 1];

		// 결과 값 출력
		System.out.println(process(N));
	}

	/**
	 * 동적계획법 재귀 메소드
	 * 
	 * @param X
	 * @return
	 */
	private static int process(int X) {
		// 기저조건 : X가 1보다 작거나 같을 경우
		if (X <= 1) {
			return 0;
		}

		// 캐시 값이 있는 경우 캐시 값을 리턴
		if (cache[X] != 0) {
			return cache[X];
		}

		// 가장 작은 값을 int형 가장 큰 값으로 초기화
		int minCounts = Integer.MAX_VALUE;

		// 3으로 나누어 떨어질 경우 (X / 3 재귀 호출)
		if (X % 3 == 0) {
			minCounts = Math.min(minCounts, process(X / 3) + 1);
		}

		// 2로 나누어 떨어질 경우 (X / 2 재귀 호출)
		if (X % 2 == 0) {
			minCounts = Math.min(minCounts, process(X / 2) + 1);
		}

		// X - 1 재귀 호출
		minCounts = Math.min(minCounts, process(X - 1) + 1);

		// 최소 값을 캐시에 저장하고 리턴
		return cache[X] = minCounts;
	}
}