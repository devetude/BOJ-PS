package boj_5218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 5218번 (알파벳 거리) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/5218
 * @author devetude
 */
public class Main {
	// 문자열 상수
	private static final String SPACE = " ";
	private static final String NEW_LINE = "\n";
	private static final String DISTANCES = "Distances:";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		// 알파벳 거리 계산
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);
			char[] aChars = st.nextToken().toCharArray();
			char[] bChars = st.nextToken().toCharArray();

			sb.append(DISTANCES);

			for (int i = 0; i < aChars.length; i++) {
				int dist = bChars[i] - aChars[i];
				sb.append(SPACE).append(dist < 0 ? dist + 26 : dist);
			}

			sb.append(NEW_LINE);
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}