package boj_11562;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 11562번 (백양로 브레이크) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/11562
 * @author devetude
 */
public class Main {
	// 무한대 상수
	private static final int INFINITE = 251;

	// 개행 문자 상수
	private static final char NEW_LINE = '\n';

	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 비용 저장 변수 초기화
		int[][] costs = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i != j) {
					costs[i][j] = INFINITE;
				}
			}
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 양방향일 경우 바꿀 필요가 없으므로 비용을 0으로
			if (b == 1) {
				costs[u][v] = costs[v][u] = 0;
			}

			// 단방향일 경우 바꿔야 하는 부분의 비용만 1로
			else {
				costs[u][v] = 0;
				costs[v][u] = 1;
			}
		}

		// 플로이드 와샬 알고리즘을 이용하여 최소 비용으로 변경
		for (int via = 1; via <= n; via++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					costs[i][j] = Math.min(costs[i][j], costs[i][via] + costs[via][j]);
				}
			}
		}

		int k = Integer.parseInt(br.readLine());

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		while (k-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			sb.append(costs[s][e]).append(NEW_LINE);
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}