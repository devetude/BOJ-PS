package boj_1904;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 1904번 (01타일) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1904
 * @author devetude
 */
public class Main {
	// 나머지 연산 상수
	private static final int MOD = 15746;

	// 캐시 배열 ([자릿수] = 갯수)
	private static int[] cache = null;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();

		// 캐시 배열 초기화
		cache = new int[N + 1];
		cache[0] = 1;
		cache[1] = 1;

		// 점화식 f(n) = f(n - 1) + f(n - 2), 결국 피보나치 수열과 같음
		// (문제의 조건에서 15746으로 나머지 연산을 하도록 지시)
		// (이 문제는 재귀 함수로 접근 시, stack over flow가 나옴 -> 1000000번째 항을 구해야 하기 때문)
		for (int i = 2; i <= N; i++) {
			cache[i] = (cache[i - 1] % MOD + cache[i - 2] % MOD) % MOD;
		}

		// 결과 값 출력
		System.out.println(cache[N]);
	}
}