package boj_1850;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1850번 (최대공약수) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1850
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		br.close();

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		// 유클리드 호제법을 이용하여 최대공약수를 구함
		while (B > 0) {
			long tmp = B;
			B = A % B;
			A = tmp;
		}

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < A; i++) {
			sb.append(1);
		}

		// 결과 값 출력
		System.out.println(sb.toString());
	}
}