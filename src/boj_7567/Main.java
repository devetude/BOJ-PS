package boj_7567;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 7567번 (그릇) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/7567
 * @author devetude
 */
public class Main {
	public static void main(String[] args) throws Exception {
		// 입력 값을 버퍼를 이용해 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String bowls = br.readLine();
		br.close();

		int totalHeight = 10;
		int bowlsLen = bowls.length();

		// 이전 그릇 모양과 같으면 5를 더하고 다르면 10을 더함
		for (int i = 1; i < bowlsLen; i++) {
			if (bowls.charAt(i) == bowls.charAt(i - 1)) {
				totalHeight += 5;
			}

			else {
				totalHeight += 10;
			}
		}

		// 결과 값 출력
		System.out.println(totalHeight);
	}
}