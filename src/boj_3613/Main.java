package boj_3613;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 3613번 (Java vs C++) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/3613
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String param = br.readLine();
		char[] chars = param.toCharArray();

		br.close();

		// 에러 1 : '_'로 시작하는 경우
		// 에러 2 : '_'로 끝나는 경우
		// 에러 3 : 대문자로 시작하는 경우
		if (chars[0] == '_' || chars[chars.length - 1] == '_' || ('A' <= chars[0] && chars[0] <= 'Z')) {
			System.out.println("Error!");

			return;
		}

		boolean isJava = true;
		boolean isCpp = true;

		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '_') {
				// 에러 4 : '_'가 연속으로 2번 이상 붙어있는 경우
				if (i > 1 && chars[i - 1] == '_') {
					System.out.println("Error!");

					return;
				}

				isJava = false;
			}

			else if ('A' <= chars[i] && chars[i] <= 'Z') {
				isCpp = false;
			}
		}

		// 에러 5 : 대문자와 '_'를 혼용하여 쓴 경우
		if (!isJava && !isCpp) {
			System.out.println("Error!");

			return;
		}

		// 모든 글자가 소문자라서 java와 c++ 모두 해당하는 경우 그냥 입력받은 문자열 출력
		if (isJava && isCpp) {
			System.out.println(param);

			return;
		}

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		// java의 경우 대문자를 '_소문자'로 변경
		if (isJava) {
			for (char c : chars) {
				if ('A' <= c && c <= 'Z') {
					sb.append('_').append((char) (c + 32));
				}

				else {
					sb.append(c);
				}
			}
		}

		// c++의 경우 '_소문자'를 대문자로 변경
		else {
			for (int i = 0; i < chars.length; i++) {
				if (chars[i] == '_' && i < chars.length - 1) {
					sb.append((char) (chars[++i] - 32));
				}

				else {
					sb.append(chars[i]);
				}
			}
		}

		// 결과 값 출력
		System.out.println(sb.toString());
	}
}