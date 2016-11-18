package boj_1964;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 1964번 (오각형, 오각형, 오각형…) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1964
 * @author devetude
 */
public class Main {
	private static final int MOD = 45678;

	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// int를 쓰면 범위를 초과하는 경우가 생기므로 long을 사용
		long N = Integer.parseInt(br.readLine());
		br.close();

		if (N == 1) {
			// 결과 값 출력
			System.out.println(5);
		}

		else {
			// 2항(4) 부터 공차가 3인 등차수열 형태를 이룸 (4 + (N - 1) * 3)
			// 결과 값 = 등차수열의 합 + 1 = N * (초항 + 끝항) / 2 + 1
			// = N * (4 + 4 + (N - 1) * 3) / 2 + 1
			// = N * (4 + 4 + 3N - 3) / 2 + 1
			// = N * (5 + 3 * N) / 2 + 1
			// 문제의 조건에서 45678로 모듈라 연산을 지시
			System.out.println((N * (5 + 3 * N) / 2 + 1) % MOD);
		}
	}
}