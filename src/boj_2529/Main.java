package boj_2529;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2529번 (부등호) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/2529
 * @author devetude
 */
public class Main {
	private static ArrayList<String> permutation = new ArrayList<>();
	private static int[] nums = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	private static String[] inequalities = new String[9];

	public static void main(String[] args) throws Exception {
		// 입력 값을 버퍼를 이용해 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();

		for (int i = 0; i < k; i++) {
			inequalities[i] = st.nextToken();
		}

		// 조건에 맞는 순열을 만듬
		perm(nums, 0, k + 1);

		// 만들어진 순열을 오름차순으로 정렬
		Collections.sort(permutation);

		// 버퍼를 이용해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();
		sb.append(permutation.get(permutation.size() - 1)).append("\n");
		sb.append(permutation.get(0));

		// 결과 값을 한꺼번에 출력
		System.out.println(sb.toString());
	}

	/**
	 * 조건에 맞는 순열을 만드는 메소드
	 * 
	 * @param nums
	 * @param depth
	 * @param k
	 */
	public static void perm(int[] nums, int depth, int k) {
		if (depth >= 2) {
			if (inequalities[depth - 2].equals("<") && nums[depth - 2] > nums[depth - 1]) {
				return;
			}

			else if (inequalities[depth - 2].equals(">") && nums[depth - 2] < nums[depth - 1]) {
				return;
			}
		}

		if (depth == k) {
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < k; i++) {
				sb.append(nums[i]);
			}

			permutation.add(sb.toString());

			return;
		}

		for (int i = depth; i < nums.length; i++) {
			swap(nums, i, depth);
			perm(nums, depth + 1, k);
			swap(nums, i, depth);
		}

	}

	/**
	 * 배열의 해당 인덱스 i, j 값을 변경하는 메소드
	 * 
	 * @param arr
	 * @param i
	 * @param j
	 */
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}