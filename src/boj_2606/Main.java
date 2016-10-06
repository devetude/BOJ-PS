package boj_2606;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2606번 (바이러스) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/2606
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int pair = Integer.parseInt(br.readLine());
		int[][] path = new int[N + 1][N + 1];

		// 가중치가 1인 인접행렬을 만듬
		for (int i = 1; i <= pair; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			path[start][end] = 1;
			path[end][start] = 1;
		}

		br.close();

		HashSet<Integer> infectedComputers = new HashSet<>();

		// 시작점을 1로 하는 깊이우선탐색 시작
		dfs(path, 1, N, infectedComputers);

		// 결과 값은 시작 값인 자신(1)을 뺀 나머지 출력
		System.out.println(infectedComputers.size() - 1);
	}

	/**
	 * 깊이우선탐색 재귀 메소드
	 * 
	 * @param path
	 * @param start
	 * @param N
	 * @param infectedComputers
	 */
	private static void dfs(int[][] path, int start, int N, HashSet<Integer> infectedComputers) {
		// 기저조건 : 이미 들렸던 경로 일 경우 함수를 종료
		if (infectedComputers.contains(start)) {
			return;
		}

		// 경로를 추가
		infectedComputers.add(start);

		for (int i = 1; i <= N; i++) {
			if (path[start][i] == 1) {
				// 해당 시작점으로 부터 갈 수 있는 모든 도착점을 다시 시작점으로 넣고 메소드 재귀호출
				dfs(path, i, N, infectedComputers);
			}
		}
	}
}