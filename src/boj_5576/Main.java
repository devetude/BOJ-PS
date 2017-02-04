package boj_5576;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 온라인 저지 5576번 (콘테스트) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/5576
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 각 대학의 점수 저장 배열
		int[] W = new int[10];
		int[] K = new int[10];

		for (int i = 0; i < 10; i++) {
			W[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < 10; i++) {
			K[i] = Integer.parseInt(br.readLine());
		}

		br.close();

		// 각 대학의 점수 정렬 (오름차순)
		Arrays.sort(W);
		Arrays.sort(K);

		// 버퍼를 이용해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();
		sb.append(W[9] + W[8] + W[7]).append(" ").append(K[9] + K[8] + K[7]);

		// 결과 값 출력
		System.out.println(sb.toString());
	}
}