package boj_1197;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1197번 (최소 스패닝 트리) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1197
 * @author devetude
 */
public class Main {
	// 공백 문자열 상수
	private static final String SPACE = " ";

	// 부모 노드 저장 배열
	private static int[] parents = null;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		// 우선순위 큐 객체 변수 초기화
		PriorityQueue<Bridge> priorityQueue = new PriorityQueue<>(E);

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), SPACE);
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			priorityQueue.offer(new Bridge(A, B, C));
		}

		br.close();

		// 부모 노드 저장 배열 초기화
		parents = new int[V + 1];

		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}

		// 비용 합계 저장 변수 초기화
		long totalCost = 0;

		// 크루스컬 알고리즘 실행
		while (V > 1) {
			Bridge bridge = priorityQueue.poll();

			if (union(bridge.from, bridge.to)) {
				totalCost += bridge.cost;
				V--;
			}
		}

		// 결과 값 출력
		System.out.println(totalCost);
	}

	/**
	 * 파인드 메소드
	 * 
	 * @param k
	 * @return
	 */
	private static int find(int k) {
		if (parents[k] == k) {
			return k;
		}

		return parents[k] = find(parents[k]);
	}

	/**
	 * 유니온 메소드
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private static boolean union(int a, int b) {
		int aParents = find(a);
		int bParents = find(b);

		if (aParents != bParents) {
			parents[bParents] = aParents;

			return true;
		}

		return false;
	}

	/**
	 * 간선 이너 클래스
	 * 
	 * @author devetude
	 */
	private static class Bridge implements Comparable<Bridge> {
		public int from;
		public int to;
		public int cost;

		public Bridge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Bridge b) {
			return cost < b.cost ? -1 : 1;
		}
	}
}