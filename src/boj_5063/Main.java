package boj_5063;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 5063번 (TGN) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/5063
 * @author devetude
 */
public class Main {
	// 결과 문자열 상수
	private static final String ADVERTISE = "advertise";
	private static final String DOSE_NOT_MATTER = "dose not matter";
	private static final String DO_NOT_ADVERTISE = "do not advertise";

	// 개행 문자열 상수
	private static final String NEW_LINE = "\n";

	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (N-- != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());

			// 버퍼를 이용해 결과 값을 만듬
			if (r > e) {
				sb.append(DO_NOT_ADVERTISE);
			}

			else if (r < e) {
				sb.append(ADVERTISE);
			}

			else {
				sb.append(DOSE_NOT_MATTER);
			}

			sb.append(NEW_LINE);
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}