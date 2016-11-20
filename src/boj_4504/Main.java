package boj_4504;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 4504번 (배수 찾기) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/4504
 * @author devetude
 */
public class Main {
	private static final String IS_SENTENCE = " is a multiple of ";
	private static final String IS_NOT_SENTENCE = " is NOT a multiple of ";
	private static final String DOT_AND_NEW_LINE = ".\n";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (true) {
			int num = Integer.parseInt(br.readLine());

			// 입력 값이 0일 경우 루프를 종료
			if (num == 0) {
				break;
			}

			// 버퍼를 이용해 결과 값을 만듬
			sb.append(num);
			if (num % n == 0)
				sb.append(IS_SENTENCE);
			else
				sb.append(IS_NOT_SENTENCE);
			sb.append(n).append(DOT_AND_NEW_LINE);
		}

		br.close();

		// 결과 값 출력
		System.out.println(sb.toString());
	}
}