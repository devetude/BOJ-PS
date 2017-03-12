package boj_1967;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1967번 (트리의 지름) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1967
 * @author devetude
 */
public class Main {
	// 입력 변수
	private static int n = 0;

	// 인접 리스트 객체 변수
	private static HashMap<Integer, Integer>[] adjacencyList = null;

	@SuppressWarnings("unchecked")
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		// 인접 리스트 초기화
		adjacencyList = new HashMap[n + 1];

		for (int i = 1; i <= n; i++) {
			adjacencyList[i] = new HashMap<>();
		}

		for (int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			adjacencyList[u].put(v, cost);
			adjacencyList[v].put(u, cost);
		}

		br.close();

		// 결과 값 출력
		// (루트 노드에서 가장 먼 거리의 노드를 구하고 다시 그 노드에서 가장 먼 노드까지의 거리를 구함)
		System.out.println(getMostFarNodeInfo(getMostFarNodeInfo(1).key).value);
	}

	/**
	 * bfs를 통해 해당 정점에서 가장 멀리 떨어져 있는 노드 정보를 가져오는 메소드
	 * 
	 * @param start
	 * @return
	 */
	private static Pair<Integer, Integer> getMostFarNodeInfo(int start) {
		// 방문 여부 저장 배열 초기화
		int[] isVisited = new int[n + 1];

		// 큐 객체 변수 초기화
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);

		// 가장 멀리 떨어져 있는 노드 정보 저장 객체 초기화
		Pair<Integer, Integer> pair = new Pair<>(start, 0);

		// bfs 실행
		while (!queue.isEmpty()) {
			int current = queue.poll();

			Set<Integer> nexts = adjacencyList[current].keySet();

			for (int next : nexts) {
				if (isVisited[next] == 0) {
					isVisited[next] = isVisited[current] + adjacencyList[current].get(next);

					// 더 먼 거리의 노드를 발견한 경우
					if (pair.value < isVisited[next]) {
						pair.key = next;
						pair.value = isVisited[next];
					}

					queue.offer(next);
				}
			}
		}

		return pair;
	}

	/**
	 * 쌍 이너 클래스
	 * 
	 * @author devetude
	 *
	 * @param <Key>
	 * @param <Value>
	 */
	private static class Pair<Key, Value> {
		public Key key;
		public Value value;

		/**
		 * 생성자
		 * 
		 * @param key
		 * @param value
		 */
		public Pair(Key key, Value value) {
			this.key = key;
			this.value = value;
		}
	}
}