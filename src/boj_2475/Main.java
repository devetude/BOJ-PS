package boj_2475;

import java.util.Scanner;

/**
 * 백준 온라인 저지 2475번 (검증수) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/2475
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 입력 값을 받음
		Scanner sc = new Scanner(System.in);
		int powerSum = 0;

		for (int i = 0; i < 5; i++) {
			// 입력 값의 제곱의 합을 구함
			powerSum += Math.pow(sc.nextInt(), 2);
		}

		sc.close();

		// 제곱들의 합에서 10을 나눈 나머지를 결과 값으로 출력
		System.out.println(powerSum % 10);
	}
}