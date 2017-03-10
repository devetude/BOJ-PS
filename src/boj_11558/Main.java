package boj_11558;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 11558번 (The Game of Death) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/11558
 * @author devetude
 */
public class Main {
	// 개행 문자열 상수
	private static final String NEW_LINE = "\n";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());

			// 지목 상태 저장 배열 초기화
			int[] links = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				links[i] = Integer.parseInt(br.readLine());
			}

			// 방문 여부 저장 배열 초기화
			boolean[] isVisited = new boolean[N + 1];

			// 현재 방문점 저장 변수 초기화
			int current = 1;
			isVisited[current] = true;

			// 최소 횟수 저장 변수 초기화
			int K = 0;

			// 주경이를 찾을 때 까지 반복
			while (current != N) {
				// 아직 방문하지 않은 경우
				if (!isVisited[links[current]]) {
					// 횟수 1 증가
					K++;

					// 방문 여부 변경 및 다음 지목 상대를 방문점으로 변경
					isVisited[current = links[current]] = true;
				}

				else {
					// 사이클이 발생하였으나, 주경이를 찾지 못한 경우
					K = 0;

					break;
				}
			}

			sb.append(K).append(NEW_LINE);
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}