package boj_1874;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 백준 온라인 저지 1874번 (스택 수열) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1874
 * @author devetude
 */
public class Main {
	// 문자열 상수
	private static final String PUSH = "+\n";
	private static final String POP = "-\n";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] seq = new int[n];

		for (int i = 0; i < n; i++) {
			seq[i] = Integer.parseInt(br.readLine());
		}

		br.close();

		// 스택 객체 초기화
		Stack<Integer> stack = new Stack<>();

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();
		int j = 0;

		// 스택을 이용해 수열을 만듬
		for (int i = 1; i <= n; i++) {
			stack.push(i);
			sb.append(PUSH);

			while (!stack.isEmpty() && j < n && stack.peek() == seq[j]) {
				stack.pop();
				sb.append(POP);
				j++;
			}
		}

		// 수열을 못만든 경우
		if (!stack.isEmpty()) {
			System.out.println("NO");
		}

		// 스택을 이용해 수열을 성공적으로 만든 경우
		else {
			// 결과 값 한꺼번에 출력
			System.out.println(sb.toString());
		}
	}
}