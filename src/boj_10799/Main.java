package boj_10799;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 백준 온라인 저지 10799번 (쇠막대기) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/10799
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] brackets = br.readLine().toCharArray();
		br.close();

		Stack<Integer> stack = new Stack<Integer>();

		// 쇠막대기의 갯수 저장 변수
		int partitionCnt = 0;

		for (int i = 0; i < brackets.length; i++) {
			// '('일 경우 스택에 현재 깊이 삽입
			if (brackets[i] == '(') {
				stack.push(i);
			}

			// 레이저일 경우 스택에서 꺼낸 후, 쇠막대기 갯수 증가
			else if (i - stack.peek() == 1) {
				stack.pop();
				partitionCnt += stack.size();
			}

			// 쇠막대기일 경우 스택에서 꺼낸 후, 쇠막대기 갯수 증가
			else {
				stack.pop();
				partitionCnt++;
			}
		}

		// 결과 값 출력
		System.out.println(partitionCnt);
	}
}