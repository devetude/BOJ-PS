package boj_9935;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 9935번 (문자열 폭발) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/9935
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] inputChars = br.readLine().toCharArray();
		char[] boomChars = br.readLine().toCharArray();

		// 결과를 저장 할 스택 배열과 포인터 초기화
		char[] stack = new char[inputChars.length];
		int tos = -1;

		// 루프를 돌며 결과를 만듬
		for (final char C : inputChars) {
			// 스택에 입력된 문자 저장
			stack[++tos] = C;

			// 폭발 문자열 완성 확인 변수 초기화
			boolean isBoomed = true;

			// 폭발 문자열 검사
			for (int i = 0; i < boomChars.length; i++) {
				if (stack[tos - i] != boomChars[boomChars.length - 1 - i]) {
					isBoomed = false;

					break;
				}
			}

			// 폭발 문자열이 완성된 경우 스택 포인터 조정
			if (isBoomed)
				tos -= boomChars.length;
		}

		br.close();

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i <= tos; i++)
			sb.append(stack[i]);

		// 결과 값 한꺼번에 출력 (문제의 조건에 따라 남아있는 문자열이 없는 경우 FRULA 출력)
		System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
	}
}