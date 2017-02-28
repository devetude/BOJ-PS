package boj_5558;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 5558번 (치 ~ 즈) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/5558
 * @author devetude
 */
public class Main {
	// 지점 문자 상수 (시작, 길, 장애물)
	private static final char START = 'S';
	private static final char ROAD = '.';
	private static final char OBSTACLE = 'X';

	// 4방향 배열 상수 (동, 서, 남, 북)
	private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	// 행, 열 상수
	private static final int ROW = 0;
	private static final int COL = 1;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		// 맵 배열 초기화
		char[][] map = new char[H][W];

		// 시작점 및 먹이 지점 저장 해시맵 초기화
		HashMap<Character, Point> spots = new HashMap<>();

		// 루프를 돌며 지도를 만듬
		for (int i = 0; i < H; i++) {
			char[] items = br.readLine().toCharArray();

			for (int j = 0; j < W; j++) {
				map[i][j] = items[j];

				// 시작점 및 먹의 지점일 경우 해시맵에 해당 좌표를 저장
				if (!(map[i][j] == ROAD || map[i][j] == OBSTACLE)) {
					spots.put(map[i][j], new Point(i, j));
				}
			}
		}

		// 키 값이 'S'로 저장되어있는 시작점을 '0'으로 변경
		spots.put('0', spots.get(START));
		spots.remove(START);

		br.close();

		// 다음 방문 지점 저장 변수
		int nextSpot = 0;

		// 결과 값 저장 변수
		int res = 0;

		// 마지막 먹이가 있는 지점까지 루프 실행
		while (nextSpot < N) {
			// bfs 탐색을 위해 큐 객체 변수 초기화
			Queue<Point> queue = new LinkedList<>();

			// 시작 지점을 넣어
			queue.offer(spots.get(Character.forDigit(nextSpot, 10)));

			// bfs 방문 여부 저장 배열 초기화
			int[][] check = new int[H][W];

			// bfs 실행
			while (!queue.isEmpty()) {
				Point point = queue.poll();

				// 깊이 값을 변경
				check[point.x][point.y]++;

				for (final int[] direction : DIRECTIONS) {
					int nextRow = point.x + direction[ROW];
					int nextCol = point.y + direction[COL];

					if (0 <= nextRow && nextRow < H && 0 <= nextCol && nextCol < W) {
						if (map[nextRow][nextCol] != OBSTACLE && check[nextRow][nextCol] == 0) {
							// 깊이 값을 변경
							check[nextRow][nextCol] += check[point.x][point.y];

							queue.offer(new Point(nextRow, nextCol));
						}
					}
				}
			}

			nextSpot++;
			Point point = spots.get(Character.forDigit(nextSpot, 10));

			// 중간 도착점의 깊이를 결과 변수에 더함
			// (중간 도착점의 깊이는 중간 도착점까지 걸린 시간과 같음)
			res += check[point.x][point.y] - 1;
		}

		// 결과 값 출력
		System.out.println(res);
	}

	/**
	 * 좌표 이너 클래스
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