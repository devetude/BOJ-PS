package boj_1212;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 1212번 (8진수 2진수) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/1212
 * @author devetude
 */
public class Main {
	public static void main(String[] args) throws Exception {
		// 버퍼를 통해 입력을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String numStr = br.readLine();
		br.close();

		// 문자열을 길이를 저장
		int numStrLen = numStr.length();

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		// 첫째자리 수는 0으로 시작 할 수 없으므로 예외처리
		switch (numStr.charAt(0)) {
		case '0':
			sb.append("0");
			break;

		case '1':
			sb.append("1");
			break;

		case '2':
			sb.append("10");
			break;

		case '3':
			sb.append("11");
			break;

		case '4':
			sb.append("100");
			break;

		case '5':
			sb.append("101");
			break;

		case '6':
			sb.append("110");
			break;

		case '7':
			sb.append("111");
			break;
		}

		// 나머지 자리 2진수로 변환
		for (int i = 1; i < numStrLen; i++) {
			switch (numStr.charAt(i)) {
			case '0':
				sb.append("000");
				break;

			case '1':
				sb.append("001");
				break;

			case '2':
				sb.append("010");
				break;

			case '3':
				sb.append("011");
				break;

			case '4':
				sb.append("100");
				break;

			case '5':
				sb.append("101");
				break;

			case '6':
				sb.append("110");
				break;

			case '7':
				sb.append("111");
				break;
			}
		}

		// 결과 값 출력
		System.out.println(sb.toString());
	}
}