package boj_1600;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1600번 (말이 되고픈 원숭이) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1600
 * @author devetude
 */
public class Main {
	// 원숭이 움직임 배열 상수
	private static final int[][] M_DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	// 말 움직임 배열 상수
	private static final int[][] H_DIRECTIONS = { { 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 },
			{ -2, -1 }, { -1, -2 } };

	// 배열 행, 열 상수
	private static final int ROW = 0;
	private static final int COL = 1;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		// 지도 배열 초기화
		int[][] map = new int[H][W];

		for (int row = 0; row < H; row++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int col = 0; col < W; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		br.close();

		// 방문 여부 확인 배열 초기화 (i행 j열을 k번 말의 이동 방법을 사용해서 방문했는지 안했는지)
		boolean[][][] isVisited = new boolean[H][W][31];
		isVisited[0][0][0] = true;

		// 큐 객체 변수 초기화
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0, 0, K, 0));

		int endRow = H - 1;
		int endCol = W - 1;

		// bfs 실행
		while (!queue.isEmpty()) {
			Point current = queue.poll();

			// 마지막 지점에 도달한 경우 탐색 종료
			if (current.row == endRow && current.col == endCol) {
				// 결과 값 출력
				System.out.println(current.d);

				return;
			}

			// 원숭이 움직임으로 가는 방법
			for (final int[] M_DIRECTION : M_DIRECTIONS) {
				int nextRow = current.row + M_DIRECTION[ROW];
				int nextCol = current.col + M_DIRECTION[COL];

				if (0 <= nextRow && nextRow < H && 0 <= nextCol && nextCol < W) {
					if (map[nextRow][nextCol] == 0 && !isVisited[nextRow][nextCol][current.k]) {
						isVisited[nextRow][nextCol][current.k] = true;
						queue.offer(new Point(nextRow, nextCol, current.k, current.d + 1));
					}
				}
			}

			// 말의 움직임으로 갈 수 있는 경우에만
			if (current.k > 0) {
				// 말의 움직임으로 가는 방법
				for (final int[] H_DIRECTION : H_DIRECTIONS) {
					int nextRow = current.row + H_DIRECTION[ROW];
					int nextCol = current.col + H_DIRECTION[COL];

					if (0 <= nextRow && nextRow < H && 0 <= nextCol && nextCol < W) {
						if (map[nextRow][nextCol] == 0 && !isVisited[nextRow][nextCol][current.k - 1]) {
							isVisited[nextRow][nextCol][current.k - 1] = true;
							queue.offer(new Point(nextRow, nextCol, current.k - 1, current.d + 1));
						}
					}
				}
			}
		}

		// 탐색 후 마지막 지점에 도달할 수 없는 경우 문제의 조건에 따라 -1 출력
		System.out.println(-1);
	}

	private static class Point {
		public int row;
		public int col;
		public int k;
		public int d;

		public Point(int row, int col, int k, int d) {
			this.row = row;
			this.col = col;
			this.k = k;
			this.d = d;
		}
	}
}