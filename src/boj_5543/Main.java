package boj_5543;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 5543번 (상근날드) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/5543
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 최저 버거 가격 저장 변수
		// (문제의 조건에서 2000원을 넘지 않는다고 하였으므로 2000으로 초기화)
		int minBurgerPrice = 2000;

		// 버거 가격을 비교하여 가장 싼 버거 가격을 저장
		for (int i = 0; i < 3; i++) {
			minBurgerPrice = Math.min(minBurgerPrice, Integer.parseInt(br.readLine()));
		}

		// 최저 음료수 가격 저장 변수
		// (문제의 조건에서 2000원을 넘지 않는다고 하였으므로 2000으로 초기화)
		int minBeveragePrice = 2000;

		// 음료수 가격을 비교하여 가장 싼 음료수 가격을 저장
		for (int i = 0; i < 2; i++) {
			minBeveragePrice = Math.min(minBeveragePrice, Integer.parseInt(br.readLine()));
		}

		br.close();

		// 결과 값 출력
		// (가장 싼 버거 가격 + 가장 싼 음료 가격 - 50)
		System.out.println(minBurgerPrice + minBeveragePrice - 50);
	}
}