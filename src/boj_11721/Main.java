package boj_11721;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 11721번 (열 개씩 끊어 출력하기) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/11721
 * @author devetude
 */
public class Main {
	private static final String NEW_LINE = "\n";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] wordChars = br.readLine().toCharArray();
		br.close();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < wordChars.length; i++) {
			// 10개의 단어가 차면 줄바꿈
			if (i != 0 && i % 10 == 0) {
				sb.append(NEW_LINE);
			}

			sb.append(wordChars[i]);
		}

		// 결과 값 출력
		System.out.println(sb.toString());
	}
}