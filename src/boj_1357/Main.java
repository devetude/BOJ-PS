package boj_1357;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1357번 (뒤집힌 덧셈) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1357
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();

		// 결과 값 출력
		StringBuilder sb = new StringBuilder(st.nextToken());
		int X = Integer.parseInt(sb.reverse().toString());
		sb = new StringBuilder(st.nextToken());
		int Y = Integer.parseInt(sb.reverse().toString());
		sb = new StringBuilder(String.valueOf(X + Y));
		System.out.println(Integer.parseInt(sb.reverse().toString()));
	}
}