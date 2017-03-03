package boj_3053;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 3053번 (택시 기하학) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/3053
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int R = Integer.parseInt(br.readLine());

		br.close();

		// R 제곱을 구함
		double rSquare = Math.pow(R, 2);

		// 결과 값 출력
		System.out.printf("%.6f\n%.6f", rSquare * Math.PI, 2 * rSquare);
	}
}