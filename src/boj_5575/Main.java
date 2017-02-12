package boj_5575;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 5575번 (타임 카드) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/5575
 * @author devetude
 */
public class Main {
	// 문자열 상수
	private static final String SPACE = " ";
	private static final String NEW_LINE = "\n";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			// 종료와 시작 시간 사이의 시간 저장 변수 (단위 : 초)
			int termSec = 0;

			for (int j = 0; j < 3; j++) {
				termSec -= Integer.parseInt(st.nextToken()) * Math.pow(60, 2 - j);
			}

			for (int j = 0; j < 3; j++) {
				termSec += Integer.parseInt(st.nextToken()) * Math.pow(60, 2 - j);
			}

			// 문제의 조건에 맞게 양식(시 분 초) 변경
			for (int j = 2; j >= 0; j--) {
				int divisor = (int) Math.pow(60, j);

				sb.append(termSec / divisor).append(SPACE);
				termSec %= divisor;
			}

			sb.append(NEW_LINE);
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}