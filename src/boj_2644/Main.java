package boj_2644;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2644번 (촌수계산) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2644
 * @author devetude
 */
public class Main {
	// 촌수 계산 불가 상수
	private static final int INFINITE = 101;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int p1 = Integer.parseInt(st.nextToken());
		int p2 = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());

		// 사람 별 촌수 저장 배열 초기화
		int[][] distances = new int[n + 1][n + 1];

		// 초기에 촌수 저장 배열의 모든 값을 촌수 계산 불가로 설정
		for (int[] distance : distances) {
			Arrays.fill(distances, INFINITE);
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			// x와 y는 서로 1촌
			distances[x][y] = distances[y][x] = 1;
		}

		br.close();

		// 플로이드 와샬 알고리즘 실행 (최단 촌수 계산)
		for (int via = 1; via <= n; via++) {
			for (int u = 1; u <= n; u++) {
				for (int v = 1; v <= n; v++) {
					distances[u][v] = Math.min(distances[u][v], distances[u][via] + distances[via][v]);
				}
			}
		}

		// 결과 값 출력
		System.out.println(distances[p1][p2] == INFINITE ? -1 : distances[p1][p2]);
	}
}