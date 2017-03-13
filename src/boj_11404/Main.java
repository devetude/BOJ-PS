package boj_11404;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 11404번 (플로이드) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/11404
 * @author devetude
 */
public class Main {
	// 무한대 상수
	private static final int INFINITE = 100_001;

	// 문자 상수
	private static final char SPACE = ' ';
	private static final char NEW_LINE = '\n';

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		// 비용 저장 배열 초기화
		int[][] costs = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i != j) {
					costs[i][j] = INFINITE;
				}
			}
		}

		while (m-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			// 한 정점에서 다른 정점으로 가는 방법이 여러개 일 경우 최소 비용을 저장
			costs[i][j] = Math.min(costs[i][j], c);
		}

		br.close();

		// 플로이드 와샬 알고리즘을 통해 정점에서 다른 정점까지의 최소 거리를 구함
		for (int jia = 1; jia <= n; jia++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (costs[i][j] > costs[i][jia] + costs[jia][j]) {
						costs[i][j] = costs[i][jia] + costs[jia][j];
					}
				}
			}
		}

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (costs[i][j] == INFINITE) {
					sb.append(0);
				}

				else {
					sb.append(costs[i][j]);
				}

				sb.append(SPACE);
			}

			sb.append(NEW_LINE);
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}