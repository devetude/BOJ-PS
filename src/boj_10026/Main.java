package boj_10026;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 백준 온라인 저지 10026번 (적록색약) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/10026
 * @author devetude
 */
public class Main {
	// 방향 배열 상수 (동, 서, 남, 북)
	private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	// 방향 행, 열 상수
	private static final int ROW = 0;
	private static final int COL = 1;

	// 공백 문자 상수
	private static final char SPACE = ' ';
	private static final char RED = 'R';
	private static final char GREEN = 'G';
	private static final char BLUE = 'B';

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		char[][] canvas = new char[N][N];

		for (int row = 0; row < N; row++) {
			char[] pixels = br.readLine().toCharArray();

			for (int col = 0; col < N; col++) {
				canvas[row][col] = pixels[col];
			}
		}

		br.close();

		// 보통 사람의 영역 갯수를 bfs로 구함
		boolean[][] isChecked = new boolean[N][N];
		int normalAreaCnt = 0;

		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (!isChecked[row][col]) {
					normalAreaCnt++;

					char searchColor = canvas[row][col];

					isChecked[row][col] = true;

					Queue<Pixel> queue = new LinkedList<>();
					queue.offer(new Pixel(row, col));

					while (!queue.isEmpty()) {
						Pixel current = queue.poll();

						for (final int[] DIRECTION : DIRECTIONS) {
							int nextRow = current.row + DIRECTION[ROW];
							int nextCol = current.col + DIRECTION[COL];

							if (0 <= nextRow && nextRow < N && 0 <= nextCol && nextCol < N) {
								if (canvas[nextRow][nextCol] == searchColor && !isChecked[nextRow][nextCol]) {
									isChecked[nextRow][nextCol] = true;
									queue.offer(new Pixel(nextRow, nextCol));
								}
							}
						}
					}
				}
			}
		}

		// 색맹인 사람의 영역 갯수를 bfs로 구함
		isChecked = new boolean[N][N];
		int colorBlindnessAreaCnt = 0;

		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (!isChecked[row][col]) {
					colorBlindnessAreaCnt++;

					char searchColor = canvas[row][col];

					isChecked[row][col] = true;

					Queue<Pixel> queue = new LinkedList<>();
					queue.offer(new Pixel(row, col));

					while (!queue.isEmpty()) {
						Pixel current = queue.poll();

						for (final int[] DIRECTION : DIRECTIONS) {
							int nextRow = current.row + DIRECTION[ROW];
							int nextCol = current.col + DIRECTION[COL];

							if (0 <= nextRow && nextRow < N && 0 <= nextCol && nextCol < N) {
								if (!isChecked[nextRow][nextCol]) {
									char nextColor = canvas[nextRow][nextCol];

									switch (searchColor) {
									case RED:
									case GREEN:
										if (nextColor == RED || nextColor == GREEN) {
											isChecked[nextRow][nextCol] = true;
											queue.offer(new Pixel(nextRow, nextCol));
										}

										break;

									case BLUE:
										if (nextColor == BLUE) {
											isChecked[nextRow][nextCol] = true;
											queue.offer(new Pixel(nextRow, nextCol));
										}

										break;
									}
								}
							}
						}
					}
				}
			}
		}

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();
		sb.append(normalAreaCnt).append(SPACE).append(colorBlindnessAreaCnt);

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}

	/**
	 * 픽셀 이너 클래스
	 * 
	 * @author devetude
	 */
	private static class Pixel {
		public int row;
		public int col;

		/**
		 * 생성자
		 * 
		 * @param row
		 * @param col
		 */
		public Pixel(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}