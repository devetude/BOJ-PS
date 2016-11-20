package boj_13410;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 13410번 (거꾸로 구구단) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/13410
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		br.close();

		int max = -1;

		// 루프를 돌며 거꾸로 구구단의 값 중 가장 큰 값을 찾음
		for (int i = 1; i <= K; i++) {
			max = Math.max(max, reverse(N * i));
		}

		// 결과 값 출력
		System.out.println(max);
	}

	/**
	 * 숫자를 거꾸로 뒤집는 메소드
	 * 
	 * @param n
	 * @return
	 */
	private static int reverse(int n) {
		return Integer.parseInt(new StringBuilder(String.valueOf(n)).reverse().toString());
	}
}