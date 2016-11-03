package boj_1977;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 1977번 (완전제곱수) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1977
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		br.close();

		// 합과 최솟값 변수
		int sum = 0;
		int min = Integer.MAX_VALUE;

		// M과 N 사이의 숫자들을 차례로 완전제곱수인지 판별하고, 최솟값을 설정
		for (int i = M; i <= N; i++) {
			if (Math.sqrt(i) % 1.0f == 0.0f) {
				sum += i;
				min = Math.min(min, i);
			}
		}

		// 최솟값이 존재하지 않는 경우 문제의 조건에 따라 -1을 출력
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}

		else {
			// 버퍼를 이용해 결과 값을 만듬
			StringBuilder sb = new StringBuilder();
			sb.append(sum).append("\n").append(min);

			// 결과 값 출력
			System.out.println(sb.toString());
		}
	}
}