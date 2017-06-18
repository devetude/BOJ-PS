package boj_1935;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 백준 온라인 저지 1935번 (후위표기식2) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1935
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		char[] chars = br.readLine().toCharArray();
		double[] nums = new double[N];

		for (int i = 0; i < N; i++) {
			nums[i] = Double.parseDouble(br.readLine());
		}

		br.close();

		// 스택 객체 변수 초기화
		Stack<Double> stack = new Stack<>();

		// 스택을 이용하여 후위표기식 계산
		for (char c : chars) {
			if (c == '+')
				stack.push(stack.pop() + stack.pop());

			else if (c == '-') {
				double b = stack.pop();
				double a = stack.pop();
				stack.push(a - b);
			}

			else if (c == '*')
				stack.push(stack.pop() * stack.pop());

			else if (c == '/') {
				double b = stack.pop();
				double a = stack.pop();
				stack.push(a / b);
			}

			else
				stack.push(nums[c - 65]);
		}

		// 결과 값 출력 (문제의 조건에서 소숫점 둘째자리까지 출력)
		System.out.printf("%.2f", stack.pop());
	}
}