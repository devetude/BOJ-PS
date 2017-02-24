package boj_1026;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1026번 (보물) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1026
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer stA = new StringTokenizer(br.readLine(), " ");
		StringTokenizer stB = new StringTokenizer(br.readLine(), " ");

		br.close();

		// A, B 수열 저장 배열 초기화
		Integer[] A = new Integer[N];
		int[] B = new int[N];

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(stA.nextToken());
			B[i] = Integer.parseInt(stB.nextToken());
		}

		// A 수열을 내림차순으로 정렬
		Arrays.sort(A, Collections.reverseOrder());

		// B 수열을 오름차순으로 정렬
		Arrays.sort(B);

		// 결과 값 저장 변수 초기화
		int res = 0;

		// 결과 값을 구함
		for (int i = 0; i < N; i++) {
			res += A[i] * B[i];
		}

		// 결과 값 출력
		System.out.println(res);
	}
}