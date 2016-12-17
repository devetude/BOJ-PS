package boj_2920;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2920번 (음계) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2920
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] nums = new int[8];

		for (int i = 0; i < 8; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		// 초기 0번과 1번의 차이 값을 구함
		int diff = nums[0] - nums[1];

		for (int i = 1; i < 7; i++) {
			// 차이 값이 일정하지 않는 경우 섞인 것으로 판단
			if (nums[i] - nums[i + 1] != diff) {
				br.close();
				System.out.println("mixed");

				return;
			}

			// 차이 값 갱신
			diff = nums[i] - nums[i + 1];
		}

		br.close();

		// 차이 값이 0보다 작은 경우 증가로 판단
		if (diff < 0) {
			System.out.println("ascending");
		}

		// 차이 값이 0 보다 큰 경우 감소로 판단
		else {
			System.out.println("descending");
		}
	}
}