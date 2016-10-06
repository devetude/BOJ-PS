package boj_10872;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 10872번 (팩토리얼) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/10872
 * @author devetude
 */
public class Main {
	public static void main(String[] args) throws Exception {
		// 버퍼를 통해 입력을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();

		// 팩토리얼을 계산
		int res = 1;

		for (int i = N; i >= 1; i--) {
			res *= i;
		}

		// 결과 값 출력
		System.out.println(res);
	}
}