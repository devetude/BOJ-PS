package boj_11047;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 11047번 (동전 0) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/11047
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 단위 저장 배열 초기화
		int[] coins = new int[N];

		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		br.close();

		// 그리디 알고리즘을 이용하여 최소 사용 갯수를 구함
		int cnt = 0;

		for (int i = N - 1; K > 0; i--) {
			int quotient = K / coins[i];
			K -= coins[i] * quotient;
			cnt += quotient;
		}

		// 결과 값 출력
		System.out.println(cnt);
	}
}