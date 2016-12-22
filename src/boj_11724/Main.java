package boj_11724;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 11724번 (연결 요소의 개수) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/11724
 * @author devetude
 */
public class Main {
	// 이미 방문한 노드 확인 배열
	private static boolean[] isVisited = null;

	// 인접 행렬
	private static int[][] adjacencyMatrix = null;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// 입접 행렬을 만듬
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		adjacencyMatrix = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			adjacencyMatrix[u][v] = adjacencyMatrix[v][u] = 1;
		}

		br.close();

		// 이미 방문한 노드 확인 배열 초기화
		isVisited = new boolean[N + 1];

		// 연결 요소의 갯수 저장 변수
		int connectedFactorCnt = 0;

		// 인접행렬 dfs 탐색
		for (int v = 1; v <= N; v++) {
			if (!isVisited[v]) {
				dfs(v);

				// 연결 요소의 갯수 증가
				connectedFactorCnt++;
			}
		}

		// 결과 값 출력
		System.out.println(connectedFactorCnt);
	}

	/**
	 * dfs 탐색 메소드
	 * 
	 * @param u
	 */
	private static void dfs(int u) {
		// 시작 노드를 방문 처리
		isVisited[u] = true;

		// 시작 노드와 연결되어있는 노드를 dfs 탐색 재귀호출
		for (int v = 1; v < adjacencyMatrix[u].length; v++) {
			if (!isVisited[v] && adjacencyMatrix[u][v] == 1) {
				dfs(v);
			}
		}
	}
}