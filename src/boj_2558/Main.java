package boj_2558;

import java.util.Scanner;

/**
 * 백준 온라인 저지 2558번 (A + B - 2) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/2558
 * @author devetude
 */
public class Main {
	public static void main(String[] args) throws Exception {
		// 입력을 받음
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		sc.close();

		// 결과 값 출력
		System.out.println(A + B);
	}
}