package boj_10384;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 10384번 (팬그램) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/10384
 * @author devetude
 */
public class Main {
	// 문자열 상수
	private static final String NEW_LINE = "\n";
	private static final String CASE = "Case ";
	private static final String COLON = ": ";

	// 결과 문자열 배열 상수
	private static final String[] RESULTS = { "Not a pangram", "Pangram!", "Double pangram!!", "Triple pangram!!!" };

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			char[] inputChars = br.readLine().toCharArray();

			// 알파벳 등장 횟수 저장 배열 초기화
			int[] cnts = new int[26];

			for (char c : inputChars) {
				// 소문자인 경우 (a의 아스키 값은 97)
				if ('a' <= c && c <= 'z') {
					// 글자의 등장 횟수 1 증가
					cnts[(int) c - 97]++;
				}

				// 대문자인 경우 (A의 아스키 값은 65)
				else if ('A' <= c && c <= 'Z') {
					// 소문자로 변환된 글자의 등장 횟수 1 증가
					cnts[(int) c - 65]++;
				}
			}

			// 가장 적게 등장한 알파벳의 갯수 저장 변수 초기화
			int minCnt = Integer.MAX_VALUE;

			// 루프를 돌며 가장 적게 등장한 알파벳 갯수를 찾음
			for (int j = 0; j <= 25; j++) {
				minCnt = Math.min(minCnt, cnts[j]);
			}

			sb.append(CASE).append(i).append(COLON).append(RESULTS[minCnt > 3 ? 3 : minCnt]).append(NEW_LINE);
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}