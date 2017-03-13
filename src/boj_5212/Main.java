package boj_5212;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 5212번 (지구 온난화) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/5212
 * @author devetude
 */
public class Main {
	// 문자 상수
	private static final char LAND = 'X';
	private static final char SEA = '.';
	private static final char NEW_LINE = '\n';

	// 방향 배열 상수 (동, 서, 남, 북)
	private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	// 방향 배열 행, 열 상수
	private static final int ROW = 0;
	private static final int COL = 1;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		// 지도 배열 초기화
		char[][] map = new char[R][C];

		// 육지 좌표 저장 배열 리스트 객체 변수 초기화
		ArrayList<Point> lands = new ArrayList<>();

		for (int row = 0; row < R; row++) {
			char[] inputs = br.readLine().toCharArray();

			for (int col = 0; col < C; col++) {
				map[row][col] = inputs[col];

				if (map[row][col] == LAND) {
					lands.add(new Point(row, col));
				}
			}
		}

		br.close();

		// 50년 후 결과 저장 지도 배열 초기화
		char[][] resMap = new char[R][C];

		// 지도 그리기 시작, 종료점 행, 열 저장 변수 초기화
		int rowStart = R - 1;
		int rowEnd = 0;
		int colStart = C - 1;
		int colEnd = 0;

		// 루프를 돌며 50년 후 지도 상태를 만듬
		for (Point p : lands) {
			int nearSeaCnt = 0;

			for (final int[] DIRECTION : DIRECTIONS) {
				int nextRow = p.row + DIRECTION[ROW];
				int nextCol = p.col + DIRECTION[COL];

				if (0 <= nextRow && nextRow < R && 0 <= nextCol && nextCol < C) {
					if (map[nextRow][nextCol] == SEA) {
						nearSeaCnt++;
					}
				}

				else {
					nearSeaCnt++;
				}
			}

			if (nearSeaCnt < 3) {
				resMap[p.row][p.col] = LAND;
				rowStart = Math.min(rowStart, p.row);
				rowEnd = Math.max(rowEnd, p.row);
				colStart = Math.min(colStart, p.col);
				colEnd = Math.max(colEnd, p.col);
			}
		}

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (int row = rowStart; row <= rowEnd; row++) {
			for (int col = colStart; col <= colEnd; col++) {
				if (resMap[row][col] == LAND) {
					sb.append(LAND);
				}

				else {
					sb.append(SEA);
				}
			}

			sb.append(NEW_LINE);
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
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