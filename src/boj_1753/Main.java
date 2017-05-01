package boj_1753;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1753번 (최단경로) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1753
 * @author devetude
 */
public class Main {
	// 무한대 상수
	private static final int INFINITE = 3_000_000;

	// 문자열 상수
	private static final String INF = "INF";
	private static final String NEW_LINE = "\n";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		// 인접리스트 초기화
		ArrayList<Node>[] list = new ArrayList[V + 1];

		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}

		while (E-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			list[start].add(new Node(end, cost));
		}

		br.close();

		// 거리 저장 배열 초기화
		int[] distances = new int[V + 1];
		Arrays.fill(distances, INFINITE);
		distances[K] = 0;

		// 방문 여부 저장 배열 초기화
		boolean[] isVisited = new boolean[V + 1];
		isVisited[0] = true;

		// 우선순위큐 객체 변수 초기화
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
		priorityQueue.offer(new Node(K, 0));

		// 다익스트라 알고리즘 실행
		while (!priorityQueue.isEmpty()) {
			Node current = priorityQueue.poll();

			if (current.cost > distances[current.idx]) {
				continue;
			}

			for (Node next : list[current.idx]) {
				int detour = distances[current.idx] + next.cost;

				if (distances[next.idx] > detour) {
					distances[next.idx] = detour;
					priorityQueue.offer(next);
				}
			}
		}

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= V; i++) {
			if (distances[i] < INFINITE) {
				sb.append(distances[i]);
			}

			else {
				sb.append(INF);
			}

			sb.append(NEW_LINE);
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}

	/**
	 * 정점 이너 클래스
	 * 
	 * @author devetude
	 */
	private static class Node implements Comparable<Node> {
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

		@Override
		public int compareTo(Node n) {
			return cost < n.cost ? -1 : 1;
		}
	}
}