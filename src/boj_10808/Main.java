package boj_10808;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 10808번 (알파벳 개수) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/10808
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] chars = br.readLine().toCharArray();
		br.close();

		// 알파벳 갯수 저장 배열
		int[] alphabetCnts = new int[26];

		// 입력 값의 각각의 알파벳 갯수를 셈
		for (char c : chars) {
			alphabetCnts[(int) c - 97]++;
		}

		// 버퍼를 이용해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 25; i++) {
			sb.append(alphabetCnts[i]).append(" ");
		}

		sb.append(alphabetCnts[25]);

		// 결과 값 출력
		System.out.println(sb.toString());
	}
}