package boj_3047;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 3047번 (ABC) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/3047
 * @author devetude
 */
public class Main {
	// 공백 문자 상수
	private static final char SPACE = ' ';

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String str = br.readLine();

		br.close();

		int[] seq = new int[3];

		for (int i = 0; i < 3; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

		// 오름차순으로 정렬
		Arrays.sort(seq);

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 3; i++) {
			sb.append(seq[(int) str.charAt(i) - 65]).append(SPACE);
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}