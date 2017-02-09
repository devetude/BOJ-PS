package boj_3023;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 3023번 (마술사 이민혁) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/3023
 * @author devetude
 */
public class Main {
	// 문자열 상수
	private static final String NEW_LINE = "\n";
	private static final String SHARP = "#";
	private static final String DOT = ".";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		// 패턴을 저장 할 카드 배열 초기화
		String[][] card = new String[R * 2][C * 2];

		// 루프를 돌며 상단 좌, 우 패턴을 만듬
		for (int i = 0; i < R; i++) {
			String[] patterns = br.readLine().split("");

			for (int j = 0; j < C; j++) {
				card[i][j] = patterns[j];
			}

			for (int j = 0; j < C; j++) {
				card[i][2 * C - j - 1] = card[i][j];
			}
		}

		// 루프를 돌며 하단 패턴을 만듬
		int gap = 1;

		for (int i = R; i < card.length; i++) {
			for (int j = 0; j < card[i].length; j++) {
				card[i][j] = card[R - gap][j];
			}

			gap++;
		}

		st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken()) - 1;
		int B = Integer.parseInt(st.nextToken()) - 1;

		br.close();

		// 의도된 에러를 넣음
		card[A][B] = card[A][B].equals(SHARP) ? DOT : SHARP;

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (String[] row : card) {
			for (String col : row) {
				sb.append(col);
			}

			sb.append(NEW_LINE);
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}