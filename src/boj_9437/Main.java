package boj_9437;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 9437번 (사라진 페이지 찾기) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/9437
 * @author devetude
 */
public class Main {
	// 문자 상수
	private static final char SPACE = ' ';
	private static final char NEW_LINE = '\n';

	// 입력 종료 문자열 상수
	private static final String EOF = "0";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		while (true) {
			String input = br.readLine();

			// 입력 종료 문자열이 들어온 경우
			if (input.equals(EOF)) {
				break;
			}

			StringTokenizer st = new StringTokenizer(input, " ");
			int N = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());

			// 기준점 (절반 기준으로 왼쪽, 오른쪽) 확인
			if (P <= N / 2) {
				// 홀수 페이지인 경우
				if (P % 2 != 0) {
					sb.append(P + 1).append(SPACE).append(N - P).append(SPACE).append(N - P + 1);
				}

				// 짝수 페이지인 경우
				else {
					sb.append(P - 1).append(SPACE).append(N - P + 1).append(SPACE).append(N - P + 2);
				}

			}

			else {
				// 홀수 페이지인 경우
				if (P % 2 != 0) {
					sb.append(N - P).append(SPACE).append(N - P + 1).append(SPACE).append(P + 1);
				}

				// 짝수 페이지인 경우
				else {
					sb.append(N - P + 1).append(SPACE).append(N - P + 2).append(SPACE).append(P - 1);
				}
			}

			sb.append(NEW_LINE);
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}