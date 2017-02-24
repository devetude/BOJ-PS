package boj_1789;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 1789번 (수들의 합) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1789
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 문제의 조건에서 약 43억 이하가 입력 됨으로 long형 사용
		long N = Long.parseLong(br.readLine());

		br.close();

		int i = 1;

		// 합계 저장 변수는 최대 43억 이하가 저장 됨으로 long형 사용
		long sum = 0;

		// 규칙성을 통해 i 값을 찾음
		// 합계 : 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, ...
		// 갯수 : 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, ...
		for (; sum + i <= N; i++) {
			sum += i;
		}

		// 결과 값 출력
		System.out.println(i - 1);
	}
}