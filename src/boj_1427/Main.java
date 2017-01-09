package boj_1427;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 온라인 저지 1427번 (소트인사이드) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1427
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();

		// 입력 받은 숫자를 1자리씩 저장 할 배열 초기화
		int[] nums = new int[String.valueOf(N).length()];

		int i = 0;

		// 루프를 돌며 1자리씩 저장
		while (N != 0) {
			nums[i] = N % 10;
			N /= 10;
			i++;
		}

		// 오름차순으로 정렬
		Arrays.sort(nums);

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		i = nums.length - 1;

		while (i >= 0) {
			sb.append(nums[i]);
			i--;
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}