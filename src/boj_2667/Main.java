package boj_2667;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 백준 온라인 저지 2667번 (단지번호붙이기) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2667
 * @author devetude
 */

public class Main {
	// 개행 문자열 상수
	private static final String NEW_LINE = "\n";

	// 방향 배열 상수
	private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	private static final int ROW = 0;
	private static final int COL = 1;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 지도 배열 초기화
		int[][] map = new int[N][N];

		for (int row = 0; row < N; row++) {
			String line = br.readLine();

			for (int col = 0; col < N; col++) {
				map[row][col] = Character.getNumericValue(line.charAt(col));
			}
		}

		br.close();

		// 방문 여부 저장 배열 초기화
		boolean[][] isVisited = new boolean[N][N];

		// 단지 갯수 저장 변수 초기화
		int areaCnt = 0;

		// 단지별 갯수 저장 배열리스트 초기화
		ArrayList<Integer> list = new ArrayList<>();

		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				// 집이 있는 곳이면서 bfs를 실행하지 않은 지점일 경우
				if (map[row][col] == 1 && !isVisited[row][col]) {
					areaCnt++;

					int nodeCnt = 1;

					isVisited[row][col] = true;

					// 큐 객체 변수 초기화
					Queue<Point> queue = new LinkedList<>();
					queue.offer(new Point(row, col));

					// bfs 실행
					while (!queue.isEmpty()) {
						Point current = queue.poll();

						for (final int[] DIRECTION : DIRECTIONS) {
							int nextRow = current.row + DIRECTION[ROW];
							int nextCol = current.col + DIRECTION[COL];

							if (0 <= nextRow && nextRow < N && 0 <= nextCol && nextCol < N) {
								if (map[nextRow][nextCol] == 1 && !isVisited[nextRow][nextCol]) {
									nodeCnt++;
									isVisited[nextRow][nextCol] = true;
									queue.offer(new Point(nextRow, nextCol));
								}
							}
						}
					}

					list.add(nodeCnt);
				}
			}
		}

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();
		sb.append(areaCnt).append(NEW_LINE);

		Collections.sort(list);

		for (int nodeCnt : list) {
			sb.append(nodeCnt).append(NEW_LINE);
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
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