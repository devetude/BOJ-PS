package boj_2804;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2804번 (크로스워드 만들기) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2804
 * @author devetude
 */
public class Main {
	// 문자열 상수
	private static final String NEW_LINE = "\n";
	private static final String DOT = ".";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();

		// A, B 문자열을 char 배열 형태로 가져옴
		char[] aChars = st.nextToken().toCharArray();
		char[] bChars = st.nextToken().toCharArray();

		// 공유 행, 열 저장 변수
		int sharedRow = -1;
		int sharedCol = -1;

		// 루프를 돌며 공유하는 글자가 위치하는 행, 열을 구함
		MAIN_LOOP: for (int i = 0; i < aChars.length; i++) {
			for (int j = 0; j < bChars.length; j++) {
				// 공유하는 글자가 발견된 경우
				if (aChars[i] == bChars[j]) {
					sharedRow = j;
					sharedCol = i;

					break MAIN_LOOP;
				}
			}
		}

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < bChars.length; i++) {
			for (int j = 0; j < aChars.length; j++) {
				// 공유하는 행 일 경우 A 문자 배열의 j번째로 채움
				if (sharedRow == i) {
					sb.append(aChars[j]);
				}

				// 공유하는 열 일 경우 B 문자 배열의 i번째로 채움
				else if (sharedCol == j) {
					sb.append(bChars[i]);
				}

				// 그 외 점으로 채움
				else {
					sb.append(DOT);
				}
			}

			sb.append(NEW_LINE);
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}