package boj_13277;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 13277번 (큰 수 곱셈) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/13277
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		br.close();

		BigDecimal A = new BigDecimal(st.nextToken());
		BigDecimal B = new BigDecimal(st.nextToken());

		// 결과 값 출력
		System.out.println(A.multiply(B).toString());
	}
}