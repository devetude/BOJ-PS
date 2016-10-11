package boj_11053;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 11053번 (가장 긴 증가하는 부분 수열) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/11053
 * @author devetude
 */
public class Main {
	// 캐시 배열
	private static int[] cache = null;

	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] nums = new int[N];

		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		br.close();

		// 캐시 배열 초기화
		cache = new int[N];

		// 초기 가장 긴 수열의 길이는 1
		int maxLen = 1;

		// 루프를 돌면서 가장 긴 증가 수열의 길이를 검색
		for (int i = 0; i < N; i++) {
			maxLen = Math.max(maxLen, search(N, nums, i));
		}

		// 결과 값 출력
		System.out.println(maxLen);
	}

	/**
	 * 가장 긴 증가 수열의 길이를 구하는 재귀 메소드
	 * 
	 * @param N
	 * @param nums
	 * @param index
	 * @return
	 */
	private static int search(int N, int[] nums, int index) {
		// 기저조건 : 인덱스가 배열의 끝에 도달했을 경우 1을 리턴
		if (index == N - 1) {
			return 1;
		}

		// 캐시 값이 있는 경우 캐시 값을 사용
		if (cache[index] != 0) {
			return cache[index];
		}

		// 초기 가장 긴 수열의 길이는 1
		int maxLen = 1;

		// 루프를 돌면서 가장 긴 증가 수열의 길이를 검색
		for (int i = index + 1; i < N; i++) {
			if (nums[index] < nums[i]) {
				maxLen = Math.max(maxLen, search(N, nums, i) + 1);
			}
		}

		return maxLen;
	}
}
