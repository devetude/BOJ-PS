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

	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[M][N];

		for (int i = 0; i < M; i++) {
			// 백준 온라인 저지 데이터의 끝에 공백이 들어오는 버그가 있어 trim() 메소드를 사용
			st = new StringTokenizer(br.readLine().trim(), " ");

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		br.close();

		// 캐시 배열 초기화
		cache = new int[M][N];

		// 결과 값 출력
		System.out.println(count(M, N, map, 0, 0));
	}

	/**
	 * 내리막 길을 유지하는 dfs 검색 재귀 메소드
	 * 
	 * @param M
	 * @param N
	 * @param map
	 * @param i
	 * @param j
	 * @return
	 */
	private static int count(int M, int N, int[][] map, int i, int j) {
		// 기저조건 : (i, j)가 목적지인 (M - 1, N - 1)에 도달했을 경우 1을 리턴 (1가지 경우)
		if (i == M - 1 && j == N - 1) {
			return 1;
		}

		// 캐시 배열에 값이 있는 경우 캐시 값을 사용
		if (cache[i][j] != 0) {
			return cache[i][j];
		}

		// 경우의 수 변수
		int counts = 0;

		// 맵을 벗어나지 않는 좌표면서, 내리막을 유지하는 경우에만 탐색
		if (i + 1 <= M - 1 && map[i][j] > map[i + 1][j]) {
			counts += count(M, N, map, i + 1, j);
		}

		if (i - 1 >= 0 && map[i][j] > map[i - 1][j]) {
			counts += count(M, N, map, i - 1, j);
		}

		if (j + 1 <= N - 1 && map[i][j] > map[i][j + 1]) {
			counts += count(M, N, map, i, j + 1);
		}

		if (j - 1 >= 0 && map[i][j] > map[i][j - 1]) {
			counts += count(M, N, map, i, j - 1);
		}

		// 결과 값 캐시에 저장 및 리턴
		return cache[i][j] = counts;
	}
}