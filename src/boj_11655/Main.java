package boj_11655;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 11655번 (ROT13) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/11655
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] chars = br.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();

		for (char c : chars) {
			// 문자의 아스키 코드 값을 구함
			int ascii = (int) c;

			// A ~ M과 a ~ m에 해당 할 경우, 원래 아스키 코드 값에 13을 더하여 암호화
			if ((65 <= ascii && ascii <= 77) || (97 <= ascii && ascii <= 109)) {
				ascii += 13;
			}

			// O ~ Z와 o ~ z에 해당 할 경우, 원래 아스키 코드 값에 13을 빼서 암호화
			else if ((78 <= ascii && ascii <= 90) || (110 <= ascii && ascii <= 122)) {
				ascii -= 13;
			}

			// 버퍼를 이용해 결과 값을 만듬
			sb.append((char) ascii);
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}