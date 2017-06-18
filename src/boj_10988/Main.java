package boj_10988;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 10988번 (팰린드롬인지 확인하기) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/10988
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] chars = br.readLine().toCharArray();

		br.close();

		int last = chars.length / 2;

		for (int i = 0; i < last; i++) {
			// 팰린드롬이 아닌 경우
			if (chars[i] != chars[chars.length - i - 1]) {
				System.out.println(0);

				return;
			}
		}

		// 팰린드롬인 경우
		System.out.println(1);
	}
}