package boj_11022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 11022번 (A+B - 8) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/11022
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// 버퍼를 이용해 결과 값을 저장
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			sb.append("Case #").append(i).append(": ").append(A).append(" + ").append(B).append(" = ").append(A + B)
					.append("\n");
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}