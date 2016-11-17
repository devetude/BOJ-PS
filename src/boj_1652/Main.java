package boj_1652;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 1652번 (누울 자리를 찾아라) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1475
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] room = new char[N][];

		for (int i = 0; i < N; i++) {
			room[i] = br.readLine().toCharArray();
		}

		br.close();

		// 수평(가로)으로 가능한 갯수를 찾음
		int verticalAvailableCnt = 0;
		int comboCnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (room[i][j] == '.') {
					comboCnt++;
				}

				else {
					if (comboCnt >= 2) {
						verticalAvailableCnt++;
					}

					comboCnt = 0;
				}
			}

			if (comboCnt >= 2) {
				verticalAvailableCnt++;
			}

			comboCnt = 0;
		}

		// 수직(세로)으로 가능한 갯수를 찾음
		int horizontalAvailableCnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (room[j][i] == '.') {
					comboCnt++;
				}

				else {
					if (comboCnt >= 2) {
						horizontalAvailableCnt++;
					}

					comboCnt = 0;
				}
			}

			if (comboCnt >= 2) {
				horizontalAvailableCnt++;
			}

			comboCnt = 0;
		}

		// 버퍼를 이용해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();
		sb.append(verticalAvailableCnt).append(" ").append(horizontalAvailableCnt);

		// 결과 값 출력
		System.out.println(sb.toString());
	}
}