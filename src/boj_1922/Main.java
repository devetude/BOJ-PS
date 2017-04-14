package boj_1922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1922번 (네트워크 연결) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1922
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		// 인접 리스트 초기화
		ArrayList<Node>[] adjacencyList = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			adjacencyList[i] = new ArrayList<>();
		}

		while (M-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			adjacencyList[a].add(new Node(b, c));
			adjacencyList[b].add(new Node(a, c));
		}

		br.close();

		// 방문 노드 저장 배열 리스트 객체 변수 초기화
		ArrayList<Integer> isVisitedNode = new ArrayList<>(N + 1);
		isVisitedNode.add(1);

		// 방문 여부 저장 배열 초기화
		boolean[] isVisited = new boolean[N + 1];
		isVisited[1] = true;

		// 최소 비용 합계 저장 변수 초기화
		int totalMinCost = 0;

		// 프림 알고리즘 실행
		while (isVisitedNode.size() < N) {
			int minCost = Integer.MAX_VALUE;
			int minNextNode = -1;

			for (int currentNode : isVisitedNode) {
				for (Node nextNode : adjacencyList[currentNode]) {
					if (!isVisited[nextNode.idx] && nextNode.cost < minCost) {
						minCost = nextNode.cost;
						minNextNode = nextNode.idx;
					}
				}
			}

			isVisitedNode.add(minNextNode);
			isVisited[minNextNode] = true;
			totalMinCost += minCost;
		}

		// 결과 값 출력
		System.out.println(totalMinCost);
	}

	/**
	 * 노드 이너 클래스
	 * 
	 * @author devetude
	 */
	private static class Node {
		public int idx;
		public int cost;

		/**
		 * 생성자
		 * 
		 * @param idx
		 * @param cost
		 */
		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}
}