package boj_2902;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 2902번 (KMP는 왜 KMP일까?) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2902
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split("-");

		br.close();

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (String str : strs) {
			sb.append(str.charAt(0));
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}