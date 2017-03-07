package boj_2468;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2468번 (안전 영역) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2468
 * @author devetude
 */
public class Main {
	// 탐색 방향 배열 상수 (동, 서, 남, 북)
	private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	// 탐색 방향 행, 열 상수
	private static final int X = 1;
	private static final int Y = 0;

	// 영역의 최대, 최소 높이 상수
	private static final int MIN_AREA_HEIGHT = 2;
	private static final int MAX_AREA_HEIGHT = 100;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 영역 배열 초기화
		int[][] area = new int[N][N];

		// 영역 중 최대, 최소 높이 저장 변수 초기화
		int areaMinHeight = MAX_AREA_HEIGHT;
		int areaMaxHeight = MIN_AREA_HEIGHT;

		for (int y = 0; y < N; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int x = 0; x < N; x++) {
				area[y][x] = Integer.parseInt(st.nextToken());

				// 최대, 최소 높이 변경
				areaMinHeight = Math.min(areaMinHeight, area[y][x]);
				areaMaxHeight = Math.max(areaMaxHeight, area[y][x]);
			}
		}

		br.close();

		// 최대 영역 갯수 저장 변수 초기화
		int maxAreaCnt = 0;

		// 물의 높이가 영역의 최소부터 최대까지 증가시키며 dfs를 통해 최대 영역의 갯수를 찾아나감
		for (int waterHeight = areaMinHeight - 1; waterHeight <= areaMaxHeight; waterHeight++) {
			boolean[][] isVisited = new boolean[N][N];

			Queue<Point> queue = new LinkedList<>();

			int areaCnt = 0;

			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if (area[y][x] > waterHeight && !isVisited[y][x]) {
						areaCnt++;

						queue.offer(new Point(x, y));

						while (!queue.isEmpty()) {
							Point current = queue.poll();

							for (final int[] DIRECTION : DIRECTIONS) {
								int nextY = current.y + DIRECTION[Y];
								int nextX = current.x + DIRECTION[X];

								if (0 <= nextY && nextY < N && 0 <= nextX && nextX < N) {
									if (area[nextY][nextX] > waterHeight && !isVisited[nextY][nextX]) {
										isVisited[nextY][nextX] = true;
										queue.offer(new Point(nextX, nextY));
									}
								}
							}
						}
					}
				}
			}

			maxAreaCnt = Math.max(maxAreaCnt, areaCnt);
		}

		// 결과 값 출력
		System.out.println(maxAreaCnt);
	}

	/**
	 * 정점 이너 클래스
	 * 
	 * @author devetude
	 */
	private static class Point {
		public int x;
		public int y;

		/**
		 * 생성자
		 * 
		 * @param x
		 * @param y
		 */
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}