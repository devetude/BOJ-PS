package boj_10826;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * 백준 온라인 저지 10826번 (피보나치수 4) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/10826
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();

		// 메모이제이션을 사용하여 N번째 피보나치 수를 구함
		// (단, 최대 10000번째 항까지 구해야 하므로 BigInteger를 사용)
		BigInteger[] fibos = new BigInteger[N + 3];
		fibos[0] = BigInteger.ZERO;
		fibos[1] = fibos[2] = BigInteger.ONE;

		for (int i = 3; i <= N; i++) {
			fibos[i] = fibos[i - 2].add(fibos[i - 1]);
		}

		// 결과 값 출력
		System.out.println(fibos[N]);
	}
}