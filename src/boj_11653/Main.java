package boj_11653;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 11653번 (소인수분해) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/11653
 * @author devetude
 */
public class Main {
	// 개행 문자열 상수
	private static final String NEW_LINE = "\n";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();
		int i = 2;

		while (N != 1) {
			if (N % i == 0) {
				sb.append(i).append(NEW_LINE);
				N /= i;
			}

			else {
				i++;
			}
		}

		// 결과 값 출력
		System.out.println(sb.toString());
	}
}