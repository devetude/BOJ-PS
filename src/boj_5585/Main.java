package boj_5585;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 5585번 (거스름돈) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/5585
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int change = 1000 - Integer.parseInt(br.readLine());

		br.close();

		// 잔돈 배열
		int[] coins = { 500, 100, 50, 10, 5, 1 };

		// 잔돈별 사용 갯수 저장 배열
		int[] usedCoinCnts = new int[6];

		// 루프를 돌며 잔돈별 사용 갯수를 셈
		for (int i = 0; i < 6; i++) {
			while (change >= coins[i]) {
				change -= coins[i];
				usedCoinCnts[i]++;
			}
		}

		// 총 잔돈 갯수 저장 변수
		int totalCnt = 0;

		// 루프를 돌며 총 잔돈 사용 갯수를 셈
		for (int usedCoinCnt : usedCoinCnts) {
			totalCnt += usedCoinCnt;
		}

		// 결과 값 출력
		System.out.println(totalCnt);
	}
}