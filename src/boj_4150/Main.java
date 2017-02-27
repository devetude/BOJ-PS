package boj_4150;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**
 * 백준 온라인 저지 4150번 (피보나치 수) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/4150
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		br.close();

		// 피보나치 배열 초기화
		BigDecimal[] fibo = new BigDecimal[N + 1];

		// 피보나치 수열의 첫번째와 두번째 값을 1로 설정
		fibo[1] = fibo[2] = BigDecimal.ONE;

		// N까지 피보나치 수열을 구함
		for (int i = 3; i <= N; i++) {
			fibo[i] = fibo[i - 2].add(fibo[i - 1]);
		}

		// 결과 값 출력
		System.out.println(fibo[N]);
	}
}