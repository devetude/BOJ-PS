package boj_2146;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2146번 (다리 만들기) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2146
 * @author devetude
 */
public class Main {
	// 방향 배열 상수 (동, 서, 남, 북)
	private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	// 방향 배열 행, 열 상수
	private static int ROW = 0;
	private static int COL = 1;

	// 바다, 육지를 나타내는 상수
	private static int SEA = 0;
	private static int LAND = 1;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 지도 배열 초기화
		int[][] map = new int[N][N];

		// 루프를 돌며 지도 배열을 채움
		for (int row = 0; row < N; row++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int col = 0; col < N; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		br.close();

		// 방문 여부 저장 배열 초기화
		boolean[][] isVisited = new boolean[N][N];

		// 큐 객체 변수 초기화
		Queue<Point> queue = new LinkedList<>();

		// 섬 번호 저장 변수 초기화
		int islandIdx = 0;

		// 섬 별로 해안가에 위치하는 좌표 저장 배열 리스트 객체 변수 초기화
		ArrayList<ArrayList<Point>> beachFronts = new ArrayList<>();
		beachFronts.add(new ArrayList<Point>());

		// bfs 실행
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (map[row][col] == LAND && !isVisited[row][col]) {
					// 섬 번호 1 증가
					islandIdx++;

					isVisited[row][col] = true;

					beachFronts.add(new ArrayList<Point>());

					queue.offer(new Point(row, col));

					while (!queue.isEmpty()) {
						Point current = queue.poll();

						// 현재 좌표가 해안가인지 나타내는 변수 초기화
						boolean isBeachFront = false;

						for (final int[] DIRECTION : DIRECTIONS) {
							int nextRow = current.row + DIRECTION[ROW];
							int nextCol = current.col + DIRECTION[COL];

							if (0 <= nextRow && nextRow < N && 0 <= nextCol && nextCol < N) {
								// 근처가 바다 일 경우 해안가로 변경
								if (map[nextRow][nextCol] == SEA) {
									isBeachFront = true;
								}

								if (map[nextRow][nextCol] == LAND && !isVisited[nextRow][nextCol]) {
									isVisited[nextRow][nextCol] = true;
									queue.offer(new Point(nextRow, nextCol));
								}
							}
						}

						// 해안가 일 경우 현재 좌표를 배열 리스트에 담음
						if (isBeachFront) {
							beachFronts.get(islandIdx).add(new Point(current.row, current.col));
						}
					}
				}
			}
		}

		// 예외 : 경우 섬이 2개 보다 적은 경우 0을 출력
		if (islandIdx <= 1) {
			System.out.println(0);
		}

		else {
			int minLen = 2 * N - 3;

			// 섬 2개의 해안가 좌표들을 가져와 사이 거리를 비교하여 가장 짧은 거리를 구함
			for (int i = 1; i <= islandIdx; i++) {
				for (int j = i + 1; j <= islandIdx; j++) {
					ArrayList<Point> points1 = beachFronts.get(i);
					ArrayList<Point> points2 = beachFronts.get(j);

					for (Point p1 : points1) {
						for (Point p2 : points2) {
							minLen = Math.min(minLen, Math.abs(p1.row - p2.row) + Math.abs(p1.col - p2.col) - 1);
						}
					}
				}
			}

			// 결과 값 출력
			System.out.println(minLen);
		}
	}

	/**
	 * 좌표 이너 클래스
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