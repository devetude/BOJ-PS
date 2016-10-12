package boj_1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1000번 (A+B) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1000
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();

		// 결과 값 출력
		System.out.println(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
	}
}