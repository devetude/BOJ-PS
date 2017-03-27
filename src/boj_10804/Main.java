package boj_10804;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 10804번 (카드 역배치) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/10804
 * @author devetude
 */
public class Main {
	// 공백 문자 상수
	private static final char SPACE = ' ';

	public static void main(String args[]) throws Exception {
		// 숫자 배열 초기화
		int[] nums = new int[21];

		for (int i = 1; i <= 20; i++) {
			nums[i] = i;
		}

		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 바꾸기 시작 위치 설정 변수 초기화
			int pos = a;

			// 중간 값 저장 변수 설정
			int mid = (a + b) / 2;

			// 바꾸는 범위의 원소 갯수가 홀수 일 경우
			if ((a + b) % 2 == 0) {
				while (pos < mid) {
					swap(nums, pos, b - pos + a);

					pos++;
				}
			}

			// 바꾸는 범위의 원소 갯수가 짝수 일 경우
			else {
				while (pos <= mid) {
					swap(nums, pos, b - pos + a);

					pos++;
				}
			}
		}

		br.close();

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= 20; i++) {
			sb.append(nums[i]).append(SPACE);
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}

	/**
	 * 배열의 두 인덱스에 해당하는 값을 바꿔주는 메소드
	 * 
	 * @param nums
	 * @param aPos
	 * @param bPos
	 */
	private static void swap(int[] nums, int aPos, int bPos) {
		int tmp = nums[aPos];
		nums[aPos] = nums[bPos];
		nums[bPos] = tmp;
	}
}