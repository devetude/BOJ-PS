package boj_1918;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 백준 온라인 저지 1918번 (후위표기식) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1918
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 스택 객체 변수 초기화
		Stack<Character> stack = new Stack<>();

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		// 스택을 이용해 후위표기식으로 변경
		for (char c : br.readLine().toCharArray()) {
			switch (c) {
			case '(':
				stack.push(c);

				break;

			case '+':
			case '-':
				while (!stack.isEmpty() && stack.peek() != '(') {
					sb.append(stack.pop());
				}

				stack.push(c);

				break;

			case '*':
			case '/':
				char top;

				while (!stack.isEmpty() && (top = stack.peek()) != '(') {
					if (top == '*' || top == '/')
						sb.append(stack.pop());
					else
						break;
				}

				stack.push(c);

				break;

			case ')':
				while (stack.peek() != '(') {
					sb.append(stack.pop());
				}

				stack.pop();

				break;

			default:
				sb.append(c);
			}
		}

		br.close();

		while (!stack.isEmpty())
			sb.append(stack.pop());

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}