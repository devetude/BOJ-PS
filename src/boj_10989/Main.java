package boj_10989;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 백준 온라인 저지 10989번 (수 정렬하기 3) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/10989
 * @author devetude
 */
public class Main {
	// 개행 문자열 상수
	private static final String NEW_LINE = "\n";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];

		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}

		br.close();

		// 오름차순으로 숫자 정렬
		Arrays.sort(nums);

		// 버퍼를 통해 결과 값 출력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int num : nums) {
			bw.write(num + NEW_LINE);
		}

		bw.close();
	}
}