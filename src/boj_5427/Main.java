package boj_5427;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 5427번 (불) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/5427
 * @author devetude
 */
public class Main {
	// 지도 상태 문자 상수
	private static final char SPACE = '.';
	private static final char FIRE = '*';
	private static final char PERSON = '@';
	private static final char WALL = '#';

	// 방향 배열 상수 (동, 서, 남, 북)
	private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	// 방향 행, 열 상수
	private static final int ROW = 0;
	private static final int COL = 1;

	// 문자열 상수
	private static final String IMPOSSIBLE = "IMPOSSIBLE";
	private static final String NEW_LINE = "\n";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// 버퍼를 통해 입력 값을 만듬
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			// 지도 배열 초기화
			char[][] map = new char[h][w];

			// 불 여부 저장 배열 초기화
			int[][] isFired = new int[h][w];

			// 불 지점 저장 배열리스트 객체 변수 초기화
			ArrayList<Point> fires = new ArrayList<>();

			// 상근이 위치 저장 객체 변수 초기화
			Point person = null;

			for (int row = 0; row < h; row++) {
				char[] inputs = br.readLine().toCharArray();

				for (int col = 0; col < w; col++) {
					map[row][col] = inputs[col];

					// 불 지점인 경우
					if (inputs[col] == FIRE) {
						fires.add(new Point(row, col));
						isFired[row][col] = 1;
					}

					// 상근이 위치인 경우
					else if (inputs[col] == PERSON) {
						person = new Point(row, col);
					}
				}
			}

			// 불 번짐 시간 저장 변수 초기화
			int sec = 1;

			// 더 이상 번져나갈 불 지점이 없을 때까지 반복 (시뮬레이션)
			while (fires.size() > 0) {
				ArrayList<Point> nextFires = new ArrayList<>();

				// 저장되어있는 불 지점을 하나씩 가져옴
				for (Point fire : fires) {
					for (final int[] DIRECTION : DIRECTIONS) {
						int nextRow = fire.row + DIRECTION[ROW];
						int nextCol = fire.col + DIRECTION[COL];

						// 배열의 범위를 넘지 않는 경우
						if (0 <= nextRow && nextRow < h && 0 <= nextCol && nextCol < w) {
							// 벽이 아니면서 이미 방문한 지점이 아닌 경우에만
							if (map[nextRow][nextCol] != WALL && isFired[nextRow][nextCol] == 0) {
								isFired[nextRow][nextCol] = sec;
								nextFires.add(new Point(nextRow, nextCol));
							}
						}
					}
				}

				// 불 지점 배열리스트 변경
				fires = nextFires;

				// 시간 1 증가
				sec++;
			}

			// 방문 여부 저장 배열 초기화
			int[][] isVisited = new int[h][w];
			isVisited[person.row][person.col] = 1;

			// 큐 객체 변수 초기화
			Queue<Point> queue = new LinkedList<>();
			queue.offer(new Point(person.row, person.col));

			// bfs 실행
			while (!queue.isEmpty()) {
				Point current = queue.poll();

				for (final int[] DIRECTION : DIRECTIONS) {
					int nextRow = current.row + DIRECTION[ROW];
					int nextCol = current.col + DIRECTION[COL];

					if (0 <= nextRow && nextRow < h && 0 <= nextCol && nextCol < w) {
						if (map[nextRow][nextCol] == SPACE && isVisited[nextRow][nextCol] == 0) {
							isVisited[nextRow][nextCol] = isVisited[current.row][current.col] + 1;
							queue.offer(new Point(nextRow, nextCol));
						}
					}
				}
			}

			// 빌딩을 탈출하는데 가장 빠른 시간 저장 변수 초기화
			int min = Integer.MAX_VALUE;

			// 윗쪽 모서리 검사
			for (int col = 0; col < w; col++) {
				// 출구에 도달했으면서, 불 보다 먼저 도달한 경우나 불이 없는 경우
				if (isVisited[0][col] > 0 && (isVisited[0][col] <= isFired[0][col] || isFired[0][col] == 0)) {
					min = Math.min(min, isVisited[0][col]);
				}
			}

			int hEnd = h - 1;

			// 왼쪽 모서리 검사
			for (int row = 1; row < hEnd; row++) {
				// 출구에 도달했으면서, 불 보다 먼저 도달한 경우나 불이 없는 경우
				if (isVisited[row][0] > 0 && (isVisited[row][0] <= isFired[row][0] || isFired[row][0] == 0)) {
					min = Math.min(min, isVisited[row][0]);
				}
			}

			// 아랫쪽 모서리 검사
			for (int col = 0; col < w; col++) {
				// 출구에 도달했으면서, 불 보다 먼저 도달한 경우나 불이 없는 경우
				if (isVisited[hEnd][col] > 0
						&& (isVisited[hEnd][col] <= isFired[hEnd][col] || isFired[hEnd][col] == 0)) {
					min = Math.min(min, isVisited[hEnd][col]);
				}
			}

			int wEnd = w - 1;

			// 오른쪽 모서리 검사
			for (int row = 1; row < hEnd; row++) {
				// 출구에 도달했으면서, 불 보다 먼저 도달한 경우나 불이 없는 경우
				if (isVisited[row][wEnd] > 0
						&& (isVisited[row][wEnd] <= isFired[row][wEnd] || isFired[row][wEnd] == 0)) {
					min = Math.min(min, isVisited[row][wEnd]);
				}
			}

			// 출구에 도달하지 못한 경우
			if (min == Integer.MAX_VALUE) {
				sb.append(IMPOSSIBLE);
			}

			// 출구에 도달한 경우
			else {
				sb.append(min);
			}

			sb.append(NEW_LINE);
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