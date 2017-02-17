package boj_10539;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 10539번 (수빈이와 수열) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/10539
 * @author devetude
 */
public class Main {
	// 공백 문자열 상수
	private static final String SPACE = " ";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// 수열 A 배열 초기화
		int[] A = new int[N];

		// 수열 B 값을 통해 수열 A를 일부 완성
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken()) * (i + 1);
		}

		br.close();

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		// 루프를 돌며 수열 A를 완성
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				A[j] -= A[i];
			}

			sb.append(A[i]).append(SPACE);
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}