package boj_10820;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 10820번 (문자열 분석) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/10820
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		StringBuilder sb = new StringBuilder();

		while ((line = br.readLine()) != null) {
			char[] chars = line.toCharArray();
			int lowerCnt = 0;
			int upperCnt = 0;
			int numCnt = 0;
			int spaceCnt = 0;

			for (char c : chars) {
				int ascii = (int) c;

				// 공백 검출
				if (ascii == 32) {
					spaceCnt++;
				}

				// 숫자 검출
				else if (48 <= ascii && ascii <= 57) {
					numCnt++;
				}

				// 대문자 검출
				else if (65 <= ascii && ascii <= 90) {
					upperCnt++;
				}

				// 소문자 검출
				else {
					lowerCnt++;
				}
			}

			// 버퍼를 통해 결과 값을 만듬
			sb.append(lowerCnt).append(" ");
			sb.append(upperCnt).append(" ");
			sb.append(numCnt).append(" ");
			sb.append(spaceCnt).append("\n");
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}