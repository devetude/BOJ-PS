package boj_9012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 백준 온라인 저지 9012번 (괄호) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/9012
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			Stack<Character> stack = new Stack<Character>();
			char[] parenthesis = br.readLine().toCharArray();
			boolean res = true;

			for (char p : parenthesis) {
				// 왼쪽 괄호일 경우 스택에 넣음
				if (p == '(') {
					stack.push(p);
				}

				// 오른쪽 괄호일 경우 스택에서 뺌
				else {
					if (!stack.isEmpty()) {
						stack.pop();
					}

					else {
						// 짝이 안 맞는 경우 결과 값을 false로 바꿈
						res = false;

						break;
					}
				}
			}

			if (res) {
				// 스택에 남은 왼쪽 괄호가 있을 경우 결과 값을 false로 바꿈
				if (!stack.isEmpty()) {
					sb.append("NO\n");
				}

				else {
					sb.append("YES\n");
				}
			}

			else {
				sb.append("NO\n");
			}
		}

		br.close();

		// 버퍼를 통해 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}