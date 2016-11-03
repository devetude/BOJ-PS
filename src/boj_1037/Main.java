package boj_1037;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1037번 (약수) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1037
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int divisorsLen = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// 가장 큰 약수와 가장 작은 약수 변수
		int minDivisor = Integer.MAX_VALUE;
		int maxDivisor = Integer.MIN_VALUE;

		// 루프를 돌며 가장 큰 약수와 가장 작은 약수를 구함
		for (int i = 0; i < divisorsLen; i++) {
			int divisor = Integer.parseInt(st.nextToken());

			minDivisor = Math.min(minDivisor, divisor);
			maxDivisor = Math.max(maxDivisor, divisor);
		}

		br.close();

		// 결과 값 출력 (가장 큰 약수와 가장 작은 약수의 곱)
		System.out.println(minDivisor * maxDivisor);
	}
}