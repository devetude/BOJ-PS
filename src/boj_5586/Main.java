package boj_5586;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 5586번 (JOI와 IOI) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/5586
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] inputChars = br.readLine().toCharArray();

		br.close();

		// 갯수 저장 변수 초기화
		int joiCnt = 0;
		int ioiCnt = 0;

		// 마지막 인덱스 상수 초기화
		final int LAST_IDX = inputChars.length - 2;

		// 루프를 돌며 JOI, IOI 갯수를 셈
		for (int i = 1; i <= LAST_IDX; i++) {
			if (inputChars[i] == 'O' && inputChars[i + 1] == 'I') {
				if (inputChars[i - 1] == 'J')
					joiCnt++;
				else if (inputChars[i - 1] == 'I')
					ioiCnt++;
			}
		}

		// 버퍼를 통해 결과 값 한꺼번에 출력
		System.out.println(new StringBuilder().append(joiCnt).append("\n").append(ioiCnt).toString());
	}
}