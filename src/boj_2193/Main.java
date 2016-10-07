package boj_2193;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 2193번 (이친수) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/2193
 * @author devetude
 */
public class Main {
	// 캐시 변수
	private static long[] cache = null;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();

		// 캐시 변수 초기화
		cache = new long[N + 1];

		// 결과 값 출력
		System.out.println(getPinaryNumCounts(N));
	}

	/**
	 * 이친수의 갯수를 구하는 재귀 메소드
	 * 
	 * @param N
	 * @return
	 */
	private static long getPinaryNumCounts(int N) {
		// 기저조건 : 2보다 작을 경우 1을 리턴
		if (N <= 2) {
			return 1;
		}

		// 캐시 값이 있을 경우 캐시 값 사용
		if (cache[N] != 0) {
			return cache[N];
		}

		// 점화식 : f(n) = f(n - 1) + f(n - 2) 재귀 호출
		return cache[N] = getPinaryNumCounts(N - 1) + getPinaryNumCounts(N - 2);
	}
}