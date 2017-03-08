package boj_2589;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2589번 (보물섬) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2589
 * @author devetude
 */
public class Main {
	// 육지 표시 문자 상수
	private static final char LAND = 'L';

	// 방향 배열 상수 (동, 서, 남, 북)
	private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	// 방향 행, 열 상수
	private static final int ROW = 0;
	private static final int COL = 1;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int rows = Integer.parseInt(st.nextToken());
		int cols = Integer.parseInt(st.nextToken());

		// 지도 배열 초기화
		char[][] map = new char[rows][cols];

		for (int row = 0; row < rows; row++) {
			char[] status = br.readLine().toCharArray();

			for (int col = 0; col < cols; col++) {
				map[row][col] = status[col];
			}
		}

		br.close();

		// 결과 값 저장 변수 초기화
		int res = 1;

		// bfs를 실행하여 한 정점에서 다른 정점으로 가는 거리가 가장 긴 경우를 구함
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (map[row][col] == LAND) {
					int[][] isVisited = new int[rows][cols];
					isVisited[row][col] = 1;

					Queue<Point> queue = new LinkedList<>();
					queue.offer(new Point(row, col));

					while (!queue.isEmpty()) {
						Point current = queue.poll();

						for (final int[] DIRECTION : DIRECTIONS) {
							int nextRow = current.row + DIRECTION[ROW];
							int nextCol = current.col + DIRECTION[COL];

							if (0 <= nextRow && nextRow < rows && 0 <= nextCol && nextCol < cols) {
								if (map[nextRow][nextCol] == LAND && isVisited[nextRow][nextCol] == 0) {
									isVisited[nextRow][nextCol] = isVisited[current.row][current.col] + 1;
									res = Math.max(res, isVisited[nextRow][nextCol] - 1);

									queue.offer(new Point(nextRow, nextCol));
								}
							}
						}
					}
				}
			}
		}

		// 결과 값 출력
		System.out.println(res);
	}

	/**
	 * 정점 이너 클래스
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