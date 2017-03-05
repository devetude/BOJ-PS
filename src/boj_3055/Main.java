package boj_3055;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 3055번 (탈출) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/3055
 * @author devetude
 */
public class Main {
	// 문자 상수
	private static final char START = 'S';
	private static final char DESTINATION = 'D';
	private static final char WATER = '*';
	private static final char ROAD = '.';

	// 불가능을 나타내는 문자열 상수
	private static final String IMPOSSIBLE = "KAKTUS";

	// 방향 배열 상수 (동, 서, 남, 북)
	private static final int[][] directions = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	// 방향 배열의 행, 열 상수
	private static final int ROW = 0;
	private static final int COL = 1;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		// 지도 배열 초기화
		char[][] map = new char[R][C];

		// 시작, 도착 지점 객체 변수
		Point start = null;
		Point destination = null;

		// 물이 위치한 지점들을 저장하는 배열리스트 초기화
		ArrayList<Point> waters = new ArrayList<>();

		// 루프를 돌며 지도를 만듬
		for (int i = 0; i < R; i++) {
			String input = br.readLine();

			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);

				// 시작 지점 따로 저장
				if (map[i][j] == START) {
					start = new Point(i, j, -1);
				}

				// 도착 지점 따로 저장
				else if (map[i][j] == DESTINATION) {
					destination = new Point(i, j, -1);
				}

				// 물이 위치한 지점 따로 저장
				else if (map[i][j] == WATER) {
					waters.add(new Point(i, j, -1));
				}
			}
		}

		br.close();

		// 방문 깊이 저장 배열 초기화
		int[][] isVisited = new int[R][C];

		// 큐 객체 변수 초기화
		Queue<Point> queue = new LinkedList<>();

		// 시작 지점을 큐에 담음
		queue.offer(start);

		// 현재 dfs 깊이 저장 변수
		int depth = 0;

		// dfs 탐색
		while (!queue.isEmpty()) {
			Point current = queue.poll();

			// 깊이 값이 달라진 경우 (한 주기가 끝난 경우) 물이 차오르도록 지도 값을 변경
			if (current.depth != depth) {
				depth++;

				ArrayList<Point> nextWaters = new ArrayList<>();

				for (Point water : waters) {
					for (int[] direction : directions) {
						int nextRow = water.row + direction[ROW];
						int nextCol = water.col + direction[COL];

						if (0 <= nextRow && nextRow < R && 0 <= nextCol && nextCol < C) {
							if (map[nextRow][nextCol] == ROAD) {
								map[nextRow][nextCol] = WATER;
								nextWaters.add(new Point(nextRow, nextCol, -1));
							}
						}
					}
				}

				waters = nextWaters;
			}

			// 루프를 돌며 다음으로 방문 가능한 지점을 큐에 담음
			for (int[] direction : directions) {
				int nextRow = current.row + direction[ROW];
				int nextCol = current.col + direction[COL];

				if (0 <= nextRow && nextRow < R && 0 <= nextCol && nextCol < C) {
					if (isVisited[nextRow][nextCol] == 0) {
						if (map[nextRow][nextCol] == ROAD || map[nextRow][nextCol] == DESTINATION) {
							isVisited[nextRow][nextCol] = depth;
							queue.offer(new Point(nextRow, nextCol, depth + 1));
						}
					}
				}
			}
		}

		// 도착 지점의 깊이가 0인 경우 문제의 조건에 따라 불가능한 경우 출력
		if (isVisited[destination.row][destination.col] == 0) {
			System.out.println(IMPOSSIBLE);
		}

		else {
			// 결과 값 출력
			System.out.println(isVisited[destination.row][destination.col]);
		}
	}

	/**
	 * 지점 이너 클래스
	 * 
	 * @author devetude
	 */
	private static class Point {
		public int row;
		public int col;
		public int depth;

		/**
		 * 생성자
		 * 
		 * @param row
		 * @param col
		 * @param depth
		 */
		public Point(int row, int col, int depth) {
			this.row = row;
			this.col = col;
			this.depth = depth;
		}
	}
}