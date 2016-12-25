package boj_5622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 5622번 (다이얼) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/5622
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] wordChars = br.readLine().toCharArray();
		br.close();

		int sec = 0;

		// 단어의 아스키 값을 확인하여 숫자로 바꿈
		for (int wordAscii : wordChars) {
			// 예외1 : P ~ S (4개)
			if (80 <= wordAscii && wordAscii <= 83) {
				sec += 7;
			}

			// 예외2 : T ~ V (3개)
			else if (84 <= wordAscii && wordAscii <= 86) {
				sec += 8;
			}

			// 예외3 : W ~ Z (4개)
			else if (87 <= wordAscii) {
				sec += 9;
			}

			// 나머지는 3개씩 나누어 떨어짐
			else {
				sec += (wordAscii - 65) / 3 + 2;
			}
		}

		// 결과 값 출력
		System.out.println(sec + wordChars.length);
	}
}