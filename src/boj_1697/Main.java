package boj_1697;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1697번 (숨바꼭질) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1697
 * @author devetude
 */
public class Main {
	// 최대 사이즈 상수
	private static final int MAX_SIZE = 100_000;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		br.close();

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 방문 깊이 저장 배열 초기화
		int[] isVisited = new int[MAX_SIZE + 1];
		isVisited[N] = 0;

		// 큐 객체 변수 초기화
		Queue<Integer> queue = new LinkedList<>();

		// 현재 위치를 큐에 담음
		queue.offer(N);

		// dfs 탐색
		while (!queue.isEmpty()) {
			int current = queue.poll();

			if (current == K) {
				break;
			}

			if (0 <= current - 1 && isVisited[current - 1] == 0) {
				isVisited[current - 1] = isVisited[current] + 1;
				queue.offer(current - 1);
			}

			if (current + 1 <= MAX_SIZE && isVisited[current + 1] == 0) {
				isVisited[current + 1] = isVisited[current] + 1;
				queue.offer(current + 1);
			}

			if (current * 2 <= MAX_SIZE && isVisited[current * 2] == 0) {
				isVisited[current * 2] = isVisited[current] + 1;
				queue.offer(current * 2);
			}
		}

		// 결과 값 출력
		System.out.println(isVisited[K]);
	}
}