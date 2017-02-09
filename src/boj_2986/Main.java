package boj_2986;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 2986번 (파스칼) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2986
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();

		// N의 제곱근 저장 변수
		int sqrtN = (int) Math.sqrt(N);

		// 가장 큰 약수 저장 변수
		int max = 1;

		// 루프를 돌며 N 보다 작은 N의 가장 큰 약수를 찾음
		for (int i = sqrtN; 2 <= i; i--) {
			if (N % i == 0) {
				max = Math.max(i, N / i);
			}
		}

		// 결과 값 출력
		// (문제의 조건에서 counter = N - max)
		System.out.println(N - max);
	}
}