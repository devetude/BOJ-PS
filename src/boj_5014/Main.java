package boj_5014;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 5014번 (스타트링크) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/5014
 * @author devetude
 */
public class Main {
	// 엘레베이터를 이용하여 도달할 수 없는 경우를 나타내는 문자열 상수
	private static final String NO_RESULT = "use the stairs";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		br.close();

		// 방문 여부 저장 배열 초기화
		int[] isVisited = new int[F + 1];
		isVisited[S] = 1;

		// 큐 객체 변수 초기화
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(S);

		// dfs를 실행하여 해당 층에 도달하기 위해 눌러야 할 버튼 수의 최솟값을 구함
		while (!queue.isEmpty()) {
			int current = queue.poll();

			if (current == G) {
				break;
			}

			int nextUp = current + U;

			if (nextUp <= F) {
				if (isVisited[nextUp] == 0) {
					isVisited[nextUp] = isVisited[current] + 1;
					queue.offer(nextUp);
				}
			}

			int nextDown = current - D;

			if (1 <= nextDown) {
				if (isVisited[nextDown] == 0) {
					isVisited[nextDown] = isVisited[current] + 1;
					queue.offer(nextDown);
				}
			}
		}

		// 결과 값 출력
		System.out.println(isVisited[G] > 0 ? isVisited[G] - 1 : NO_RESULT);
	}
}