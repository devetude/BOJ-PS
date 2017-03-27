package boj_1613;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1613번 (역사) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1613
 * @author devetude
 */
public class Main {
	// 무한대 상수
	private static final int INFINITE = 100_000;

	// 전후 관계 상수
	private static final int DONT_KNOW = 0;
	private static final int BEFORE = -1;
	private static final int AFTER = 1;

	// 개행 문자 상수 =
	private static final char NEW_LINE = '\n';

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());

		// 전후 관계 저장 배열 초기화
		int[][] seqs = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i != j) {
					seqs[i][j] = INFINITE;
				}
			}
		}

		int k = Integer.parseInt(st.nextToken());

		while (k-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			seqs[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}

		// 플로이드 와샬 알고리즘을 통해 전후 관계를 구함
		for (int via = 1; via <= n; via++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					seqs[i][j] = Math.min(seqs[i][j], seqs[i][via] + seqs[via][j]);
				}
			}
		}

		int s = Integer.parseInt(br.readLine());

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		while (s-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// a, b 사이의 관계를 알 수 없는 경우
			if (seqs[a][b] == INFINITE && seqs[b][a] == INFINITE) {
				sb.append(DONT_KNOW);
			}

			// a가 b보다 먼저 일어난 경우
			else if (seqs[a][b] < INFINITE) {
				sb.append(BEFORE);
			}

			// b가 a보다 먼저 일어난 경우
			else {
				sb.append(AFTER);
			}

			sb.append(NEW_LINE);
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}