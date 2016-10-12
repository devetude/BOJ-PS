package boj_1965;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1965번 (상자넣기) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1965
 * @author devetude
 */
public class Main {
	// 캐시 배열 ([상자의 인덱스] = 최대 상자의 갯수)
	private static int[] cache = null;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] boxes = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			boxes[i] = Integer.parseInt(st.nextToken());
		}

		br.close();

		// 캐시 배열 초기화
		cache = new int[n];

		// 최대 상자의 갯수를 0번 상자를 골랐을 경우로 초기화
		int maxCounts = count(n, boxes, 0);

		// 루프를 돌면서 최대 상자의 갯수를 구함
		for (int i = 1; i < n; i++) {
			maxCounts = Math.max(maxCounts, count(n, boxes, i));
		}

		// 결과 값 출력
		System.out.println(maxCounts);
	}

	/**
	 * 최대 상자의 갯수를 구하는 재귀 메소드
	 * 
	 * @param n
	 * @param boxes
	 * @param index
	 * @return
	 */
	private static int count(int n, int[] boxes, int index) {
		// 캐시 배열의 값이 있을 경우 캐시 값을 사용
		if (cache[index] != 0) {
			return cache[index];
		}

		// index번째만 가지는 경우가 최소 값 임으로 1로 초기화
		int maxCounts = 1;

		// 루프를 돌면서 i번째 상자를 갖는 경우가 더 많은 상자를 가질 수 있는지 확인
		for (int i = index + 1; i < n; i++) {
			if (boxes[i] > boxes[index]) {
				maxCounts = Math.max(maxCounts, count(n, boxes, i) + 1);
			}
		}

		// 결과 값을 캐시에 저장 및 리턴
		return cache[index] = maxCounts;
	}
}