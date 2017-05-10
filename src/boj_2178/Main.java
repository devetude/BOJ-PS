package boj_2178;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2178번 (미로 탐색) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2178
 * @author devetude
 */
public class Main {
	// 방향 배열 상수
	private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	private static final int ROW = 0;
	private static final int COL = 1;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 지도 배열 초기화
		int[][] map = new int[N][M];

		for (int row = 0; row < N; row++) {
			String line = br.readLine();

			for (int col = 0; col < M; col++) {
				map[row][col] = Character.getNumericValue(line.charAt(col));
			}
		}

		br.close();

		// 방문 여부 저장 배열 초기화
		int[][] isVisited = new int[N][M];
		isVisited[0][0] = 1;

		// 큐 객체 변수 초기화
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0, 0));

		// bfs 실행
		while (!queue.isEmpty()) {
			Point current = queue.poll();

			for (final int[] DIRECTION : DIRECTIONS) {
				int nextRow = current.row + DIRECTION[ROW];
				int nextCol = current.col + DIRECTION[COL];

				if (0 <= nextRow && nextRow < N && 0 <= nextCol && nextCol < M) {
					if (map[nextRow][nextCol] == 1) {
						if (isVisited[nextRow][nextCol] == 0) {
							isVisited[nextRow][nextCol] = isVisited[current.row][current.col] + 1;
							queue.offer(new Point(nextRow, nextCol));
						}
					}
				}
			}
		}

		// 결과 값 출력
		System.out.println(isVisited[N - 1][M - 1]);
	}

	/**
	 * 지점 이너 클래스
	 * 
	 * @author devetude
	 */
	private static class Point {
		public int row;
		public int col;

		/**
		 * 생성자
		 * 
		 * @param row
		 * @param col
		 */
		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}