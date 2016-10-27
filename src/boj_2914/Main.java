package boj_2914;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2914번 (저작권) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2914
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int I = Integer.parseInt(st.nextToken());
		br.close();

		// 결과 값 출력
		System.out.println(A * (I - 1) + 1);
	}
}