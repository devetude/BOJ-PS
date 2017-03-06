package boj_7562;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 7562번 (나이트의 이동) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/7562
 * @author devetude
 */
public class Main {
	// 개행 문자 상수
	private static final char NEW_LINE = '\n';

	// 나이트 이동 가능 배열 상수
	private static final int[][] MOVES = { { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 }, { -2, -1 }, { -1, -2 }, { 1, -2 },
			{ 2, -1 } };

	// 이동 가능 배열 행, 열 상수
	private static final int X = 1;
	private static final int Y = 0;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			int I = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			st = new StringTokenizer(br.readLine(), " ");
			Point end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			// 방문 여부 확인 배열 초기화
			int[][] isVisited = new int[I][I];
			isVisited[start.y][start.x] = 1;

			// 큐 객체 변수 초기화
			Queue<Point> queue = new LinkedList<>();

			// 시작 정점을 큐에 담음
			queue.offer(start);

			// dfs 실행
			while (!queue.isEmpty()) {
				Point current = queue.poll();

				if (current.x == end.x && current.y == end.y) {
					break;
				}

				for (final int[] MOVE : MOVES) {
					int nextY = current.y + MOVE[Y];
					int nextX = current.x + MOVE[X];

					if (0 <= nextY && nextY < I && 0 <= nextX && nextX < I) {
						if (isVisited[nextY][nextX] == 0) {
							isVisited[nextY][nextX] = isVisited[current.y][current.x] + 1;
							queue.offer(new Point(nextX, nextY));
						}
					}
				}
			}

			sb.append(isVisited[end.y][end.x] - 1).append(NEW_LINE);
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