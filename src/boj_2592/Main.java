package boj_2592;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 2592번 (대표값) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2592
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 숫자 배열
		int[] nums = new int[10];

		// 숫자별 빈도 배열
		int[] numFrequency = new int[1001];

		// 합계 변수
		int sum = 0;

		// 최대 빈도
		int maxFrequencyNum = 0;

		for (int i = 0; i < 10; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			sum += nums[i];
			numFrequency[nums[i]]++;

			if (numFrequency[maxFrequencyNum] < numFrequency[nums[i]]) {
				maxFrequencyNum = nums[i];
			}
		}

		br.close();

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();
		sb.append(sum / 10).append("\n");
		sb.append(maxFrequencyNum);

		// 결과 값 출력
		System.out.println(sb.toString());
	}
}