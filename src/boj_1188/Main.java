package boj_1188;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 백준 온라인 저지 2504번 (괄호의 값) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2504
 * @author devetude
 */
public class Main {
	// 괄호 문자열 상수
	private static final String OPEN_SMALL_BRACKET = "(";
	private static final String CLOSE_SMALL_BRACKET = ")";
	private static final String OPEN_MIDDLE_BRACKET = "[";
	private static final String CLOSE_MIDDLE_BRACKET = "]";

	// 숫자 문자열 상수
	private static final String TWO = "2";
	private static final String THREE = "3";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split("");
		br.close();

		// 스택 초기화
		Stack<String> stack = new Stack<>();

		try {
			// 루프를 돌며 괄호를 정리함
			for (String str : strs) {
				switch (str) {
				// '(', '[' (열리는 괄호) 일 경우 스택에 삽입
				case OPEN_SMALL_BRACKET:
				case OPEN_MIDDLE_BRACKET:
					stack.push(str);

					break;

				// ')' (닫히는 괄호) 일 경우
				case CLOSE_SMALL_BRACKET:
					// '()'를 만족하면
					if (stack.peek().equals(OPEN_SMALL_BRACKET)) {
						// '('를 스택에서 제거
						stack.pop();

						// '2'를 스택에 삽입
						stack.push(TWO);
					}

					else {
						int sum = 0;

						// '('가 나올때 까지 반복
						while (!stack.peek().equals(OPEN_SMALL_BRACKET)) {
							sum += Integer.parseInt(stack.pop());
						}

						// '('를 스택에서 제거
						stack.pop();

						// 'sum * 2'를 스택에 삽입
						stack.push(String.valueOf(sum * 2));
					}

					break;

				// ']' (닫히는 괄호) 일 경우
				case CLOSE_MIDDLE_BRACKET:
					// '[]'를 만족하면
					if (stack.peek().equals(OPEN_MIDDLE_BRACKET)) {
						// '['를 스택에서 제거
						stack.pop();

						// '3'를 스택에 삽입
						stack.push(THREE);
					}

					else {
						int sum = 0;

						// '['가 나올때 까지 반복
						while (!stack.peek().equals(OPEN_MIDDLE_BRACKET)) {
							sum += Integer.parseInt(stack.pop());
						}

						// '['를 스택에서 제거
						stack.pop();

						// 'sum * 3'를 스택에 삽입
						stack.push(String.valueOf(sum * 3));
					}

					break;
				}
			}

			// 스택에 남아있는 숫자들을 더해 결과 값을 구함
			int res = 0;

			while (!stack.isEmpty()) {
				res += Integer.parseInt(stack.pop());
			}

			// 결과 값 출력
			System.out.println(res);
		} catch (Exception e) {
			// 올바르지 못한 괄호를 연산하여 예외가 발생했을 경우 문제의 조건에 따라 0을 출력
			System.out.println(0);
		}
	}
}