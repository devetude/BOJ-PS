package boj_11004;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 11004번 (K번째 수) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/11004
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");

		br.close();

		// N개의 수 저장 배열 초기화
		int[] A = new int[N];

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		// K번째로 큰 수 출력
		System.out.println(quickSelect(A, 0, N - 1, K - 1));
	}

	/**
	 * 퀵 셀렉트 메소드
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	private static int quickSelect(final int[] NUMS, int start, int end, int k) {
		if (start <= end) {
			int pivot = partition(NUMS, start, end);

			if (pivot == k) {
				return NUMS[k];
			}

			else if (pivot > k) {
				return quickSelect(NUMS, start, pivot - 1, k);
			}

			else {
				return quickSelect(NUMS, pivot + 1, end, k);
			}
		}

		return Integer.MIN_VALUE;
	}

	/**
	 * 분할 메소드
	 * 
	 * @param NUMS
	 * @param start
	 * @param end
	 * @return
	 */
	private static int partition(final int[] NUMS, int start, int end) {
		int pivot = start + new Random().nextInt(end - start + 1);

		swap(NUMS, end, pivot);

		for (int i = start; i < end; i++) {
			if (NUMS[i] < NUMS[end]) {
				swap(NUMS, i, start);
				start++;
			}
		}

		swap(NUMS, start, end);

		return start;
	}

	/**
	 * 배열의 두 요소의 값을 바꾸는 메소드
	 * 
	 * @param nums
	 * @param aIdx
	 * @param bIdx
	 */
	private static void swap(final int[] nums, final int aIdx, final int bIdx) {
		int tmp = nums[aIdx];
		nums[aIdx] = nums[bIdx];
		nums[bIdx] = tmp;
	}
}