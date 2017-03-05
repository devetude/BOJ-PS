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
	// 이동할 수 없는 칸을 나타내는 문자 상수
	private static final char BLOCKED = '0';

	// 방향 배열 상수 (동, 서, 남, 북)
	private static final int[][] directions = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

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
		char[][] map = new char[N][M];

		// 루프를 돌며 지도를 만듬
		for (int i = 0; i < N; i++) {
			String line = br.readLine();

			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		br.close();

		// 방문점 깊이 저장 배열 초기화
		int[][] isVisited = new int[N][M];
		isVisited[0][0] = 1;

		// 큐 객체 변수 초기화
		Queue<Point> queue = new LinkedList<>();

		// 시작점을 큐에 담음
		queue.offer(new Point(0, 0));

		// dfs 탐색 실행
		while (!queue.isEmpty()) {
			Point current = queue.poll();

			for (int[] direction : directions) {
				int nextRow = current.row + direction[ROW];
				int nextCol = current.col + direction[COL];

				if (0 <= nextRow && nextRow < N && 0 <= nextCol && nextCol < M) {
					if (isVisited[nextRow][nextCol] == 0 && map[nextRow][nextCol] != BLOCKED) {
						isVisited[nextRow][nextCol] = isVisited[current.row][current.col] + 1;
						queue.offer(new Point(nextRow, nextCol));
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