package boj_1261;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1261번 (알고스팟) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1261
 * @author devetude
 */
public class Main {
	// 개행 문자열 상수
	private static final String SPACE = " ";

	// 방향 배열 상수
	private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	private static final int ROW = 0;
	private static final int COL = 1;

	// 무한대 상수
	private static final int INFINITE = 2_100_000_000;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		// 인접행렬과 최단 거리 저장 배열 초기화
		int[][] costs = new int[N][M];
		int[][] distances = new int[N][M];

		for (int row = 0; row < N; row++) {
			String line = br.readLine();

			for (int col = 0; col < M; col++) {
				costs[row][col] = Character.getNumericValue(line.charAt(col));
				distances[row][col] = INFINITE;
			}
		}

		br.close();

		distances[0][0] = 0;

		// 우선순위큐 객체 변수 초기화
		PriorityQueue<Point> priorityQueue = new PriorityQueue<>();
		priorityQueue.offer(new Point(0, 0, 0));

		// 다익스트라 알고리즘 실행
		while (!priorityQueue.isEmpty()) {
			Point current = priorityQueue.poll();

			if (current.cost > distances[current.row][current.col]) {
				continue;
			}

			for (final int[] DIRECTION : DIRECTIONS) {
				int nextRow = current.row + DIRECTION[ROW];
				int nextCol = current.col + DIRECTION[COL];

				if (0 <= nextRow && nextRow < N && 0 <= nextCol && nextCol < M) {
					int detour = distances[current.row][current.col] + costs[nextRow][nextCol];

					if (distances[nextRow][nextCol] > detour) {
						distances[nextRow][nextCol] = detour;
						priorityQueue.offer(new Point(nextRow, nextCol, costs[nextRow][nextCol]));
					}
				}
			}
		}

		// 결과 값 출력
		System.out.println(distances[N - 1][M - 1]);
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