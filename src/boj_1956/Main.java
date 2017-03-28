package boj_1956;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1956번 (운동) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1956
 * @author devetude
 */
public class Main {
	// 무한대 상수
	private static final int INFINITE = 4_000_001;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		// 거리 저장 배열 초기화
		int[][] costs = new int[V + 1][V + 1];

		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				costs[i][j] = INFINITE;
			}
		}

		while (E-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			costs[a][b] = Math.min(costs[a][b], c);
		}

		br.close();

		// 플로이드 와샬 알고리즘을 이용하여 a에서 b로 이동하는 최단 거리를 변경
		for (int via = 1; via <= V; via++) {
			for (int a = 1; a <= V; a++) {
				for (int b = 1; b <= V; b++) {
					costs[a][b] = Math.min(costs[a][b], costs[a][via] + costs[via][b]);
				}
			}
		}

		// 최단 사이클 거리 저장 변수 초기화
		int minCycleLen = INFINITE;

		// i에서 i 즉, 사이클 값 중 최솟값을 찾음
		for (int i = 1; i <= V; i++) {
			minCycleLen = Math.min(minCycleLen, costs[i][i]);
		}

		// 사이클이 발생하지 않은 예외의 경우 문제의 조건에 따라 -1 출력
		if (minCycleLen == INFINITE) {
			System.out.println(-1);

			return;
		}

		// 결과 값 출력
		System.out.println(minCycleLen);
	}
}