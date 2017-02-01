package boj_10707;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 10707번 (수도요금) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/10707
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int D = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());

		br.close();

		// 수도요금을 계산
		int x = A * P;
		int y = B;

		if (P > C) {
			y += (P - C) * D;
		}

		// 결과 값 출력
		System.out.println(Math.min(x, y));
	}
}