package boj_11052;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 11052번 (붕어빵 판매하기) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/11052
 * @author devetude
 */
public class Main {
	// 캐시 배열 ([남은 붕어빵 갯수])
	private static int[] cache = null;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] costs = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			costs[i] = Integer.parseInt(st.nextToken());
		}

		br.close();

		// 캐시 배열 초기화
		cache = new int[N + 1];

		// 결과 값을 출력
		System.out.println(calc(N, costs));
	}

	/**
	 * 최대 이익을 계산하는 재귀 메소드
	 * 
	 * @param N
	 * @param costs
	 * @param sets
	 * @return
	 */
	private static int calc(int N, int[] costs) {
		// 기저조건 : 붕어빵이 모두 팔렸을 때 0을 리턴
		if (N == 0) {
			return 0;
		}

		// 캐시 배열에 값이 있는 경우 캐시 값을 사용
		if (cache[N] != 0) {
			return cache[N];
		}

		// 최대 값을 초기화
		int max = Integer.MIN_VALUE;

		// 루프를 돌면서 현재 상태에서 몇 개의 붕어빵을 파는 것이 최대 이익을 남길 수 있는지 계산
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, calc(N - i, costs) + costs[i]);
		}

		// 최대 이익을 캐시에 저장하고 리턴
		return cache[N] = max;
	}
}