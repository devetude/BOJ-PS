package boj_1325;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1325번 (효율적인 해킹) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1325
 * @author devetude
 */
public class Main {
	private static final char SPACE = ' ';

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] lists = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			lists[i] = new ArrayList<>();
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			lists[B].add(A);
		}

		br.close();

		ArrayList<Integer> computers = new ArrayList<>();
		int maxDepth = 0;

		for (int i = 1; i <= N; i++) {
			int[] isVisited = new int[N + 1];
			isVisited[i] = 1;

			Queue<Integer> queue = new LinkedList<>();
			queue.offer(i);

			while (!queue.isEmpty()) {
				int current = queue.poll();

				for (int next : lists[current]) {
					if (isVisited[next] == 0) {
						isVisited[next] = isVisited[current] + 1;

						queue.offer(next);
					}
				}
			}

			for (int j = 1; j <= N; j++) {
				if (maxDepth < isVisited[j]) {
					maxDepth = isVisited[j];
					computers.clear();
					computers.add(i);
				}

				else if (maxDepth == isVisited[j] && !computers.contains(i)) {
					computers.add(i);
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int computer : computers) {
			sb.append(computer).append(SPACE);
		}

		System.out.println(sb.toString());
	}
}