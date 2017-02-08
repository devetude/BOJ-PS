package boj_1788;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 1788번 (피보나치 수의 확장) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1788
 * @author devetude
 */
public class Main {
	// 모듈러 상수
	private static final int MOD = 1_000_000_000;

	// 개행 문자열 상수
	private static final String NEW_LINE = "\n";

	// 피보나치 배열
	private static int[] fibo = null;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();

		// n의 절댓값 저장 변수
		int absN = Math.abs(n);

		// 피보나치 배열 초기화
		fibo = new int[absN + 2];
		fibo[0] = 0;
		fibo[1] = 1;

		// bottom-up 방식 알고리즘을 사용
		// (문제의 조건에 따라 1,000,000,000로 모듈러 연산 실행)
		// (top-down 방식을 사용 할 경우 깊이가 깊어 stack overflow 발생)
		for (int i = 2; i <= absN; i++) {
			fibo[i] = (fibo[i - 1] % MOD + fibo[i - 2] % MOD) % MOD;
		}

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		// n이 음의 짝수인 경우 (fibo[n]이 음수)
		if (n < 0 && absN % 2 == 0) {
			sb.append(-1);
		}

		// n이 0인 경우 (fibo[n]이 0)
		else if (n == 0) {
			sb.append(0);
		}

		// n이 양수 또는 음의 홀수인 경우 (fibo[n]이 양수)
		else {
			sb.append(1);
		}

		sb.append(NEW_LINE);
		sb.append(fibo[absN]);

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}