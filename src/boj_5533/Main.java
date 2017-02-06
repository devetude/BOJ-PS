package boj_5533;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 5533번 (유니크) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/5533
 * @author devetude
 */
public class Main {
	// 개행 문자열 상수
	private static final String NEW_LINE = "\n";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 문제별 점수 등장 횟수 저장 배열
		int[][] cnts = new int[3][101];

		// 사람별 문제 점수 저장 배열
		int[][] persons = new int[N][3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < 3; j++) {
				// 점수 저장
				persons[i][j] = Integer.parseInt(st.nextToken());

				// 점수 등장 횟수 저장
				cnts[j][persons[i][j]]++;
			}
		}

		br.close();

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			int sum = 0;

			for (int j = 0; j < 3; j++) {
				// 겹치는 점수가 없을 경우에만 점수를 더함
				if (cnts[j][persons[i][j]] == 1) {
					sum += persons[i][j];
				}
			}

			sb.append(sum).append(NEW_LINE);
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}