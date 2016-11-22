package boj_9506;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 9506번 (약수들의 합) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/9506
 * @author devetude
 */
public class Main {
	// 결과 값 문자열 상수
	private static final String IS_NOT_PERFECT = " is NOT perfect.\n";
	private static final String NEW_LINE = "\n";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 루프를 돌며 -1이 입력 될 때 까지 실행
		while (true) {
			int n = Integer.parseInt(br.readLine());

			if (n == -1) {
				break;
			}

			// 버퍼를 이용해 결과 값을 만듬
			int sum = 0;
			StringBuilder sb2 = new StringBuilder();
			sb2.append(n).append(" = ");

			// n의 약수와 그 부분합을 구함
			for (int i = 1; i < n; i++) {
				if (n % i == 0) {
					System.out.println(i);
					sum += i;

					// 합이 n 보다 클 경우 멈춤 (가지치기)
					if (sum > n) {
						break;
					}

					else {
						sb2.append(i).append(" + ");
					}
				}
			}

			// n의 약수의 합이 n과 같은 경우 결과 값을 만듬
			if (sum == n) {
				sb.append(sb2.substring(0, sb2.length() - 3).toString()).append(NEW_LINE);
			}

			// n의 약수의 합이 n과 같지 않을 경우 결과 값을 만듬
			else {
				sb.append(n).append(IS_NOT_PERFECT);
			}
		}

		br.close();

		// 결과 값 출력
		System.out.println(sb.toString());
	}
}