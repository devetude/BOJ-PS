package boj_1806;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1806번 (부분합) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1806
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");

		br.close();

		// 숫자 저장 배열 초기화
		int[] nums = new int[N];

		// 투 포인터 알고리즘을 이용하여 가장 짧은 길이를 구함
		int front = 0;
		int sum = 0;
		int minLen = N;

		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			sum += nums[i];

			while (sum - nums[front] >= M) {
				sum -= nums[front];
				front++;
				minLen = Math.min(minLen, i - front + 1);
			}
		}

		// 결과 값 출력
		if (sum >= M) {
			System.out.println(minLen);
		}

		// 예외 sum이 M을 넘지 못하는 경우 0을 출력
		else {
			System.out.println(0);
		}
	}
}