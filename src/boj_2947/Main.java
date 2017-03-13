package boj_2947;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2947번 (나무 조각) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2947
 * @author devetude
 */
public class Main {
	// 문자 상수
	private static final char SPACE = ' ';
	private static final char NEW_LINE = '\n';

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		br.close();

		// 숫자 저장 배열 초기화
		int[] nums = new int[5];

		for (int i = 0; i < 5; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		while (true) {
			// 버블 정렬이 끝났는지 확인하는 변수
			boolean isCompleted = true;

			// 버블 정렬 실행
			for (int i = 0; i < 4; i++) {
				if (nums[i] > nums[i + 1]) {
					int tmp = nums[i + 1];
					nums[i + 1] = nums[i];
					nums[i] = tmp;

					for (int num : nums) {
						sb.append(num).append(SPACE);
					}

					sb.append(NEW_LINE);

					isCompleted = false;
				}
			}

			if (isCompleted) {
				break;
			}
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}