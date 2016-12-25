package boj_10818;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 10818번 (최소, 최대) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/10818
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		// 최대 값과 최소 값을 찾음
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			max = Math.max(max, num);
			min = Math.min(min, num);
		}

		// 결과 값 출력
		System.out.println(min + " " + max);
	}
}