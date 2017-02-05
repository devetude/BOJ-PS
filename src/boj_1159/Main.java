package boj_1159;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 1159번 (농구 경기) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1159
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 성의 첫번째 알파벳 빈도 저장 배열
		int[] cnts = new int[26];

		while (N-- != 0) {
			cnts[(br.readLine().charAt(0)) - 97]++;
		}

		br.close();

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 26; i++) {
			// 성의 첫 글자 빈도가 5 이상 일 경우에만
			if (cnts[i] >= 5) {
				// 버퍼에 성의 첫번째 알파벳을 담음
				sb.append((char) (i + 97));
			}
		}

		if (sb.length() == 0) {
			// 성의 첫 글자 빈도가 5 이상인 경우가 없을 경우에 'PREDAJA' 출력
			System.out.println("PREDAJA");
		}

		else {
			// 결과 값 출력
			System.out.println(sb.toString());
		}
	}
}