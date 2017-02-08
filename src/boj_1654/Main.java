package boj_1654;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1654번 (랜선 자르기) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1654
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] wires = new int[K];

		// 이분탐색 최솟, 최댓 값 초기화
		long min = 1;
		long max = Long.MIN_VALUE;

		for (int i = 0; i < K; i++) {
			max = Math.max(max, wires[i] = Integer.parseInt(br.readLine()));
		}

		br.close();

		// 결과 값 저장 변수 초기화
		long res = min;

		// 이분탐색으로 결과 값을 찾음
		while (min <= max) {
			long mid = (min + max) / 2;
			int availableCnt = 0;

			// 가능한 선의 갯수를 구함
			for (long wire : wires) {
				availableCnt += wire / mid;
			}

			// 가능한 선의 갯수가 N 보다 작을 경우
			if (availableCnt < N) {
				max = mid - 1;
			}

			// 가능한 선의 갯수가 N과 같거나 큰 경우
			else {
				// 가장 긴 결과를 저장
				res = Math.max(res, mid);
				min = mid + 1;
			}
		}

		// 결과 값 출력
		System.out.println(res);
	}
}