package boj_2156;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 2156번 (포도주 시식) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2156
 * @author devetude
 */
public class Main {
	private static int[][] cache = null;

	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] cups = new int[n];

		for (int i = 0; i < n; i++) {
			cups[i] = Integer.parseInt(br.readLine());
		}

		br.close();

		// 캐시 배열 초기화
		cache = new int[n][3];

		// 초기 최대 양을 0번째 컵으로 초기화
		int maxQuantity = drink(n, cups, 0, 1);

		// 루프를 돌며 최대 양을 찾음
		for (int i = 1; i < n; i++) {
			maxQuantity = Math.max(maxQuantity, drink(n, cups, i, 1));
		}

		// 결과 값 출력
		System.out.println(maxQuantity);
	}

	/**
	 * 가장 많은 양의 포도주를 마시는 재귀 메소드
	 * 
	 * @param n
	 * @param cups
	 * @param index
	 * @param consecutiveCounts
	 * @return
	 */
	private static int drink(int n, int[] cups, int index, int consecutiveCounts) {
		// 기저조건1 : 연속으로 3잔째인 경우 더 이상 마실 수 없으므로 0을 리턴
		if (consecutiveCounts == 3) {
			return 0;
		}

		// 기저조건2 : 다음 컵이 없는데 마시려 했을 경우 0을 리턴
		if (index > n - 1) {
			return 0;
		}

		// 기저조건2 : 마지막 잔일 경우 해당 포도주의 양을 리턴
		if (index == n - 1) {
			return cups[index];
		}

		// 캐시 값이 있을 경우 캐시 값을 사용
		if (cache[index][consecutiveCounts] != 0) {
			return cache[index][consecutiveCounts];
		}

		// 초기 최대 양을 다음 컵을 마시는 경우로 초기화
		int maxQuantity = drink(n, cups, index + 1, consecutiveCounts + 1) + cups[index];

		// 루프를 돌며 최대 양을 찾음
		for (int i = index + 2; i < n; i++) {
			maxQuantity = Math.max(maxQuantity, drink(n, cups, i, 1) + cups[index]);
		}

		// 결과 값을 캐시에 저장하고 리턴
		return cache[index][consecutiveCounts] = maxQuantity;
	}
}