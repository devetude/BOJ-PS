package boj_6603;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 6603번 (로또) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/6603
 * @author devetude
 */
public class Main {
	// 문자열 상수
	private static final String EOF = "0";
	private static final String SPACE = " ";
	private static final String NEW_LINE = "\n";

	// 숫자 집합 배열
	private static int[] S = null;

	// 결과 값 저장 버퍼 객체 변수
	private static StringBuilder sb = null;

	// 스택 객체 변수
	private static Stack<Integer> stack = null;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;

		// 버퍼를 통해 결과 값을 만듬
		sb = new StringBuilder();

		while (!(line = br.readLine()).equals(EOF)) {
			StringTokenizer st = new StringTokenizer(line, " ");
			int k = Integer.parseInt(st.nextToken());

			// 숫자 집합 배열 초기화
			S = new int[k];

			for (int i = 0; i < k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}

			// 스택 객체 변수 초기화
			stack = new Stack<>();

			// kC6 조합 결과를 구함
			combination(k, 6, 0);
			sb.append(NEW_LINE);
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}

	/**
	 * 조합 결과 생성 재귀 메소드
	 * 
	 * @param n
	 * @param r
	 * @param idx
	 */
	private static void combination(int n, int r, int idx) {
		if (r == 0) {
			appendResult();

			return;
		}

		else if (n == r) {
			for (int i = 0; i < n; i++) {
				stack.push(S[idx + i]);
			}

			appendResult();

			for (int i = 0; i < n; i++) {
				stack.pop();
			}
		}

		else {
			stack.push(S[idx]);
			combination(n - 1, r - 1, idx + 1);

			stack.pop();
			combination(n - 1, r, idx + 1);
		}
	}

	/**
	 * 조합 결과를 버퍼에 추가하는 메소드
	 */
	private static void appendResult() {
		for (Integer s : stack) {
			sb.append(s).append(SPACE);
		}

		sb.append(NEW_LINE);
	}
}