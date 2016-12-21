package boj_11722;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 11722번 (가장 긴 감소하는 부분 수열) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/11722
 * @author devetude
 */
public class Main {
	// 캐시 배열 (cache[N] = N으로 시작하는 가장 긴 감소하는 부분 수열의 길이)
	private static int[] cache = null;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();

		int[] seq = new int[N];

		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

		// 캐시 배열 초기화
		cache = new int[N];

		// 초기 가장 긴 수열의 길이는 1
		int maxLen = 1;

		// 루프를 돌면서 가장 긴 감소하는 부분 수열의 길이를 구함
		for (int i = 0; i < N; i++) {
			maxLen = Math.max(maxLen, lds(i, seq));
		}

		// 결과 값 출력
		System.out.println(maxLen);
	}

	/**
	 * 가장 긴 감소하는 부분 수열의 길이를 구하는 재귀 메소드
	 * 
	 * @param idx
	 * @param seq
	 * @return
	 */
	private static int lds(int idx, int[] seq) {
		// 기저조건 : 인덱스가 배열의 끝에 도달한 경우 0을 리턴
		if (idx == seq.length) {
			return 1;
		}

		// 캐시 배열에 값이 있는 경우 캐시 값을 사용
		if (cache[idx] != 0) {
			return cache[idx];
		}

		// 초기 가장 긴 감소하는 부분 수열의 길이는 1
		int maxLen = 1;

		// 루프를 돌면서 가장 긴 감소하는 부분 수열의 길이를 검색
		for (int i = idx + 1; i < seq.length; i++) {
			if (seq[idx] > seq[i]) {
				maxLen = Math.max(maxLen, lds(i, seq) + 1);
			}
		}

		// 결과 값을 캐시 배열에 저장 후 리턴
		return cache[idx] = maxLen;
	}
}