package boj_2741;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 2741번 (N 찍기) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/2741
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			sb.append(i).append("\n");
		}

		// 결과 값 출력
		System.out.println(sb.toString());
	}
}