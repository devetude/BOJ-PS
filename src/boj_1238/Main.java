package boj_1238;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1238번 (파티) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1238
 * @author devetude
 */
public class Main {
	// 무한대 상수
	private static final int INFINITE = 100_001;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		// 인접 행렬 저장 배열 초기화
		int[][] matrix = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i != j) {
					matrix[i][j] = INFINITE;
				}
			}
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			matrix[i][j] = cost;
		}

		br.close();

		// 플로이드 와샬 알고리즘을 이용하여 인접 행렬 값을 변경
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
				}
			}
		}

		// 결과 값 저장 변수 초기화
		int max = 0;

		// X번 마을 까지 가는 거리와 오는 거리가 최대인 값을 구함
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, matrix[i][X] + matrix[X][i]);
		}

		// 결과 값 출력
		System.out.println(max);
	}
}