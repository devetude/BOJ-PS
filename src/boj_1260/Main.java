package boj_1260;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1260번 (DFS와 BFS) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1260
 * @author devetude
 */
public class Main {
	// 개행 문자열 상수
	private static final String NEW_LINE = "\n";

	// 공백 문자열 상수
	private static final String SPACE = " ";

	// 노드 방문 여부 확인 배열
	private static boolean[] isVisited = new boolean[1001];

	// 인접 행렬
	private static int[][] adjacencyMatrix = new int[1001][1001];

	// 노드 갯수 저장 변수
	private static int N = 0;

	// 결과 값 저장 버퍼
	private static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		// 인접 행렬을 만듬
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			adjacencyMatrix[u][v] = adjacencyMatrix[v][u] = 1;
		}

		br.close();

		// dfs 탐색
		dfs(V);

		sb.append(NEW_LINE);

		// 노드 방문 여부 확인 배열 초기화
		Arrays.fill(isVisited, false);

		// bfs 탐색
		bfs(V);

		// 버퍼를 통해 결과 값 출력
		System.out.println(sb.toString());
	}

	/**
	 * dfs 탐색 메소드
	 * 
	 * @param u
	 */
	private static void dfs(int u) {
		sb.append(u).append(SPACE);
		isVisited[u] = true;

		for (int v = 1; v <= N; v++) {
			if (!isVisited[v] && adjacencyMatrix[u][v] == 1) {
				dfs(v);
			}
		}
	}

	/**
	 * bfs 탐색 메소드
	 * 
	 * @param u
	 */
	private static void bfs(int u) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(u);

		while (!queue.isEmpty()) {
			u = queue.poll();
			sb.append(u).append(SPACE);
			isVisited[u] = true;

			for (int v = 1; v <= N; v++) {
				if (!isVisited[v] && adjacencyMatrix[u][v] == 1) {
					isVisited[v] = true;
					queue.offer(v);
				}
			}
		}
	}
}