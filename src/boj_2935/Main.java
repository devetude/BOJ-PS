package boj_2935;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**
 * 백준 온라인 저지 2935번 (소음) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2935
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigDecimal A = new BigDecimal(br.readLine());
		String operator = br.readLine();
		BigDecimal B = new BigDecimal(br.readLine());
		br.close();

		// 연산자가 +일 경우
		if (operator.equals("+")) {
			// 결과 값 출력
			System.out.println(A.add(B));
		}

		// 연산자가 *일 경우
		else {
			// 결과 값 출력
			System.out.println(A.multiply(B));
		}
	}
}