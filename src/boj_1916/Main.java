package boj_1916;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1916번 (최소비용 구하기) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1916
 * @author devetude
 */
public class Main {
	// 무한대 상수
	private static final int INFINITE_COST = 1_000_000_001;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		// 인접 행렬 및 비용 배열 초기화
		int[][] matrix = new int[n + 1][n + 1];
		int[] costs = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			costs[i] = INFINITE_COST;
			Arrays.fill(matrix[i], INFINITE_COST);
		}

		int m = Integer.parseInt(br.readLine());

		while (m-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			// A시에서 B시로 가는 버스의 비용이 여러가지 일 수 있어 작은 값을 저장
			matrix[start][end] = Math.min(matrix[start][end], cost);
		}

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int S = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		br.close();

		// 시작점의 비용을 0으로 변경
		matrix[S][S] = 0;
		costs[S] = 0;

		// 우선순위 큐 객체 변수 초기화
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

		// 시작점을 우선순위 큐에 담음
		priorityQueue.offer(S);

		// 다익스트라 알고리즘 실행
		while (!priorityQueue.isEmpty()) {
			int current = priorityQueue.poll();

			for (int next = 1; next <= n; next++) {
				if (costs[next] > matrix[current][next] + costs[current]) {
					costs[next] = matrix[current][next] + costs[current];
					priorityQueue.offer(next);
				}
			}
		}

		// 결과 값 출력
		System.out.println(costs[E]);
	}
}