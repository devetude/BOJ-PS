package boj_1110;

import java.util.Scanner;

/**
 * 백준 온라인 저지 1110번 (더하기 사이클) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/1110
 * @author devetude
 */
public class Main {
	public static void main(String[] args) throws Exception {
		// 입력을 받음
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();

		int a = N / 10;
		int aTmp = a;
		int b = N % 10;
		int bTmp = b;
		int res = -1;
		int counts = 0;

		// 사이클이 나올 때 까지 루프를 돔
		while (true) {
			res = aTmp + bTmp;
			aTmp = bTmp;
			bTmp = res % 10;
			counts++;

			// 원래 숫자 형태가 나오면 탈출
			if (aTmp == a && bTmp == b) {
				break;
			}
		}

		// 결과 값 출력
		System.out.println(counts);
	}
}