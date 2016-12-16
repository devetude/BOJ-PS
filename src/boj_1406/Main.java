package boj_1406;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1406번 (에디터) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1406
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String initStr = br.readLine();
		int commandCnt = Integer.parseInt(br.readLine());

		// 커서의 동작을 저장하기 위해 왼쪽 스택과 오른쪽 스택을 선언
		Stack<String> leftStack = new Stack<String>();
		Stack<String> rightStack = new Stack<String>();

		// 초기 문자열의 길이를 가져옴
		int initStrLen = initStr.length();

		// 초기에 커서는 문자열의 오른쪽 맨 끝에 위치 (모든 문자열을 왼쪽 스택에 넣음)
		for (int i = 0; i < initStrLen; i++) {
			leftStack.push(String.valueOf(initStr.charAt(i)));
		}

		// 명령어의 갯수 만큼 루프 실행
		while (commandCnt > 0) {
			commandCnt--;

			// 명령어를 받음
			String command = br.readLine();

			switch (command) {
			case "L":
				if (!leftStack.isEmpty()) {
					// 커서를 왼쪽으로 이동 (왼쪽 문자열 1개를 오른쪽으로 옮김)
					rightStack.push(leftStack.pop());
				}

				break;

			case "D":
				if (!rightStack.isEmpty()) {
					// 커서를 오른쪽으로 이동 (오른쪽 문자열 1개를 왼쪽으로 옮김)
					leftStack.push(rightStack.pop());
				}

				break;

			case "B":
				if (!leftStack.isEmpty()) {
					// 문자열을 지움 (왼쪽 문자열 1개를 꺼냄)
					leftStack.pop();
				}

				break;

			default:
				// 문자열을 추가 (왼쪽에 문자열 추가)
				StringTokenizer st = new StringTokenizer(command, " ");
				st.nextToken();
				leftStack.push(st.nextToken());
			}
		}

		br.close();

		// 왼쪽 스택에 있는 문자열을 1개씩 꺼내어 오른쪽 스택으로 모두 옮김
		while (!leftStack.isEmpty()) {
			rightStack.push(leftStack.pop());
		}

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		// 오른쪽 스택에 있는 문자열을 1개씩 꺼내어 결과 값을 만듬
		while (!rightStack.isEmpty()) {
			sb.append(rightStack.pop());
		}

		// 결과 값 출력
		System.out.println(sb.toString());
	}
}