package boj_2573;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2573번 (빙산) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2573
 * @author devetude
 */
public class Main {
	// 방향 배열 상수 (동, 서, 남, 북)
	private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	// 방향 배열 행, 열 상수
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

		// 지도를 채움
		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int col = 0; col < M; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		br.close();

		// 결과 값 저장 변수 초기화
		int years = 0;

		while (true) {
			// 방문 여부 확인 배열 초기화
			boolean[][] isVisited = new boolean[N][M];

			// 영역 갯수 저장 변수 초기화
			int areaCnt = 0;

			// bfs 실행
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < M; col++) {
					if (map[row][col] > 0 && !isVisited[row][col]) {
						areaCnt++;

						isVisited[row][col] = true;

						Queue<Point> queue = new LinkedList<>();
						queue.offer(new Point(row, col));

						while (!queue.isEmpty()) {
							Point current = queue.poll();

							for (final int[] DIRECTION : DIRECTIONS) {
								int nextRow = current.row + DIRECTION[ROW];
								int nextCol = current.col + DIRECTION[COL];

								if (0 <= nextRow && nextRow < N && 0 <= nextCol && nextCol < M) {
									if (map[nextRow][nextCol] > 0 && !isVisited[nextRow][nextCol]) {
										isVisited[nextRow][nextCol] = true;
										queue.offer(new Point(nextRow, nextCol));
									}
								}
							}
						}
					}
				}
			}

			// 2 덩어리 이상 쪼개졌을 경우 종료
			if (areaCnt >= 2) {
				break;
			}

			years++;

			// 녹은 빙산이 1개라도 있는지 확인하는 변수 초기화
			boolean isExistMeltedMountains = false;

			// 다음 지도 배열 초기화
			int[][] nextMap = new int[N][M];

			// 빙산을 녹이는 시뮬레이션 실행
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < M; col++) {
					if (map[row][col] > 0) {
						int meltedCnt = 0;

						for (final int[] DIRECTION : DIRECTIONS) {
							int nearRow = row + DIRECTION[ROW];
							int nearCol = col + DIRECTION[COL];

							if (0 <= nearRow && nearRow < N && 0 <= nearCol && nearCol < M) {
								if (map[nearRow][nearCol] == 0) {
									meltedCnt++;
								}
							}
						}

						isExistMeltedMountains = meltedCnt > 0 ? true : false;
						nextMap[row][col] = map[row][col] - meltedCnt;
						nextMap[row][col] = nextMap[row][col] < 0 ? 0 : nextMap[row][col];
					}
				}
			}

			// 녹은 빙산이 하나도 없는 경우 종료
			if (!isExistMeltedMountains) {
				years = 0;

				break;
			}

			// 다음 지도를 현재 지도로 옮김
			map = nextMap;
		}

		// 결과 값 출력
		System.out.println(years);
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