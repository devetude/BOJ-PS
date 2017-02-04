package boj_5597;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 5597번 (과제 안 내신 분..?) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/5597
 * @author devetude
 */
public class Main {
	// 개행 문자열 상수
	private static final String NEW_LINE = "\n";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] check = new boolean[31];

		for (int i = 0; i < 28; i++) {
			check[Integer.parseInt(br.readLine())] = true;
		}

		br.close();

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= 30; i++) {
			// 제출하지 않는 학생의 번호를 버퍼에 담음
			if (!check[i]) {
				sb.append(i).append(NEW_LINE);
			}
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}