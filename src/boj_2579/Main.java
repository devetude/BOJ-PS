package boj_2579;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 2579번 (계단 오르기) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/2579
 * @author devetude
 */
public class Main {
	private static int[][] cache = new int[301][3];

	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stair = new int[N + 2];

		for (int i = 1; i < N + 1; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}

		br.close();

		// 마지막 계단 이후 점수는 최저 점수로 설정
		stair[N + 1] = -999999999;

		// 기본 캐시 값 설정
		cache[1][0] = stair[1];

		// 결과 값 출력
		System.out.println(up(N, stair, 0, 0));
	}

	/**
	 * 계단 오르기 메소드
	 * 
	 * @param N
	 * @param stair
	 * @param currentStairIndex
	 * @param consecutiveCounts
	 * @return
	 */
	private static int up(int N, int[] stair, int currentStairIndex, int consecutiveCounts) {
		// 기저조건1 : 1계단씩 연속 3번 오를 경우 최저 점수로 설정
		if (consecutiveCounts == 3) {
			return -999999999;
		}

		// 기저조건2 : 마지막 계단에 딱 맞게 올랐거나, 마지막 계단 이후 계단에 올랐을 경우
		// (마지막 계단 이후 계단의 경우 최저 점수로 설정)
		if (currentStairIndex >= N) {
			return stair[currentStairIndex];
		}

		// 캐시에 있는 값 일 경우 반복을 피하기 위해 캐시 값을 사용
		if (cache[currentStairIndex][consecutiveCounts] != 0) {
			return cache[currentStairIndex][consecutiveCounts];
		}

		// 1칸 오르는 경우와 2칸 오르는 경우 중 더 높은 점수를 받는 경우로 선택
		return cache[currentStairIndex][consecutiveCounts] = Math
				.max(up(N, stair, currentStairIndex + 1, consecutiveCounts + 1), up(N, stair, currentStairIndex + 2, 1))
				+ stair[currentStairIndex];
	}
}