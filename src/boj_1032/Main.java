package boj_1032;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 1032번 (명령 프롬프트) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1032
 * @author devetude
 */
public class Main {
	// 물음표 문자열 상수
	private static final String QUESTION_MARK = "?";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 기준 문자 배열을 받음
		char[] baseChars = br.readLine().toCharArray();

		// 기준 문자 배열과 다른 인덱스를 저장하는 배열 초기화
		boolean[] isDiff = new boolean[baseChars.length];

		while (N-- > 1) {
			char[] chars = br.readLine().toCharArray();

			for (int i = 0; i < baseChars.length; i++) {
				// 이미 다르다고 판단이 된 인덱스 일 경우
				if (isDiff[i])
					continue;

				// 기준 문자와 다른 경우
				if (baseChars[i] != chars[i])
					isDiff[i] = true;
			}
		}

		br.close();

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < baseChars.length; i++) {
			if (isDiff[i]) {
				sb.append(QUESTION_MARK);
			} else {
				sb.append(baseChars[i]);
			}
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}