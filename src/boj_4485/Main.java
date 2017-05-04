package boj_4485;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 4485번 (녹색 옷 입은 애가 젤다지?) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/4485
 * @author devetude
 */
public class Main {
	// 문자열 상수
	private static final String SPACE = " ";
	private static final String PROBLEM = "Problem ";
	private static final String COLON = ": ";
	private static final String NEW_LINE = "\n";

	// 무한대 상수
	private static final int INFINITE = 2_100_000_000;

	// 방향 배열 상수
	private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	private static final int ROW = 0;
	private static final int COL = 1;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 0;

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		// 결과 인덱스 저장 변수 초기화
		int resIdx = 1;

		while ((N = Integer.parseInt(br.readLine())) != 0) {
			// 비용, 최단 거리 저장 배열 초기화
			int[][] costs = new int[N][N];
			int[][] distances = new int[N][N];

			for (int row = 0; row < N; row++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);

				for (int col = 0; col < N; col++) {
					costs[row][col] = Integer.parseInt(st.nextToken());
					distances[row][col] = INFINITE;
				}
			}

			distances[0][0] = costs[0][0];

			// 우선순위큐 객체 변수 초기화
			PriorityQueue<Point> priorityQueue = new PriorityQueue<>();
			priorityQueue.offer(new Point(0, 0, costs[0][0]));

			// 다익스트라 알고리즘 실행
			while (!priorityQueue.isEmpty()) {
				Point current = priorityQueue.poll();

				if (current.cost > distances[current.row][current.col]) {
					continue;
				}

				for (final int[] DIRECTION : DIRECTIONS) {
					int nextRow = current.row + DIRECTION[ROW];
					int nextCol = current.col + DIRECTION[COL];

					if (0 <= nextRow && nextRow < N && 0 <= nextCol && nextCol < N) {
						int detour = distances[current.row][current.col] + costs[nextRow][nextCol];

						if (distances[nextRow][nextCol] > detour) {
							distances[nextRow][nextCol] = detour;
							priorityQueue.offer(new Point(nextRow, nextCol, costs[nextRow][nextCol]));
						}
					}
				}
			}

			sb.append(PROBLEM).append(resIdx++).append(COLON).append(distances[N - 1][N - 1]).append(NEW_LINE);
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}

	/**
	 * 지점 이너 클래스
	 * 
	 * @author devetude
	 */
	private static class Point implements Comparable<Point> {
		public int row;
		public int col;
		public int cost;

		/**
		 * 생성자
		 * 
		 * @param row
		 * @param col
		 * @param cost
		 */
		public Point(int row, int col, int cost) {
			this.row = row;
			this.col = col;
			this.cost = cost;
		}

		@Override
		public int compareTo(Point p) {
			return cost < p.cost ? -1 : 1;
		}
	}
}