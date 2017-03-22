package boj_11729;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 11729번 (하노이 탑 이동 순서) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/11729
 * @author devetude
 */
public class Main {
	// 문자 상수
	private static final char SPACE = ' ';
	private static final char NEW_LINE = '\n';

	// 결과 값 저장 버퍼 객체 변수
	private static StringBuilder sb = null;

	// 이동 횟수 저장 변수
	private static int cnt = 0;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());

		br.close();

		// 결과 값 저장 버퍼 객체 변수 초기화
		sb = new StringBuilder();

		// 하노이 탑 이동
		move(K, 1, 3, 2);

		// 결과 값 출력
		System.out.println(cnt);
		System.out.println(sb.toString());
	}

	/**
	 * 하노이 탑 이동 재귀 메소드
	 * 
	 * @param n
	 * @param from
	 * @param to
	 * @param tmp
	 */
	private static void move(int n, int from, int to, int tmp) {
		if (n == 1) {
			// 이동 횟수 1 증가
			cnt++;

			// 버퍼에 이동 결과 저장
			sb.append(from).append(SPACE).append(to).append(NEW_LINE);

			return;
		}

		move(n - 1, from, tmp, to);
		move(1, from, to, tmp);
		move(n - 1, tmp, to, from);
	}
}