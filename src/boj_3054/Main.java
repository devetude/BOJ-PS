package boj_3054;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 3054번 (피터팬 프레임) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/3054
 * @author devetude
 */
public class Main {
	// 개행 문자열 상수
	private static final String NEW_LINE = "\n";

	// * 문자 상수
	private static final char ASTERISK = '*';

	// 피터펜 프레임 문자 상수 배열
	private static final char[][] pFrame = { { '.', '.', '#', '.', '.' }, { '.', '#', '.', '#', '.' },
			{ '#', '.', 'X', '.', '#' }, { '.', '#', '.', '#', '.' }, { '.', '.', '#', '.', '.' } };

	// 웬디 프레임 문자 상수 배열
	private static final char[][] wFrame = { { '.', '.', '*', '.', '.' }, { '.', '*', '.', '*', '.' },
			{ '*', '.', 'X', '.', '*' }, { '.', '*', '.', '*', '.' }, { '.', '.', '*', '.', '.' } };

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		br.close();

		// 문자열의 길이를 구함
		int len = input.length();

		// 프레임의 가로 길이를 구함
		int width = len * 5 - (len - 1);

		// 캔버스 배열 초기화
		char[][] canvas = new char[5][width];

		// 보정 변수 (1번 프레임을 그릴 때 마다 1씩 증가)
		int bias = 0;

		// 루프를 돌며 프레임을 캔버스에 그림
		for (int i = 0; i < len; i++) {
			// 웬디 프레임을 그려야 하는 경우
			if (i != 0 && (i + 1) % 3 == 0) {
				for (int j = 0; j < 5; j++) {
					for (int k = 0; k < 5; k++) {
						canvas[j][5 * i + k - bias] = wFrame[j][k];
					}
				}
			}

			// 피터펜 프레임을 그려야 하는 경우
			else {
				for (int j = 0; j < 5; j++) {
					for (int k = 0; k < 5; k++) {
						canvas[j][5 * i + k - bias] = pFrame[j][k];
					}
				}

				// 이전 프레임이 웬디 프레임이라면
				if (i >= 3 && i % 3 == 0) {
					// #으로 잘못 덮어쓴 부분을 *로 치환
					canvas[2][5 * i - bias] = ASTERISK;
				}
			}

			// 단어 문자 삽입
			canvas[2][5 * i + 2 - bias] = input.charAt(i);

			// 보정 변수 1 증가
			bias++;
		}

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < width; j++) {
				sb.append(canvas[i][j]);
			}

			sb.append(NEW_LINE);
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}