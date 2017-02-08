package boj_9009;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 백준 온라인 저지 9009번 (피보나치) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/9009
 * @author devetude
 */
public class Main {
	// 문자열 상수
	private static final String NEW_LINE = "\n";
	private static final String SPACE = " ";

	// 피보나치 최대 인덱스 상수
	// (문제의 조건에서 n이 1,000,000,000 보다 작거나 같다고 했음으로 fibo[44] = 701,408,733까지만 구함)
	private static final int FIBO_SIZE = 45;

	// 피보나치 배열
	private static int[] fibo = null;

	public static void main(String args[]) throws Exception {
		// 피보나치 배열 초기화
		fibo = new int[FIBO_SIZE];
		fibo[0] = 0;
		fibo[1] = 1;

		for (int i = 2; i < FIBO_SIZE; i++) {
			fibo[i] = fibo[i - 1] + fibo[i - 2];
		}

		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		while (T-- != 0) {
			int n = Integer.parseInt(br.readLine());

			// 검색 시작 인덱스 초기화
			// (이미 구해놓은 피보나치 수 중 가장 큰 피보나치 수 부터 검색)
			int searchStartIdx = FIBO_SIZE - 1;

			// 결과 피보나치 수들을 담을 배열리스트 초기화
			ArrayList<Integer> nums = new ArrayList<>();

			while (n != 0) {
				for (int i = searchStartIdx; 0 <= i; i--) {
					// n과 보다 작거나 같으면서 가장 큰 피보나치를 찾으면
					if (fibo[i] <= n) {
						// n에서 해당 피보나치 수를 뺌
						n -= fibo[i];

						// 결과 배열리스트에 해당 피보나치 수를 담음
						nums.add(fibo[i]);

						// 검색 시작 인덱스 변경
						searchStartIdx = i - 1;

						break;
					}
				}
			}

			// 문제의 조건에 따라, 결과 피보나치 수들을 오름차순 순서로 된 결과로 만듬
			int lastIdx = nums.size() - 1;

			for (int i = lastIdx; 0 <= i; i--) {
				sb.append(nums.get(i)).append(SPACE);
			}

			sb.append(NEW_LINE);
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}