package boj_2789;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 2789번 (유학 금지) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2789
 * @author devetude
 */
public class Main {
	// 검열되는 문자 배열 상수
	private static final char[] SENSORSHIPED_CHARS = { 'C', 'A', 'M', 'B', 'R', 'I', 'D', 'G', 'E' };

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (final char C : br.readLine().toCharArray()) {
			// 검열되는 문자 확인 변수
			boolean isSensorshipedChar = false;

			// 검열 문자 확인
			for (final char SC : SENSORSHIPED_CHARS) {
				if (C == SC) {
					isSensorshipedChar = true;

					break;
				}
			}

			// 검열 문자가 아닌 경우에만 버퍼에 추가
			if (!isSensorshipedChar) {
				sb.append(C);
			}
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}