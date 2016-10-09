package boj_1920;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1920번 (수 찾기) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/1920
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] A = new int[N];

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		br.close();

		// 입력된 배열을 오름차순으로 정렬 (이진 탐색을 하기 위해서)
		Arrays.sort(A);

		// 버퍼를 이용해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			// 이진 탐색 결과가 0 이상 일 경우 존재함으로 1
			if (Arrays.binarySearch(A, Integer.parseInt(st.nextToken())) >= 0) {
				sb.append(1);
			}

			// 아닐경우 0
			else {
				sb.append(0);
			}

			sb.append("\n");
		}

		// 결과 값을 한꺼번에 출력
		System.out.println(sb.toString());
	}
}