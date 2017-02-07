package boj_4153;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 4153번 (직각삼각형) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/4153
 * @author devetude
 */
public class Main {
	// 문자열 상수
	private static final String IS_BREAK = "0 0 0";
	private static final String RIGHT = "right";
	private static final String WRONG = "wrong";
	private static final String NEW_LINE = "\n";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		while (true) {
			String line = br.readLine().trim();

			// '0 0 0'이 입력되면 종료
			if (line.equals(IS_BREAK)) {
				break;
			}

			// 세 변의 길이를 배열에 저장
			StringTokenizer st = new StringTokenizer(line, " ");
			int[] edges = new int[3];

			for (int i = 0; i < 3; i++) {
				edges[i] = Integer.parseInt(st.nextToken());
			}

			// 세 변의 길이를 오름차순으로 정렬
			Arrays.sort(edges);

			// 피타고라스의 정리가 성립하는지 확인
			if (Math.pow(edges[2], 2) == Math.pow(edges[0], 2) + Math.pow(edges[1], 2)) {
				sb.append(RIGHT);
			}

			else {
				sb.append(WRONG);
			}

			sb.append(NEW_LINE);
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}