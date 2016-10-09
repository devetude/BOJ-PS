package boj_9590;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 9095번 (1, 2, 3 더하기) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/9095
 * @author devetude
 */
public class Main {
	// 캐시 배열
	private static int[] cache = new int[12];

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// 캐시 값 초기화 (기저조건 입력)
		cache[1] = 1;
		cache[2] = 2;
		cache[3] = 4;

		// 버퍼를 이용해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < T; i++) {
			sb.append(count(Integer.parseInt(br.readLine()))).append("\n");
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}

	/**
	 * 경우의 수를 세는 재귀 메소드
	 * 
	 * @param n
	 * @return
	 */
	private static int count(int n) {
		// 캐시 배열에 값이 있을 경우 캐시 값을 이용
		if (cache[n] != 0) {
			return cache[n];
		}

		// 점화식 : f(n) = f(n - 3) + f(n - 2) + f(n - 1) (단, n는 4이상)
		return cache[n] = count(n - 3) + count(n - 2) + count(n - 1);
	}
}