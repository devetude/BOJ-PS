package boj_1068;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1068번 (트리) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1068
 * @author devetude
 */
public class Main {
	// 방문 여부 확인 배열
	private static boolean[] isVisited = null;

	// 인접 리스트 객체 변수
	private static ArrayList<Integer>[] adjacencyLists = null;

	// 리프 노드 갯수 저장 변수
	private static int leafNodeCnt = 0;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// 인접 리스트 객체 변수 초기화
		adjacencyLists = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			adjacencyLists[i] = new ArrayList<>();
		}

		// 루트 노드 여부 확인 배열 초기화
		boolean[] isRootNode = new boolean[N];

		for (int i = 0; i < N; i++) {
			int parentNode = Integer.parseInt(st.nextToken());

			// 루트 노드가 아닐 경우 해당 부모 인접 리스트에 추가
			if (parentNode != -1) {
				adjacencyLists[parentNode].add(i);
			}

			// 루트 노드일 경우 루트 노트 표시
			else {
				isRootNode[i] = true;
			}
		}

		int D = Integer.parseInt(br.readLine());

		// 인접 리스트를 돌며 제거해야 할 노드를 제거함
		MAIN_LOOP: for (ArrayList<Integer> adjacencyList : adjacencyLists) {
			int adjacencyListSize = adjacencyList.size();

			for (int i = 0; i < adjacencyListSize; i++) {
				if (adjacencyList.get(i) == D) {
					adjacencyList.remove(i);

					break MAIN_LOOP;
				}
			}
		}

		// 방문 여부 확인 배열 초기화
		isVisited = new boolean[N];

		// 루트 노드인 경우 dfs를 통해 리프 노드 수를 구함
		for (int i = 0; i < N; i++) {
			if (isRootNode[i] && !isVisited[i] && i != D) {
				isVisited[i] = true;

				dfs(i);
			}
		}

		// 결과 값 출력
		System.out.println(leafNodeCnt);
	}

	/**
	 * dfs를 통해 리프 노드 수를 구하는 메소드
	 * 
	 * @param current
	 */
	private static void dfs(int current) {
		// 인접 리스트에 노드가 없는 경우 현재 노드는 리프 노드 임으로 리프 노드 수 1 증가
		if (adjacencyLists[current].size() == 0) {
			leafNodeCnt++;

			return;
		}

		// 리프 노드가 존재하는 경우 계속해서 탐색 실행
		for (int next : adjacencyLists[current]) {
			if (!isVisited[next]) {
				isVisited[next] = true;

				dfs(next);
			}
		}
	}
}