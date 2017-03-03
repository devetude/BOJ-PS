package boj_13241;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 13241번 (최소공배수) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/13241
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		br.close();

		// 두 수의 곱을 저장
		long multiplyAB = A * B;

		// 유클리드 알고리즘을 통해 최대공약수를 구함
		while (B > 0) {
			long tmp = B;
			B = A % B;
			A = tmp;
		}

		// 결과 값 출력
		// (최소공배수 = 두 수의 곱 / 최대공약수)
		System.out.println(multiplyAB / A);
	}
}