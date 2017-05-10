package boj_2145;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 2145번 (숫자 놀이) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2145
 * @author devetude
 */
public class Main {
	// 문자열 상수
	private static final String NEW_LINE = "\n";
	private static final String ZERO = "0";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		String line;

		while (!(line = br.readLine()).equals(ZERO)) {
			int len;

			while ((len = line.length()) > 1) {
				int sum = 0;

				for (int i = 0; i < len; i++) {
					sum += Character.getNumericValue(line.charAt(i));
				}

				line = String.valueOf(sum);
			}

			sb.append(line).append(NEW_LINE);
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}