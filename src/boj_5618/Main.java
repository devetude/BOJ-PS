package boj_5618;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 5618번 (공약수) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/5618
 * @author devetude
 */
public class Main {
	// 개행 문자열 상수
	private static final String NEW_LINE = "\n";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] nums = new int[n];
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			min = Math.min(min, nums[i]);
		}

		br.close();

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();
		sb.append(1).append(NEW_LINE);

		MAIN_LOOP: for (int i = 2; i <= min; i++) {
			for (int num : nums) {
				if (num % i != 0) {
					continue MAIN_LOOP;
				}
			}

			// 버퍼에 추가
			sb.append(i).append(NEW_LINE);
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}