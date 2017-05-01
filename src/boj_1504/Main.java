package boj_1504;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1504번 (특정한 최단 경로) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1504
 * @author devetude
 */
public class Main {
	// 무한대 상수
	private static final long INFINITE = 2_100_000_000;

	// 공백 문자열 상수
	private static final String SPACE = " ";

	// 사용자 입력 변수
	private static int N;

	// 인접리스트 객체 변수
	private static ArrayList<Node>[] list;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		// 인접리스트 초기화
		list = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		while (E-- > 0) {
			st = new StringTokenizer(br.readLine(), SPACE);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}

		st = new StringTokenizer(br.readLine(), SPACE);
		int mustA = Integer.parseInt(st.nextToken());
		int mustB = Integer.parseInt(st.nextToken());

		br.close();

		// A에서 B 사이 최단 거리를 구함
		long ABDist = getMinDist(mustA, mustB);

		// S->A->B->E와 S->B->A->E 중 최단 거리를 구함
		long route1Dist = getMinDist(1, mustA) + ABDist + getMinDist(mustB, N);
		long route2Dist = getMinDist(1, mustB) + ABDist + getMinDist(mustA, N);
		long minDist = Math.min(route1Dist, route2Dist);

		// 결과 값 출력 (예외 처리 : A->B를 거치는 경로를 만들어 낼 수 없는 경우 문제의 조건에 따라 -1 출력)
		System.out.println(minDist < INFINITE ? minDist : -1);
	}

	/**
	 * 두 정점의 최단 거리를 구하는 메소드
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	private static long getMinDist(int start, int end) {
		// 거리 저장 변수 초기화
		long[] distances = new long[N + 1];
		Arrays.fill(distances, INFINITE);
		distances[start] = 0;

		// 우선순위큐 객체 변수 초기화
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
		priorityQueue.offer(new Node(start, 0));

		// 다익스트라 알고리즘 실행
		while (!priorityQueue.isEmpty()) {
			Node current = priorityQueue.poll();

			if (current.cost > distances[current.idx]) {
				continue;
			}

			for (Node next : list[current.idx]) {
				long detour = distances[current.idx] + next.cost;

				if (distances[next.idx] > detour) {
					distances[next.idx] = detour;
					priorityQueue.offer(next);
				}
			}
		}

		return distances[end];
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