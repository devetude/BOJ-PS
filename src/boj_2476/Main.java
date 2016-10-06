package boj_2476;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2476번 (주사위 게임) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/2476
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] scores = new int[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] nums = new int[3];

			for (int j = 0; j < 3; j++) {
				nums[j] = Integer.parseInt(st.nextToken());
			}

			// 세 수가 모두 동일한 경우
			if (nums[0] == nums[1] && nums[0] == nums[2]) {
				scores[i] = 10000 + nums[0] * 1000;
			}

			// 두 수(0,1 혹은 0, 2)만 동일한 경우
			else if (nums[0] == nums[1] || nums[1] == nums[2]) {
				scores[i] = 1000 + nums[0] * 100;
			}

			// 두 수(1,2)만 동일한 경우
			else if (nums[1] == nums[2]) {
				scores[i] = 1000 + nums[1] * 100;
			}

			// 세 수가 모두 다른 경우
			else {
				// 받은 숫자를 오름차순으로 정렬
				Arrays.sort(nums);
				scores[i] = nums[nums.length - 1] * 100;
			}
		}

		br.close();

		// 점수를 오름차순으로 정렬
		Arrays.sort(scores);

		// 최대 점수를 결과 값으로 출력
		System.out.println(scores[scores.length - 1]);
	}
}