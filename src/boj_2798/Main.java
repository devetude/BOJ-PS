package boj_2798;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2798번 (블랙잭) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2798
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] cards = new int[N];
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}

		br.close();

		int minDistanceWithM = M;

		// 루프를 돌며 3장의 카드의 합이 M과 최대한 가까운 경우를 구함
		MAIN_LOOP: for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (j == i) {
					continue;
				}

				for (int k = 0; k < N; k++) {
					if (k == i || k == j) {
						continue;
					}

					int sum = cards[i] + cards[j] + cards[k];

					if (sum == M) {
						minDistanceWithM = 0;

						break MAIN_LOOP;
					}

					if (sum < M) {
						minDistanceWithM = Math.min(minDistanceWithM, M - sum);
					}
				}
			}
		}

		// 결과 값 출력
		System.out.println(M - minDistanceWithM);
	}
}