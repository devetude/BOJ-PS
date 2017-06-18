package boj_5598;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 5598번 (카이사르 암호) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/5598
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		// 카이사르 암호 해독
		for (char c : br.readLine().toCharArray())
			sb.append((char) (c < 68 ? c + 23 : c - 3));

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}