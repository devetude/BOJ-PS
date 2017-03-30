package boj_1507;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 번 () 문제풀이
 *
 * @see https://www.acmicpc.net/problem/
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] costs = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {
				int cost = Integer.parseInt(st.nextToken());

				if (cost <= N - 1) {
					costs[i][j] = cost;
				}
			}
		}

		br.close();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(costs[i][j] + "\t");
			}

			System.out.println();
		}
	}
}