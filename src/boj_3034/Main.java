package boj_3034;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 3034번 (앵그리 창영) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/3034
 * @author devetude
 */
public class Main {
	// 문자열 상수
	private static final String DA = "DA";
	private static final String NE = "NE";
	private static final String NEW_LINE = "\n";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		// 버터를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		while (N-- != 0) {
			// 최대 들어갈 수 있는 성냥의 길이는 상자의 대각선 길이
			if (Integer.parseInt(br.readLine()) <= Math.sqrt(Math.pow(W, 2.0f) + Math.pow(H, 2.0f))) {
				sb.append(DA);
			}

			else {
				sb.append(NE);
			}

			sb.append(NEW_LINE);
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}