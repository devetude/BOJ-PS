package boj_2587;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 온라인 저지 2587번 (대표값2) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/2587
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nums = new int[5];
		int sum = 0;

		for (int i = 0; i < 5; i++) {
			int num = Integer.parseInt(br.readLine());
			sum += num;
			nums[i] = num;
		}

		br.close();

		// 오름차순으로 정렬
		Arrays.sort(nums);

		// 평균 값과 중앙 값을 출력
		System.out.println(sum / 5);
		System.out.println(nums[2]);
	}
}