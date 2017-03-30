package boj_1520;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1520번 (내리막 길) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1520
 * @author devetude
 */
public class Main {
	// 캐시 배열 ([i][j] = i행 j열 까지 내리막을 유지하면서 갈 수 있는 경우의 수)
	private static int[][] cache = null;

	// 방향 배열 상수
	private static final int[][] DIRECTIONS = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	// 방향 행, 열 상수
	private static final int ROW = 0;
	private static final int COL = 1;

	// 입력 값 저장 변수
	private static int M = 0;
	private static int N = 0;
	private static int[][] map = null;

	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		// 지도 배열 초기화
		map = new int[M][N];

		for (int row = 0; row < M; row++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int col = 0; col < N; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		br.close();

		// 캐시 배열 초기화
		cache = new int[M][N];

		for (int row = 0; row < M; row++) {
			for (int col = 0; col < N; col++) {
				cache[row][col] = -1;
			}
		}

		// 결과 값 출력
		System.out.println(count(0, 0));
	}

	/**
	 * 내리막 길을 유지하는 dfs 재귀 메소드
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	private static int count(int row, int col) {
		// 기저조건 : (i, j)가 목적지인 (M - 1, N - 1)에 도달했을 경우 1을 리턴 (1가지 경우)
		if (row == M - 1 && col == N - 1) {
			return 1;
		}

		// 캐시 배열에 값이 있는 경우 캐시 값을 사용
		if (cache[row][col] != -1) {
			return cache[row][col];
		}

		// 경우의 수 변수
		int counts = 0;

		for (final int[] DIRECTION : DIRECTIONS) {
			int nextRow = row + DIRECTION[ROW];
			int nextCol = col + DIRECTION[COL];

			// 맵을 벗어나지 않는 좌표면서, 내리막을 유지하는 경우에만 탐색
			if (0 <= nextRow && nextRow < M && 0 <= nextCol && nextCol < N) {
				if (map[nextRow][nextCol] < map[row][col]) {
					counts += count(nextRow, nextCol);
				}
			}
		}

		// 결과 값 캐시에 저장 및 리턴
		return cache[row][col] = counts;
	}
}