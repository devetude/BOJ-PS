package boj_2167;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2167번 (2차원 배열의 합) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/2167
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 행열 값 저장 배열
		int[][] arr = new int[N + 1][M + 1];

		// j열 까지 각 행별 부분 합 저장 배열
		int[][] subtotalPerLine = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// 행별 부분 합 저장 변수
			int lineSum = 0;

			for (int j = 1; j <= M; j++) {
				// 배열 값 저장
				arr[i][j] = Integer.parseInt(st.nextToken());

				// j열 까지 각 행별 부분 합 저장
				lineSum += arr[i][j];
				subtotalPerLine[i][j] = lineSum;
			}
		}

		int K = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			// 행별 부분 합 저장 변수
			int lineSum = 0;

			// 행 별로 i행 j열과 x행 y열의 부분 합을 이용한 전체 합을 구함
			for (int l = i; l <= x; l++) {
				lineSum += subtotalPerLine[l][y] - subtotalPerLine[l][j] + arr[l][j];
			}

			// 버퍼를 통해 결과 값을 만듬
			sb.append(lineSum).append("\n");
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}