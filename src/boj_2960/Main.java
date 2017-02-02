package boj_2960;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2960번 (에라토스테네스의 체) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2960
 * @author devetude
 */
public class Main {
	// 에라토네스의 채 배열
	private static boolean[] sieve;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		br.close();

		// 에라토네스의 채 초기화
		sieve = new boolean[N + 1];

		// 몇번째로 지워지는 숫자인지 저장하기 위한 인덱스 변수
		int idx = 0;

		for (int i = 2; i <= N; i++) {
			int last = N / i;

			for (int j = 1; j <= last; j++) {
				int num = i * j;

				// 아직 지워지지 않은 경우
				if (!sieve[num]) {
					sieve[num] = true;
					idx++;

					// K번째로 지워지는 숫자를 찾은 경우
					if (idx == K) {
						// 결과 값 출력
						System.out.println(num);
					}
				}
			}
		}
	}
}