package boj_2526;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 백준 온라인 저지 2526번 (싸이클) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/2526
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 입력 값을 받음
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> cycle = new ArrayList<>();
		int N = sc.nextInt();
		int P = sc.nextInt();
		sc.close();
		int item = N;
		int cycleStartIndex = 0;

		// 싸이클이 나올 때 까지 반복
		while (true) {
			item = item * N % P;

			if (cycle.contains(item)) {
				cycleStartIndex = cycle.indexOf(item);
				break;
			}

			else {
				cycle.add(item);
			}
		}

		// 싸이클의 크기를 결과 값으로 출력
		System.out.println(cycle.size() - cycleStartIndex);
	}
}