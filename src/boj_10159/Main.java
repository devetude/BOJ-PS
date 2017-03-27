package boj_10159;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 10159번 (저울) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/10159
 * @author devetude
 */
public class Main {
	// 무한대 상수
	private static final int INFINITE = 100_000;

	// 개행 문자 상수
	private static final char NEW_LINE = '\n';

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 순서 저장 배열 초기화
		int[][] seqs = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i != j) {
					seqs[i][j] = INFINITE;
				}
			}
		}

		int M = Integer.parseInt(br.readLine());

		while (M-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			seqs[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}

		br.close();

		// 플로이드 와샬 알고리즘을 이용하여 물건 간의 비교 가능 여부를 변경
		for (int via = 1; via <= N; via++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					seqs[i][j] = Math.min(seqs[i][j], seqs[i][via] + seqs[via][j]);
				}
			}
		}

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			// 두 물건을 비교 할 수 없는 경우의 수를 저장하는 변수 초기화
			int cnt = 0;

			for (int j = 1; j <= N; j++) {
				// 두 물건을 비교 할 수 없는 경우인 경우 1 증가
				if (seqs[j][i] == INFINITE && seqs[i][j] == INFINITE) {
					cnt++;
				}
			}

			sb.append(cnt).append(NEW_LINE);
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}