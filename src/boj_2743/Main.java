package boj_2743;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 2743번 (단어 길이 재기) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2743
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 결과 값 출력
		System.out.println(br.readLine().length());

		br.close();
	}
}