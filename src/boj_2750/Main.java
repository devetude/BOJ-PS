package boj_2750;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 온라인 저지 2750번 (수 정렬하기) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/2750
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];

		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}

		br.close();

		// 오름차순으로 배열 정렬
		Arrays.sort(nums);

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (int num : nums) {
			sb.append(num).append("\n");
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}