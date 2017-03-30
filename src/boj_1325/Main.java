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
	// 공백 문자 상수
	private static final char SPACE = ' ';

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 인접리스트 객체 변수 초기화
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

		// 결과 컴퓨터 배열리스트 초기화
		ArrayList<Integer> computers = new ArrayList<>(N + 1);

		// 최대 해킹 가능한 컴퓨터 숫자 저장 변수 초기화
		int maxCnt = 0;

		for (int i = 1; i <= N; i++) {
			// 방문 여부 확인 배열 초기화
			boolean[] isVisited = new boolean[N + 1];
			isVisited[i] = true;

			// 큐 객체 변수 초기화
			Queue<Integer> queue = new LinkedList<>();
			queue.offer(i);

			// 해킹 가능한 컴퓨터 숫자 저장 변수 초기화
			int cnt = 0;

			// bfs 실행
			while (!queue.isEmpty()) {
				int current = queue.poll();

				for (int next : lists[current]) {
					if (!isVisited[next]) {
						cnt++;

						isVisited[next] = true;

						queue.offer(next);
					}
				}
			}

			// 저장되어있는 최대 해킹 가능한 컴퓨터 숫자보다 더 큰 값을 발견한 경우
			if (maxCnt < cnt) {
				maxCnt = cnt;
				computers.clear();
				computers.add(i);
			}

			// 저장되어있는 최대 해킹 가능한 컴퓨터 숫자와 같은 경우
			else if (maxCnt == cnt) {
				computers.add(i);
			}
		}

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (int computer : computers) {
			sb.append(computer).append(SPACE);
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}