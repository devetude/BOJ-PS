package boj_12790;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 12790번 (Mini Fantasy War) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/12790
 * @author devetude
 */
public class Main {
	// 개행 문자열 상수
	private static final String NEW_LINE = "\n";

	// 포인트 상수
	private static final int HP = 0;
	private static final int MP = 1;
	private static final int OP = 2;
	private static final int DP = 3;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] points = new int[8];

			for (int j = 0; j < 8; j++) {
				points[j] = Integer.parseInt(st.nextToken());
			}

			int bp = 0;

			// HP, MP, OP, DP를 순서대로 돌며 최종 전투력을 계산
			for (int j = 0; j < 4; j++) {
				int sum = points[j] + points[j + 4];

				if (j == HP) {
					// HP의 경우 1보다 작은 경우 1로 변경
					if (sum < 1) {
						sum = 1;
					}

					bp = sum;
				}

				else if (j == MP) {
					// MP의 경우 1보다 작은 경우 1로 변경
					if (sum < 1) {
						sum = 1;
					}

					bp += 5 * sum;
				}

				else if (j == OP) {
					// OP의 경우 0보다 작은 경우 0으로 변경
					if (sum < 0) {
						sum = 0;
					}

					bp += 2 * sum;
				}

				else if (j == DP) {
					bp += 2 * sum;
				}
			}

			// 버퍼를 통해 결과 값을 만듬
			sb.append(bp).append(NEW_LINE);
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}