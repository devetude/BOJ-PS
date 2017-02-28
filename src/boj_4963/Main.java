package boj_4963;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 4963번 (섬의 개수) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/4963
 * @author devetude
 */
public class Main {
	// 개행 문자열 상수
	private static final String NEW_LINE = "\n";

	// 방향 배열 상수 (동, 서, 남, 북 및 대각선 방향 포함)
	private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, -1 },
			{ -1, 1 }, { -1, -1 } };

	// 행, 열 상수
	private static final int ROW = 0;
	private static final int COL = 1;

	// 섬을 나타내는 상수
	private static final int IS_LAND = 1;

	// 입력 변수
	private static int w = 0;
	private static int h = 0;

	// 지도 배열
	private static int[][] map = null;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			// 문제의 조건에 따라, '0 0'이 입력되면 종료
			if (w == 0 && h == 0) {
				br.close();

				break;
			}

			// 지도 배열 초기화
			map = new int[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 섬의 갯수 저장 변수
			int cnt = 0;

			// dfs를 이용하여 섬의 갯수를 구함
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == IS_LAND) {
						cnt++;

						dfs(i, j);
					}
				}
			}

			sb.append(cnt).append(NEW_LINE);
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}

	/**
	 * dfs 재귀 메소드
	 * 
	 * @param i
	 * @param j
	 */
	private static void dfs(int i, int j) {
		// 다시 방문하지 않기 위해 해당 지점을 0으로 변경
		map[i][j] = 0;

		// 8방향을 돌며 지도를 벗어나지 않고 육지인 경우 dfs를 재귀 호출
		for (int[] direction : DIRECTIONS) {
			int nextRow = i + direction[ROW];
			int nextCol = j + direction[COL];

			if (0 <= nextRow && nextRow < h && 0 <= nextCol && nextCol < w && map[nextRow][nextCol] == IS_LAND) {
				dfs(nextRow, nextCol);
			}
		}
	}
}