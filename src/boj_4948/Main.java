package boj_4948;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 4948번 (베르트랑 공준) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/4948
 * @author devetude
 */
public class Main {
	// 개행 문자열 상수
	private static final String NEW_LINE = "\n";

	// 에라토네스의 체 배열
	private static int[] sieve = new int[246_913];

	public static void main(String args[]) throws Exception {
		// 0과 1은 소수가 아니므로 1로 표시
		sieve[0] = 1;
		sieve[1] = 1;

		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		// 0이 입력되면 종료
		while ((n = Integer.parseInt(br.readLine())) != 0) {
			int start = n + 1;
			int end = 2 * n;
			
			int sqrtI = (int) Math.sqrt(end);

			for (int i = 2; i <= sqrtI; i++) {
				// 이미 소수가 아닌 경우 무시
				if (sieve[i] == 1) {
					continue;
				}

				// 소수가 아닌 경우 모두 걸러냄
				for (int j = i + i; j <= end; j += i) {
					sieve[j] = 1;
				}
			}

			// 소수의 갯수 저장 변수
			int primeCnt = 0;

			for (int i = start; i <= end; i++) {
				if (sieve[i] != 1) {
					primeCnt++;
				}
			}

			sb.append(primeCnt).append(NEW_LINE);
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}