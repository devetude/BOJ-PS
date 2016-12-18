package boj_11866;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 11866 (조세퍼스 문제 0) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/11866
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		br.close();

		// 큐에 1부터 N까지 넣음
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<");

		// 루프를 돌며 결과 값을 만듬
		while (queue.size() != 1) {
			for (int i = 1; i < M; i++) {
				queue.add(queue.poll());
			}

			sb.append(queue.poll()).append(", ");
		}

		sb.append(queue.poll()).append(">");

		// 결과 값 출력
		System.out.println(sb.toString());
	}
}