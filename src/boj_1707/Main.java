package boj_1707;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1707번 (이분 그래프) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1707
 * @author devetude
 */
public class Main {
	// 문자열 상수
	private static final String YES = "YES";
	private static final String NO = "NO";
	private static final String NEW_LINE = "\n";

	// 색상 저장 배열 (0 : 미방문, 1 : 빨강, 2 : 파랑)
	private static int[] color = null;

	// 인접 리스트
	private static ArrayList<Integer>[] adjacencyLists = null;

	@SuppressWarnings("unchecked")
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (K-- != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			// 인접 리스트 초기화
			adjacencyLists = new ArrayList[V + 1];

			for (int i = 1; i <= V; i++) {
				adjacencyLists[i] = new ArrayList<Integer>();
			}

			// 인접 리스트를 만듬
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				adjacencyLists[u].add(v);
				adjacencyLists[v].add(u);
			}

			// 색상 저장 배열 초기화
			color = new int[V + 1];

			// dfs 탐색 시작 (초기 1번 노드부터 빨강으로 지정)
			for (int u = 1; u <= V; u++) {
				if (color[u] == 0) {
					dfs(u, 1);
				}
			}

			// 이분 그래프인지 확인하기 위한 변수
			boolean res = true;

			breakOut: for (int u = 1; u <= V; u++) {
				for (int v : adjacencyLists[u]) {
					// 노드에 연결되어있는 노드 중 같은 색이 있다면 이분 그래프가 아님
					if (color[u] == color[v]) {
						res = false;

						break breakOut;
					}
				}
			}

			// 버퍼를 이용해 결과 값을 만듬
			if (res) {
				sb.append(YES);
			}

			else {
				sb.append(NO);
			}

			sb.append(NEW_LINE);
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}

	/**
	 * dfs 탐색 및 색상 설정 재귀 메소드
	 * 
	 * @param u
	 * @param c
	 */
	private static void dfs(int u, int c) {
		color[u] = c;

		for (int v : adjacencyLists[u]) {
			if (color[v] == 0) {
				// 출발 노드가 빨강(1) -> 도착 노드 파랑(2 = 3 - 1)
				// 출발 노드가 파랑(2) -> 도착 노드 빨강(1 = 3 - 2)
				// 따라서, 다음 색상은 3 - c
				dfs(v, 3 - c);
			}
		}
	}
}