package boj_9536;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 9536번 (여우는 어떻게 울지?) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/9536
 * @author devetude
 */
public class Main {
	// 문자열 상수
	private static final String SPACE = " ";
	private static final String WHAT_DOES_THE_FOX_SAY = "what does the fox say?";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);
			HashSet<String> checkedSounds = new HashSet<>();
			String line;

			while (!(line = br.readLine()).equals(WHAT_DOES_THE_FOX_SAY)) {
				checkedSounds.add(line.split(" ")[2]);
			}

			while (st.hasMoreTokens()) {
				final String SOUND = st.nextToken();

				if (!checkedSounds.contains(SOUND)) {
					sb.append(SOUND).append(SPACE);
				}
			}
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}