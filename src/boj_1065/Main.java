package boj_1065;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 1065번 (한수) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1065
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();

		// 한수의 갯수 저장 변수
		int counts = 0;

		for (int i = 1; i <= N; i++) {
			// 한수인지 검사
			if (isHansu(i)) {
				counts++;
			}
		}

		// 결과 값 출력
		System.out.println(counts);
	}

	/**
	 * 한수인지 검사하는 메소드
	 * 
	 * @param num
	 * @return
	 */
	public static boolean isHansu(int num) {
		char[] numChars = String.valueOf(num).toCharArray();
		int d = 0;

		if (numChars.length >= 2) {
			d = Character.getNumericValue(numChars[1]) - Character.getNumericValue(numChars[0]);
		}

		for (int i = 1; i < numChars.length - 1; i++) {
			if (d != Character.getNumericValue(numChars[i + 1]) - Character.getNumericValue(numChars[i])) {
				return false;
			}
		}

		return true;
	}
}