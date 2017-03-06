package boj_2583;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2583번 (영역 구하기) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2583
 * @author devetude
 */
public class Main {
	// 문자 상수
	private static final char NEW_LINE = '\n';
	private static final char SPACE = ' ';

	// 방향 배열 상수 (동, 서, 남, 북)
	private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	// 방향 배열 행, 열 상수
	private static final int X = 1;
	private static final int Y = 0;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 캔버스 배열 초기화
		boolean[][] canvas = new boolean[M][N];

		while (K-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int sX = Integer.parseInt(st.nextToken());
			int sY = Integer.parseInt(st.nextToken());
			int eX = Integer.parseInt(st.nextToken());
			int eY = Integer.parseInt(st.nextToken());

			// 직사각형이 그려지는 영역을 참 값으로 설정
			for (int row = sY; row < eY; row++) {
				for (int col = sX; col < eX; col++) {
					canvas[row][col] = true;
				}
			}
		}

		br.close();

		// 큐 객체 변수 초기화
		Queue<Point> queue = new LinkedList<>();

		// 영역 갯수 저장 변수 초기화
		int areaCnt = 0;

		// 영역 별 크기를 담을 배열리스트 변수 초기화
		ArrayList<Integer> sizes = new ArrayList<>();

		// bfs를 실행하여 영역의 갯수와 영역 별 크기를 구함
		for (int y = 0; y < M; y++) {
			for (int x = 0; x < N; x++) {
				if (!canvas[y][x]) {
					int size = 0;

					areaCnt++;

					queue.offer(new Point(x, y));

					while (!queue.isEmpty()) {
						size++;

						Point current = queue.poll();
						canvas[current.y][current.x] = true;

						for (final int[] DIRECTION : DIRECTIONS) {
							int nextY = current.y + DIRECTION[Y];
							int nextX = current.x + DIRECTION[X];

							if (0 <= nextY && nextY < M && 0 <= nextX && nextX < N) {
								if (!canvas[nextY][nextX]) {
									canvas[nextY][nextX] = true;
									queue.offer(new Point(nextX, nextY));
								}
							}
						}
					}

					sizes.add(size);
				}
			}
		}

		// 오름차순으로 영역의 크기들을 정렬
		Collections.sort(sizes);

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();
		sb.append(areaCnt).append(NEW_LINE);

		for (int size : sizes) {
			sb.append(size).append(SPACE);
		}

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