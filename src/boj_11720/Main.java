package boj_11720;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 11720번 (숫자의 합) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/11720
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		char[] numChars = br.readLine().toCharArray();
		int sum = 0;

		for (char numChar : numChars) {
			sum += Character.getNumericValue(numChar);
		}

		br.close();

		// 결과 값 출력
		System.out.println(sum);
	}
}