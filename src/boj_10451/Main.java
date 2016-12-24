package boj_10451;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 10451번 (순열 사이클) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/10451
 * @author devetude
 */
public class Main {
	// 개행 문자열 상수
	private static final String NEW_LINE = "\n";

	// 방문 여부 확인 배열
	private static boolean[] isChecked = null;

	// 순열 저장 배열
	private static int[] nums = null;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (T-- != 0) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			// 순열 저장 (인덱스는 출발 노드, 값은 도착 노드를 의미)
			nums = new int[N + 1];

			for (int u = 1; u <= N; u++) {
				nums[u] = Integer.parseInt(st.nextToken());
			}

			// 방문 여부 확인 배열 초기화
			isChecked = new boolean[N + 1];

			// 순열 사이클 수 저장 변수
			int cycleCnt = 0;

			// dfs 탐색을 통해 순열 사이클 수를 셈 (순열 사이클 수 = 연결 요소의 수)
			for (int u = 1; u <= N; u++) {
				if (!isChecked[u]) {
					cycleCnt++;
					dfs(u);
				}
			}

			// 버퍼를 통해 결과 값을 만듬
			sb.append(cycleCnt).append(NEW_LINE);
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}

	/**
	 * dfs 탐색 재귀 메소드
	 * 
	 * @param u
	 */
	private static void dfs(int u) {
		isChecked[u] = true;

		if (!isChecked[nums[u]]) {
			dfs(nums[u]);
		}
	}
}