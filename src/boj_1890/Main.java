package boj_1890;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1890번 (점프) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1890
 * @author devetude
 */
public class Main {
	// 크기 변수
	private static int N = 0;

	// 지도 배열 변수
	private static int[][] map = null;

	// 캐시 배열 변수 (map[row][col] = 해당 지점까지 도달할 수 있는 경우의 수)
	private static long[][] cache = null;

	public static void main(String args[]) throws Exception {
		// 버퍼를 이용하여 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		// 지도 배열 변수 초기화
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		br.close();

		// 캐시 배열 변수 초기화
		cache = new long[N][N];

		// 결과 값 출력
		System.out.println(dfs(0, 0));
	}

	/**
	 * dfs 탐색 메소드
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	private static long dfs(int row, int col) {
		// 기저 조건 1. 마지막 지점에 도달한 경우
		if (row == N - 1 && col == N - 1) {
			return 1;
		}

		// 기저 조건 2. 배열의 범위를 벗어났거나, 0을 만나서 더 이상 진행할 수 없는 경우
		if (row >= N || col >= N || map[row][col] == 0) {
			return 0;
		}

		// 캐시 값이 있는 경우 캐시 값 사용
		if (cache[row][col] != 0) {
			return cache[row][col];
		}

		// 아래로 점프하거나, 오른쪽으로 점프하는 경우의 수를 구한 후 결과 값을 캐시에 저장 후 리턴
		return cache[row][col] = dfs(row + map[row][col], col) + dfs(row, col + map[row][col]);
	}
}