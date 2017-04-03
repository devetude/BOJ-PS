package boj_2251;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * 백준 온라인 저지 2251번 (물통) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2251
 * @author devetude
 */
public class Main {
	// 물통 상수
	private static final int A = 0;
	private static final int B = 1;
	private static final int C = 2;

	// 공백 문자 상수
	private static final char SPACE = ' ';

	// 물통 별 담을 수 있는 물의 양 저장 배열
	private static int[] volumes = null;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// 물통 별 다음 수 있는 물의 양 저장 배열 초기화
		volumes = new int[3];

		for (int i = 0; i < 3; i++) {
			volumes[i] = Integer.parseInt(st.nextToken());
		}

		br.close();

		// 방문 여부 확인 배열 초기화 (방문했다는 것은 해당 물의 양을 만들 수 있다는 의미)
		boolean[][][] isVisited = new boolean[volumes[A] + 1][volumes[B] + 1][volumes[C] + 1];
		isVisited[0][0][volumes[C]] = true;

		// 큐 객체 변수 초기화
		Queue<Status> queue = new LinkedList<>();
		queue.offer(new Status(0, 0, volumes[C]));

		// 결과 저장 트리셋 객체 변수 초기화
		TreeSet<Integer> treeSet = new TreeSet<>();

		// bfs 실행
		while (!queue.isEmpty()) {
			Status cur = queue.poll();
			int curA = cur.A;
			int curB = cur.B;
			int curC = cur.C;

			// A 물통의 현재 값이 0이면 결과 저장 해시셋에 C저장
			if (curA == 0) {
				treeSet.add(curC);
			}

			// C에서 A로 옮길 수 있는 물의 양을 구함
			int mv = calcMoveVolume(cur, C, A);

			// 옮기는 물의 양이 0보다 클 경우만
			if (mv > 0) {
				int nextA = curA + mv;
				int nextB = curB;
				int nextC = curC - mv;

				// 이미 방문한적이 없는 경우에만 탐색
				if (!isVisited[nextA][nextB][nextC]) {
					isVisited[nextA][nextB][nextC] = true;
					queue.offer(new Status(nextA, nextB, nextC));
				}
			}

			// C에서 B로 옮길 수 있는 물의 양을 구함
			mv = calcMoveVolume(cur, C, B);

			// 옮기는 물의 양이 0보다 클 경우만
			if (mv > 0) {
				int nextA = curA;
				int nextB = curB + mv;
				int nextC = curC - mv;

				// 이미 방문한적이 없는 경우에만 탐색
				if (!isVisited[nextA][nextB][nextC]) {
					isVisited[nextA][nextB][nextC] = true;
					queue.offer(new Status(nextA, nextB, nextC));
				}
			}

			// A에서 C로 옮길 수 있는 물의 양을 구함
			mv = calcMoveVolume(cur, A, C);

			// 옮기는 물의 양이 0보다 클 경우만
			if (mv > 0) {
				int nextA = curA - mv;
				int nextB = curB;
				int nextC = curC + mv;

				// 이미 방문한적이 없는 경우에만 탐색
				if (!isVisited[nextA][nextB][nextC]) {
					isVisited[nextA][nextB][nextC] = true;
					queue.offer(new Status(nextA, nextB, nextC));
				}
			}

			// A에서 C로 옮길 수 있는 물의 양을 구함
			mv = calcMoveVolume(cur, A, B);

			// 옮기는 물의 양이 0보다 클 경우만
			if (mv > 0) {
				int nextA = curA - mv;
				int nextB = curB + mv;
				int nextC = curC;

				// 이미 방문한적이 없는 경우에만 탐색
				if (!isVisited[nextA][nextB][nextC]) {
					isVisited[nextA][nextB][nextC] = true;
					queue.offer(new Status(nextA, nextB, nextC));
				}
			}

			// B에서 A로 옮길 수 있는 물의 양을 구함
			mv = calcMoveVolume(cur, B, A);

			// 옮기는 물의 양이 0보다 클 경우만
			if (mv > 0) {
				int nextA = curA + mv;
				int nextB = curB - mv;
				int nextC = curC;

				// 이미 방문한적이 없는 경우에만 탐색
				if (!isVisited[nextA][nextB][nextC]) {
					isVisited[nextA][nextB][nextC] = true;
					queue.offer(new Status(nextA, nextB, nextC));
				}
			}

			// B에서 C로 옮길 수 있는 물의 양을 구함
			mv = calcMoveVolume(cur, B, C);

			// 옮기는 물의 양이 0보다 클 경우만
			if (mv > 0) {
				int nextA = curA;
				int nextB = curB - mv;
				int nextC = curC + mv;

				// 이미 방문한적이 없는 경우에만 탐색
				if (!isVisited[nextA][nextB][nextC]) {
					isVisited[nextA][nextB][nextC] = true;
					queue.offer(new Status(nextA, nextB, nextC));
				}
			}
		}

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (int res : treeSet) {
			sb.append(res).append(SPACE);
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}

	/**
	 * from에서 to로 옮길 물의 양을 구하는 메소드
	 * 
	 * @param s
	 * @param from
	 * @param to
	 * @return
	 */
	private static int calcMoveVolume(Status s, int from, int to) {
		int moveVolume = 0;

		switch (from) {
		case A:
			moveVolume = s.A;
			break;
		case B:
			moveVolume = s.B;
			break;
		case C:
			moveVolume = s.C;
			break;
		}

		int saveVolume = 0;

		switch (to) {
		case A:
			saveVolume = volumes[A] - s.A;
			break;
		case B:
			saveVolume = volumes[B] - s.B;
			break;
		case C:
			saveVolume = volumes[C] - s.C;
			break;
		}

		if (moveVolume > saveVolume) {
			moveVolume = saveVolume;
		}

		return moveVolume;
	}

	/**
	 * 상태 이너 클래스
	 * 
	 * @author devetude
	 */
	private static class Status {
		public int A;
		public int B;
		public int C;

		/**
		 * 생성자
		 * 
		 * @param A
		 * @param B
		 * @param C
		 */
		public Status(int A, int B, int C) {
			this.A = A;
			this.B = B;
			this.C = C;
		}
	}
}