package boj_11004;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 11004번 (K번째 수) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/11004
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		// 이유 : Scanner를 통해 입력을 받으면 실행속도 느림
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");

		// 정렬 할 수들을 입력 받음
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		br.close();

		// 숫자들을 정렬
		Arrays.sort(arr);

		// 결과 값을 출력
		System.out.println(arr[K - 1]);
	}
}