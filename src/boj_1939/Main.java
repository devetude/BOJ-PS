package boj_1939;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1939번 (중량제한) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1939
 * @author devetude
 */
public class Main {
	// 최대 중량 상수
	private static final int MAX_C = 1_000_000_000;

	// 사용자 입력 저장 변수
	private static ArrayList<Bridge>[] lists = null;
	private static short N = 0;
	private static short S = 0;
	private static short E = 0;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Short.parseShort(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 인접리스트 객체 변수 초기화
		lists = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			lists[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			short A = Short.parseShort(st.nextToken());
			short B = Short.parseShort(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			lists[A].add(new Bridge(B, C));
			lists[B].add(new Bridge(A, C));
		}

		st = new StringTokenizer(br.readLine(), " ");
		S = Short.parseShort(st.nextToken());
		E = Short.parseShort(st.nextToken());

		br.close();

		// 방문 여부 확인 배열 초기화
		boolean[] isVisited = new boolean[N + 1];
		isVisited[S] = true;

		// 우선순위 큐 객체 변수 초기화
		PriorityQueue<Bridge> priorityQueue = new PriorityQueue<>();
		priorityQueue.offer(new Bridge(S, 0));

		// 결과 값 저장 변수 초기화
		int res = MAX_C;

		// 우선순위 큐를 이용한 bfs 실행
		while (!priorityQueue.isEmpty()) {
			Bridge current = priorityQueue.poll();
			isVisited[current.idx] = true;

			// 계속해서 중량이 최대가 되는 경로 중 가장 작은 중량으로 변경
			res = Math.min(res, current.C);

			// 도착점에 해당 할 경우 탐색 종료
			if (current.idx == E) {
				System.out.println(res);

				break;
			}

			for (Bridge b : lists[current.idx]) {
				if (!isVisited[b.idx]) {
					priorityQueue.offer(b);
				}
			}
		}
	}

	/**
	 * 다리 이너 클래스
	 * 
	 * @author devetude
	 */
	private static class Bridge implements Comparable<Bridge> {
		public short idx;
		public int C;

		/**
		 * 생성자
		 * 
		 * @param idx
		 * @param C
		 */
		public Bridge(short idx, int C) {
			this.idx = idx;
			this.C = C;
		}

		@Override
		public int compareTo(Bridge b) {
			return C > b.C ? -1 : 1;
		}
	}
}