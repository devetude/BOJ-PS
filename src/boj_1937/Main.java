package boj_1937;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1937번 (욕심쟁이 판다) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1937
 * @author devetude
 */
public class Main {
	// 캐시 배열 변수 ([행][열] = 최대한 살아있는 일 수)
	private static int[][] cache = null;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] forest = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < n; j++) {
				forest[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		br.close();

		// 캐시 배열 초기화
		cache = new int[n][n];

		// 최대 살 수 있는 일 수를 저장 할 변수
		int maxDays = 0;

		// 루프를 돌면서 최대 살 수 있는 일 수를 계산
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 현재 대나무 양을 저장
				int beforeBambooQuantity = forest[i][j];

				// 현재 자리로 돌아오는 것을 막기 위해 현재 대나무 양을 0으로 바꿈
				forest[i][j] = 0;

				// 상, 하, 좌, 우로 이동하는 경우 중 최대 살 수 있는 일 수를 구함
				maxDays = Math.max(maxDays, eat(n, forest, i + 1, j, beforeBambooQuantity) + 1);
				maxDays = Math.max(maxDays, eat(n, forest, i, j + 1, beforeBambooQuantity) + 1);
				maxDays = Math.max(maxDays, eat(n, forest, i - 1, j, beforeBambooQuantity) + 1);
				maxDays = Math.max(maxDays, eat(n, forest, i, j - 1, beforeBambooQuantity) + 1);

				// 현재 자리의 대나무 양을 다시 원래 값으로 복원
				forest[i][j] = beforeBambooQuantity;
			}
		}

		// 결과 값 출력
		System.out.println(maxDays);
	}

	/**
	 * 판다가 최대 살 수 있는 일 수를 구하는 메소드
	 * 
	 * @param n
	 * @param forest
	 * @param row
	 * @param col
	 * @param beforeBambooQuantity
	 * @return
	 */
	private static int eat(int n, int[][] forest, int row, int col, int beforeBambooQuantity) {
		// 기저조건 1 : 대나무 숲의 범위를 넘어갔을 경우 0을 리턴
		if (row < 0 || col < 0 || row > n - 1 || col > n - 1) {
			return 0;
		}

		// 기저조건 2 : 들렸던 대나무 숲을 또 들렸을 경우 0을 리턴
		if (forest[row][col] == 0) {
			return 0;
		}

		// 기저조건 3 : 이전 대나무 숲의 대나무 양보다 현재 대나무 숲의 대나무 양이 작거나 같을 경우 0을 리턴
		if (beforeBambooQuantity >= forest[row][col]) {
			return 0;
		}

		// 캐시 값이 있을 경우 캐시 값을 사용
		if (cache[row][col] != 0) {
			return cache[row][col];
		}

		// 최대 살 수 있는 일 수를 저장 할 변수
		int maxDays = 0;

		// 현재 대나무 양을 저장
		beforeBambooQuantity = forest[row][col];

		// 현재 자리로 돌아오는 것을 막기 위해 현재 대나무 양을 0으로 바꿈
		forest[row][col] = 0;

		// 상, 하, 좌, 우로 이동하는 경우 중 최대 살 수 있는 일 수를 구함
		maxDays = Math.max(maxDays, eat(n, forest, row + 1, col, beforeBambooQuantity) + 1);
		maxDays = Math.max(maxDays, eat(n, forest, row, col + 1, beforeBambooQuantity) + 1);
		maxDays = Math.max(maxDays, eat(n, forest, row - 1, col, beforeBambooQuantity) + 1);
		maxDays = Math.max(maxDays, eat(n, forest, row, col - 1, beforeBambooQuantity) + 1);

		// 현재 자리의 대나무 양을 다시 원래 값으로 복원
		forest[row][col] = beforeBambooQuantity;

		// 결과 값을 캐시에 저장하고 리턴
		return cache[row][col] = maxDays;
	}
}