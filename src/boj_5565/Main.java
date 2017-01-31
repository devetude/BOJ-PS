package boj_5565;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 5565번 (영수증) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/5565
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = Integer.parseInt(br.readLine());

		// 10권의 합에서 나머지 9권의 가격을 뺌
		for (int i = 0; i < 9; i++) {
			sum -= Integer.parseInt(br.readLine());
		}

		br.close();

		// 결과 값 출력
		System.out.println(sum);
	}
}