package boj_1389;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1389번 (케빈 베이컨의 6단계 법칙) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1389
 * @author devetude
 */
public class Main {
	private static final int MAX_REALATION_CNT = 101;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 관계 저장 배열 초기화
		int[][] networks = new int[N + 1][N + 1];

		for (int[] network : networks) {
			Arrays.fill(network, MAX_REALATION_CNT);
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			networks[v][u] = networks[u][v] = 1;
		}

		br.close();

		// 플로이드 와샬 알고리즘 실행 (최단 가중치로 변경하는 작업)
		for (int via = 1; via <= N; via++) {
			for (int start = 1; start <= N; start++) {
				for (int end = 1; end <= N; end++) {
					networks[start][end] = Math.min(networks[start][end], networks[start][via] + networks[via][end]);
				}
			}
		}

		// 케빈 베이컨의 수가 가장 작은 사람을 찾음
		int minSum = MAX_REALATION_CNT;
		int res = 1;

		for (int start = 1; start <= N; start++) {
			int sum = 0;

			for (int end = 1; end <= N; end++) {
				sum += networks[start][end];
			}

			if (minSum > sum) {
				minSum = sum;
				res = start;
			}
		}

		// 결과 값 출력
		System.out.println(res);
	}
}