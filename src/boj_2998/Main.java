package boj_2998;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 2998번 (8진수) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2998
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		br.close();

		// 앞에 0을 맞추어 붙임
		int inputLen = input.length();
		int groupCnt = inputLen / 3;
		int requiredZeroCnt = 3 - inputLen % 3;

		if (requiredZeroCnt != 3) {
			groupCnt++;
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < requiredZeroCnt; i++)
				sb.append(0);

			input = sb.append(input).toString();
		}

		char[] chars = input.toCharArray();

		// 버퍼를 이용해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < groupCnt; i++) {
			if (chars[3 * i] == '0' && chars[3 * i + 1] == '0' && chars[3 * i + 2] == '0')
				sb.append(0);
			else if (chars[3 * i] == '0' && chars[3 * i + 1] == '0' && chars[3 * i + 2] == '1')
				sb.append(1);
			else if (chars[3 * i] == '0' && chars[3 * i + 1] == '1' && chars[3 * i + 2] == '0')
				sb.append(2);
			else if (chars[3 * i] == '0' && chars[3 * i + 1] == '1' && chars[3 * i + 2] == '1')
				sb.append(3);
			else if (chars[3 * i] == '1' && chars[3 * i + 1] == '0' && chars[3 * i + 2] == '0')
				sb.append(4);
			else if (chars[3 * i] == '1' && chars[3 * i + 1] == '0' && chars[3 * i + 2] == '1')
				sb.append(5);
			else if (chars[3 * i] == '1' && chars[3 * i + 1] == '1' && chars[3 * i + 2] == '0')
				sb.append(6);
			else if (chars[3 * i] == '1' && chars[3 * i + 1] == '1' && chars[3 * i + 2] == '1')
				sb.append(7);
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}