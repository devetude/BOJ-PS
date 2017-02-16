package boj_5624;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 5624번 (좋은 수) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/5624
 * @author devetude
 */
public class Main {
	// 크기 상수
	private static final int ZERO_BIAS = 200_000;
	private static final int MAX_SIZE = ZERO_BIAS * 2 + 1;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// 수열 저장 배열 초기화
		int[] nums = new int[N];

		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		br.close();

		// 두 수의 합 저장 배열 초기화
		boolean[] sumOfTowNums = new boolean[MAX_SIZE];

		// 좋은 수 갯수 저장 변수
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			// 두 수의 차가 두 수의 합이 될 수 있는 경우를 구함
			for (int j = 0; j < i; j++) {
				if (sumOfTowNums[ZERO_BIAS + nums[i] - nums[j]]) {
					cnt++;

					// i번째 수는 좋은 수 임으로 다음으로 넘어감
					break;
				}
			}

			// 두 수의 합이 될 수 있는 경우를 구함
			for (int j = 0; j <= i; j++) {
				sumOfTowNums[ZERO_BIAS + nums[i] + nums[j]] = true;
			}
		}

		// 결과 값 출력
		System.out.println(cnt);
	}
}