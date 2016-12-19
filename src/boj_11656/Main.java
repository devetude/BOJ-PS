package boj_11656;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 온라인 저지 11656번 (접미사 배열) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/11656
 * @author devetude
 */
public class Main {
	private static final String NEW_LINE = "\n";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		br.close();

		// 접미사 추출
		String[] suffix = new String[S.length()];

		for (int i = 0; i < suffix.length; i++) {
			suffix[i] = S.substring(i);
		}

		// 접미사를 사전순으로 정렬
		Arrays.sort(suffix);

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (String s : suffix) {
			sb.append(s).append(NEW_LINE);
		}

		// 결과 값 출력
		System.out.println(sb.toString());
	}
}