package boj_11048;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 11048번 (이동하기) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/11048
 * @author devetude
 */
public class Main {
	private static int[][] cache = null;

	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		br.close();

		// 캐시 배열 초기화
		cache = new int[N + 1][M + 1];

		// 사탕의 값이 0부터 100까지 임으로 캐시 배열의 값을 -1로 채움
		for (int[] c : cache) {
			Arrays.fill(c, -1);
		}

		// 결과 값 출력
		System.out.println(count(N, M, map, 1, 1));
	}

	/**
	 * 최대 가져 올 수 있는 사탕의 수를 계산하는 재귀 메소드
	 * 
	 * @param N
	 * @param M
	 * @param map
	 * @param i
	 * @param j
	 * @return
	 */
	private static int count(int N, int M, int[][] map, int i, int j) {
		// 기저조건1 : 미로 바깥으로 나가는 경우 (탈락) 최저 값을 리턴
		if (i > N || j > M) {
			return Integer.MIN_VALUE;
		}

		// 기저조건2 : 미로를 탈출 한 경우 해당 방의 사탕의 갯수를 리턴
		if (i == N && j == M) {
			return map[i][j];
		}

		// 캐시 배열에 값이 있는 경우 캐시 값을 사용
		if (cache[i][j] != -1) {
			return cache[i][j];
		}

		// (i + 1, j), (i, j + 1), (i + 1, j + 1) 중 최대로 가져올 수 있는 사탕 값을 셈 (재귀)
		int maxCounts = count(N, M, map, i + 1, j) + map[i][j];
		maxCounts = Math.max(maxCounts, count(N, M, map, i, j + 1) + map[i][j]);
		maxCounts = Math.max(maxCounts, count(N, M, map, i + 1, j + 1) + map[i][j]);

		// 결과를 캐시에 저장 및 리턴
		return cache[i][j] = maxCounts;
	}
}