package boj_2610;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2610번 (회의준비) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2610
 * @author devetude
 */
public class Main {
	// 무한대 상수
	private static final int INFINITE = 101;

	// 개행 문자 상수
	private static final char NEW_LINE = '\n';

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		// 거리 저장 배열 초기화
		int[][] distances = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i != j) {
					distances[i][j] = INFINITE;
				}
			}
		}

		while (M-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			distances[i][j] = distances[j][i] = 1;
		}

		br.close();

		// 플로이드 와샬 알고리즘을 통해 한 사람에서 다른 사람의 거리를 최소 거리로 변경
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (distances[i][j] > distances[i][k] + distances[k][j]) {
						distances[i][j] = Math.min(distances[i][j], distances[i][k] + distances[k][j]);
					}
				}
			}
		}

		// 그룹에 속하는 사람들의 인덱스를 저장하는 배열 리스트 배열 초기화
		ArrayList<Integer>[] groupPeopleIdxs = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			groupPeopleIdxs[i] = new ArrayList<>();
		}

		// 방문 여부 저장 배열 초기화
		boolean[] isVisited = new boolean[N + 1];

		// 루프를 돌며 각 그룹에 해당하는 사람들을 분류하여 추가
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (distances[i][j] != INFINITE && !isVisited[j]) {
					isVisited[j] = true;
					groupPeopleIdxs[i].add(j);
				}
			}
		}

		// 그룹 갯수 저장 변수 초기화
		int K = 0;

		// 대표자 인덱스 저장 배열 리스트 초기화
		ArrayList<Integer> groupLeaderIdxs = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			// 해당 그룹에 사람이 1명이라도 있을 경우에만
			if (groupPeopleIdxs[i].size() != 0) {
				// 그룹 갯수 1 증가
				K++;

				// 가장 멀리 떨어져있는 사람과의 가중치가 가장 작은 값, 그 인덱스를 저장하는 변수 초기화
				int min = Integer.MAX_VALUE;
				int minIdx = 0;

				// 그룹 내 한 사람을 기준으로 가장 멀리 떨어져있는 사람과의 가중치를 구함
				for (int start : groupPeopleIdxs[i]) {
					int max = Integer.MIN_VALUE;

					for (int end : groupPeopleIdxs[i]) {
						max = Math.max(max, distances[start][end]);
					}

					// 가중치가 더 작은 경우를 발견하면 값을 변경
					if (max < min) {
						min = max;
						minIdx = start;
					}
				}

				// 해당 그룹의 대표자 인덱스 저장 배열에 찾은 대표자의 인덱스를 추가
				groupLeaderIdxs.add(minIdx);
			}
		}

		// 대표자 인덱스 저장 배열 오름차순으로 정렬
		Collections.sort(groupLeaderIdxs);

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();
		sb.append(K).append(NEW_LINE);

		for (int groupLeaderIdx : groupLeaderIdxs) {
			sb.append(groupLeaderIdx).append(NEW_LINE);
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}