package boj_1100;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 1100번 (하얀 칸) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1100
 * @author devetude
 */
public class Main {
	// 문자 상수
	private static final char IS_FILLED = 'F';

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 결과 값 저장 변수
		int res = 0;

		// 루프를 돌며 체스판의 흰색 영역에 있는 말의 갯수를 셈
		for (int i = 0; i < 8; i++) {
			String line = br.readLine();

			for (int j = i % 2; j < 8; j += 2) {
				if (line.charAt(j) == IS_FILLED) {
					res++;
				}
			}
		}

		br.close();

		// 결과 값 출력
		System.out.println(res);
	}
}