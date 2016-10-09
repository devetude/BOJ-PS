package boj_10951;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 10951번 (A+B - 4) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/10951
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 버퍼를 이용해 결과 값을 저장
		StringBuilder sb = new StringBuilder();

		String line = null;

		while ((line = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line, " ");
			sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())).append("\n");
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}