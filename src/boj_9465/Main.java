package boj_9465;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 9465번 (스티커) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/9465
 * @author devetude
 */
public class Main {
	// 스티커 선택 상수 (위, 아래, 선택안함)
	private static final int TOP = 0;
	private static final int BOTTOM = 1;
	private static final int NONE = 2;

	// 캐시 배열 ([스티커 선택 상수][인덱스])
	private static int[][] cache = null;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());

			// 스티커와 캐시 배열을 초기화
			int[][] stickers = new int[3][n];
			cache = new int[3][n];

			// 캐시 배열을 모두 -1로 초기화
			for (int j = 0; j < 3; j++) {
				Arrays.fill(cache[j], -1);
			}

			for (int j = 0; j < 2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");

				for (int k = 0; k < n; k++) {
					stickers[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			// 결과 값을 버퍼에 저장 (0열 스티커부터 선택안함, 위, 아래 중 가장 큰 값을 결과 값으로 설정)
			sb.append(Math.max(Math.max(choice(n, stickers, 0, NONE), choice(n, stickers, 0, TOP)),
					choice(n, stickers, 0, BOTTOM))).append("\n");
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}

	/**
	 * 스티커를 선택하는 재귀 메소드
	 * 
	 * @param n
	 * @param stickers
	 * @param index
	 * @param beforeChoiceStatus
	 * @return
	 */
	private static int choice(int n, int[][] stickers, int index, int beforeChoiceStatus) {
		// 기저조건 : 인덱스가 배열의 맨 끝을 넘었는 경우 0을 리턴
		if (index == n) {
			return 0;
		}

		// 캐시 값이 있는 경우 캐시 값 사용
		if (cache[beforeChoiceStatus][index] != -1) {
			return cache[beforeChoiceStatus][index];
		}

		// 현재 열에서 선택하지 않는 경우는 모든 열에 공통으로 해당
		int maxSum = choice(n, stickers, index + 1, NONE);

		switch (beforeChoiceStatus) {
		// 경우 1 : 이전 열에서 아무것도 선택하지 않았으면 이번 열에서 선택안함, 위, 아래 3가지 경우가 있음
		case NONE:
			maxSum = Math.max(maxSum, choice(n, stickers, index + 1, TOP));
			maxSum = Math.max(maxSum, choice(n, stickers, index + 1, BOTTOM));
			break;

		// 경우 2 : 이전 열에서 위를 선택했다면 선택안함, 아래 2가지 경우가 있음
		case TOP:
			maxSum = Math.max(maxSum, choice(n, stickers, index + 1, BOTTOM));
			break;

		// 경우 3 : 이전 열에서 아래를 선택했다면 선택안함, 위 2가지 경우가 있음
		case BOTTOM:
			maxSum = Math.max(maxSum, choice(n, stickers, index + 1, TOP));
			break;
		}

		// 각각에 대해서 최대 값을 구한 후 현재 값을 더한 값을 캐시에 저장 및 리턴
		return cache[beforeChoiceStatus][index] = maxSum + stickers[beforeChoiceStatus][index];
	}
}