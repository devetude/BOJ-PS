package boj_7569;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 7569번 (토마토) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/7569
 * @author devetude
 */
public class Main {
	// 토마토 상태 상수
	private static final int RIPED = 1;
	private static final int NOT_RIPED = 0;

	// 방향 배열 상수
	private static final int[][] DIRECTIONS = { { 0, 1, 0 }, { 0, -1, 0 }, { 0, 0, 1 }, { 0, 0, -1 }, { 1, 0, 0 },
			{ -1, 0, 0 } };

	// 방향 상수 (높이, 행, 열)
	private static final int LEV = 0;
	private static final int ROW = 1;
	private static final int COL = 2;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		// 박스 배열 초기화
		int[][][] box = new int[H][N][M];

		// 방문 여부 확인 배열 초기화
		int[][][] isVisited = new int[H][N][M];

		// 큐 객체 변수 초기화
		Queue<Point> queue = new LinkedList<>();

		// 익지 않은 토마토 갯수 저장 변수 초기화
		int notRipedCnt = 0;

		for (int lev = 0; lev < H; lev++) {
			for (int row = 0; row < N; row++) {
				st = new StringTokenizer(br.readLine(), " ");

				for (int col = 0; col < M; col++) {
					box[lev][row][col] = Integer.parseInt(st.nextToken());

					// 익은 토마토 일 경우
					if (box[lev][row][col] == RIPED) {
						isVisited[lev][row][col] = 1;

						// 큐에 해당 지점 저장
						queue.offer(new Point(lev, row, col));
					}

					// 익지 않은 토마토 일 경우
					else if (box[lev][row][col] == NOT_RIPED) {
						// 익지 않은 토마토 갯수 1 증가
						notRipedCnt++;
					}
				}
			}
		}

		br.close();

		// bfs 실행
		while (!queue.isEmpty()) {
			Point current = queue.poll();

			for (final int[] DIRECTION : DIRECTIONS) {
				int nextLev = current.lev + DIRECTION[LEV];
				int nextRow = current.row + DIRECTION[ROW];
				int nextCol = current.col + DIRECTION[COL];

				if (0 <= nextLev && nextLev < H && 0 <= nextRow && nextRow < N && 0 <= nextCol && nextCol < M) {
					if (box[nextLev][nextRow][nextCol] == NOT_RIPED && isVisited[nextLev][nextRow][nextCol] == 0) {
						isVisited[nextLev][nextRow][nextCol] = isVisited[current.lev][current.row][current.col] + 1;

						queue.offer(new Point(nextLev, nextRow, nextCol));

						// 익지 않은 토마토 갯수 1 감소
						notRipedCnt--;
					}
				}
			}
		}

		// 익지 않은 토마토가 남아있을 경우 문제의 조건에 따라 -1 출력
		if (notRipedCnt > 0) {
			System.out.println(-1);

			return;
		}

		// 다 익을 때 까지 걸리는 일 수 저장 변수 초기화
		int maxDays = 0;

		// 루프를 돌며 깊이가 가장 깊은 방문점을 찾음
		for (int lev = 0; lev < H; lev++) {
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < M; col++) {
					maxDays = Math.max(maxDays, isVisited[lev][row][col] - 1);
				}
			}
		}

		// 결과 값 출력
		System.out.println(maxDays);
	}

	/**
	 * 지점 이너 클래스
	 * 
	 * @author devetude
	 */
	private static class Point {
		public int lev;
		public int row;
		public int col;

		/**
		 * 생성자
		 * 
		 * @param lev
		 * @param row
		 * @param col
		 */
		public Point(int lev, int row, int col) {
			this.lev = lev;
			this.row = row;
			this.col = col;
		}
	}
}