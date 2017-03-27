package boj_2458;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2458번 (키 순서) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2458
 * @author devetude
 */
public class Main {
	// 무한대 상수
	private static final int INFINITE = 100_000;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());

		// 키 비교 가능 저장 배열 초기화
		int[][] seqs = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i != j) {
					seqs[i][j] = INFINITE;
				}
			}
		}

		int M = Integer.parseInt(st.nextToken());

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			seqs[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}

		br.close();

		// 플로이드 와샬 알고리즘을 이용하여 키 비교 가능 여부를 변경
		for (int via = 1; via <= N; via++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					seqs[i][j] = Math.min(seqs[i][j], seqs[i][via] + seqs[via][j]);
				}
			}
		}

		// 키를 비교 가능한 학생 수 저장 변수 초기화
		int cnt = N;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				// 키를 비교 불가능한 경우를 찾은 경우
				if (seqs[j][i] == INFINITE && seqs[i][j] == INFINITE) {
					// 키를 비교 가능한 학생 수 1 감소
					cnt--;

					break;
				}
			}
		}

		// 결과 값 한꺼번에 출력
		System.out.println(cnt);
	}
}