package boj_2609;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최대공약수와 최소공배수
 * 
 * @see https://www.acmicpc.net/problem/2609
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		br.close();

		// 두 수의 곱을 저장
		int multiplyAB = a * b;

		// 유클리드 호제법을 이용하여 최대공약수를 먼저 구함
		int gcd = 0;

		while (true) {
			if (b == 0) {
				gcd = a;
				break;
			}

			int tmp = b;
			b = a % b;
			a = tmp;
		}

		// 최소공배수(두 수의 곱 / 최대공약수)를 구함
		int lcm = multiplyAB / gcd;

		// 버퍼를 이용해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();
		sb.append(gcd).append(" ").append(lcm);

		// 결과 값 출력
		System.out.println(sb.toString());
	}
}