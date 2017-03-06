package boj_1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1012번 (유기농 배추) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1012
 * @author devetude
 */
public class Main {
	// 개행 문자 상수
	private static final char NEW_LINE = '\n';

	// 방향 배열 상수 (동, 서, 남, 북)
	private static final int[][] DIRECTIONS = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	// 방향 행, 열 상수
	private static final int X = 1;
	private static final int Y = 0;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// 버퍼를 통해 결과 값을 받음
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			// 배추 존재 여부 저장 배열 초기화
			boolean[][] isExist = new boolean[N][M];

			while (K-- > 0) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				isExist[y][x] = true;
			}

			// 방문 여부 저장 배열 초기화
			boolean[][] isVisited = new boolean[N][M];

			// 큐 객체 변수 초기화
			Queue<Point> queue = new LinkedList<>();

			// 구역 번호 초기화
			int areaNum = 0;

			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					// 정점 중 아직 방문하지 않았을 경우
					if (isExist[y][x] && !isVisited[y][x]) {
						// 구역 번호를 1 증가 (새로운 구역 발견)
						areaNum++;

						// 해당 정점과 붙어있는 모든 정점을 dfs 탐색
						queue.offer(new Point(x, y));

						while (!queue.isEmpty()) {
							Point current = queue.poll();

							for (final int[] DIRECTION : DIRECTIONS) {
								int nextY = current.y + DIRECTION[Y];
								int nextX = current.x + DIRECTION[X];

								if (0 <= nextY && nextY < N && 0 <= nextX && nextX < M) {
									if (isExist[nextY][nextX] && !isVisited[nextY][nextX]) {
										isVisited[nextY][nextX] = true;
										queue.offer(new Point(nextX, nextY));
									}
								}
							}
						}
					}
				}
			}

			sb.append(areaNum).append(NEW_LINE);
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
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