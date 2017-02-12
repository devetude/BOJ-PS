package boj_2823;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2823번 (유턴 싫어) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2823
 * @author devetude
 */
public class Main {
	// 길 표시 문자 상수
	private static final char BUILDING = 'X';
	private static final char LOAD = '.';

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		// 지도 배열 초기화
		char[][] map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String line = br.readLine();

			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		br.close();

		// 결과 값 저장 변수
		int res = 0;

		// 루프를 돌며 막혀있는 경우를 확인함
		MAIN_LOOP: for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				// 길 인 경우
				if (map[i][j] == LOAD) {
					// 인접한(동, 서, 남, 북) 방향에 있는 빌딩 수 저장 변수
					int adjacencyBuildingCnt = 0;

					// 동쪽 방향이 배열의 범위를 벗어나거나 빌딩이 있는 경우
					if (i == 0 || map[i - 1][j] == BUILDING) {
						adjacencyBuildingCnt++;
					}

					// 서쪽 방향이 배열의 범위를 벗어나거나 빌딩이 있는 경우
					if (i + 1 == R || map[i + 1][j] == BUILDING) {
						adjacencyBuildingCnt++;
					}

					// 남쪽 방향이 배열의 범위를 벗어나거나 빌딩이 있는 경우
					if (j + 1 == C || map[i][j + 1] == BUILDING) {
						adjacencyBuildingCnt++;
					}

					// 북쪽 방향이 배열의 범위를 벗어나거나 빌딩이 있는 경우
					if (j == 0 || map[i][j - 1] == BUILDING) {
						adjacencyBuildingCnt++;
					}

					// 인접한 방향에 있는 빌딩 수가 3개 이상인 경우 막혀있는 경우로 판단
					if (adjacencyBuildingCnt >= 3) {
						// 결과 값 변경
						res = 1;

						break MAIN_LOOP;
					}
				}
			}
		}

		// 결과 값 출력
		System.out.println(res);
	}
}