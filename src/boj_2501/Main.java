package boj_2501;

import java.util.Scanner;

/**
 * 백준 온라인 저지 2501번 (약수 구하기) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/2501
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 입력 값을 받음
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		sc.close();

		// 몇번째 약수인지 확인하는 변수
		int index = 0;

		// 1부터 N까지 루프를 돌면서 약수인지 확인
		for (int i = 1; i <= N; i++) {
			if (N % i == 0) {
				index++;

				// 약수 일 경우 K번째인지 확인
				if (index == K) {
					// 결과 값 출력
					System.out.println(i);
					return;
				}
			}
		}

		// 결과 값 출력 (약수 갯수보다 입력된 K가 클 경우)
		System.out.println(0);
	}
}