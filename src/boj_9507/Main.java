package boj_9507;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * 백준 온라인 저지 9507번 (Generations of Tribbles) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/9507
 * @author devetude
 */
public class Main {
	// 캐시 변수
	private static BigInteger[] cache = new BigInteger[68];

	public static void main(String args[]) throws Exception {
		// 캐시 변수 초기화
		cache[0] = BigInteger.valueOf(1);
		cache[1] = BigInteger.valueOf(1);
		cache[2] = BigInteger.valueOf(2);
		cache[3] = BigInteger.valueOf(4);

		// 버퍼를 통해 입력을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		// 꿍 피보나치 결과를 버퍼를 통해 만듬
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < t; i++) {
			sb.append(koong(Integer.parseInt(br.readLine())).toString()).append("\n");
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}

	/**
	 * 꿍 피보나치 재귀 메소드
	 * 
	 * @param n
	 * @return
	 */
	private static BigInteger koong(int n) {
		// 캐시 값이 있을 경우 캐시 값을 리턴
		if (cache[n] != null) {
			return cache[n];
		}

		// 캐시 값이 없을 경우 재귀 호출
		return cache[n] = koong(n - 1).add(koong(n - 2)).add(koong(n - 3)).add(koong(n - 4));
	}
}