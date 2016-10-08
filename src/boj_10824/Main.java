package boj_10824;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 10824번 (네 수) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/10824
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();

		// 버퍼를 통해 A와 B를 붙인 숫자와 C와 D를 붙인 숫자를 만듬
		// (10000001000000은 int의 범위를 넘어가므로 BigInteger 클래스 사용)
		StringBuilder sb = new StringBuilder();
		BigInteger AB = new BigInteger(sb.append(st.nextToken()).append(st.nextToken()).toString());
		sb.setLength(0);
		BigInteger CD = new BigInteger(sb.append(st.nextToken()).append(st.nextToken()).toString());

		// 결과 값 출력
		System.out.println(AB.add(CD));
	}
}
