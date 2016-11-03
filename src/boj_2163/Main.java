package boj_2163;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2163번 (초콜릿 자르기) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2163
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();

		// 결과 값 출력
		System.out.println(Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()) - 1);
	}
}