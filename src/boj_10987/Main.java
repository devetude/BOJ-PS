package boj_10987;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 10987번 (모음의 개수) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/10987
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 모음 갯수 저장 변수 초기화
		int cnt = 0;

		// 모음 갯수를 셈
		for (char c : br.readLine().toCharArray()) {
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
				cnt++;
		}

		br.close();

		// 결과 값 출력
		System.out.println(cnt);
	}
}