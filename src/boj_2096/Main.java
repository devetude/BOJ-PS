package boj_2096;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2096번 (내려가기) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2096
 * @author devetude
 */
public class Main {
	// 캐시 배열 ([행][열] = 최대 혹은 최저 점수)
	private static int[][] cache = null;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] scores = new int[N][3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < 3; j++) {
				scores[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		br.close();

		// 캐시 배열 초기화
		cache = new int[N][3];

		// 캐시 배열의 값들을 -1로 초기화
		for (int[] c : cache) {
			Arrays.fill(c, -1);
		}

		// 버퍼를 이용해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		// 최대 점수 저장 변수
		int maxScore = 0;

		// 루프를 돌면서 최대 점수를 구함
		for (int i = 0; i < 3; i++) {
			maxScore = Math.max(maxScore, maxCount(N, scores, 0, i));
		}

		// 결과 값에 최대 점수 추가
		sb.append(maxScore).append(" ");

		// 최저 점수를 구하기 위해 다시 캐시 배열 값들을 -1로 초기화
		for (int[] c : cache) {
			Arrays.fill(c, -1);
		}

		// 최저 점수 저장 변수
		int minScore = 9 * N;

		// 루프를 돌면서 최저 점수를 구함
		for (int i = 0; i < 3; i++) {
			minScore = Math.min(minScore, minCount(N, scores, 0, i));
		}

		// 결과 값에 최저 점수 추가
		sb.append(minScore);

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}

	/**
	 * 최대 점수를 구하는 재귀 메소드
	 * 
	 * @param N
	 * @param scores
	 * @param i
	 * @param j
	 * @return
	 */
	private static int maxCount(int N, int[][] scores, int i, int j) {
		// 기저조건 : 마지막 줄에 도달했을 경우 그 점수 값을 리턴
		if (i == N - 1) {
			return scores[i][j];
		}

		// 캐시 배열에 값이 있는 경우 캐시 값을 사용
		if (cache[i][j] != -1) {
			return cache[i][j];
		}

		// 최대 점수를 구함
		int maxScore = maxCount(N, scores, i + 1, j) + scores[i][j];

		switch (j) {
		case 0:
			maxScore = Math.max(maxScore, maxCount(N, scores, i + 1, j + 1) + scores[i][j]);
			break;

		case 1:
			maxScore = Math.max(maxScore, maxCount(N, scores, i + 1, j - 1) + scores[i][j]);
			maxScore = Math.max(maxScore, maxCount(N, scores, i + 1, j + 1) + scores[i][j]);
			break;

		case 2:
			maxScore = Math.max(maxScore, maxCount(N, scores, i + 1, j - 1) + scores[i][j]);

			break;
		}

		// 결과 값을 캐시에 저장 및 리턴
		return cache[i][j] = maxScore;
	}

	/**
	 * 최저 점수를 구하는 재귀 메소드
	 * 
	 * @param N
	 * @param scores
	 * @param i
	 * @param j
	 * @return
	 */
	private static int minCount(int N, int[][] scores, int i, int j) {
		// 기저조건 : 마지막 줄에 도달했을 경우 그 점수 값을 리턴
		if (i == N - 1) {
			return scores[i][j];
		}

		// 캐시 배열에 값이 있는 경우 캐시 값을 사용
		if (cache[i][j] != -1) {
			return cache[i][j];
		}

		// 최저 점수를 구함
		int minScore = minCount(N, scores, i + 1, j) + scores[i][j];

		switch (j) {
		case 0:
			minScore = Math.min(minScore, minCount(N, scores, i + 1, j + 1) + scores[i][j]);
			break;

		case 1:
			minScore = Math.min(minScore, minCount(N, scores, i + 1, j - 1) + scores[i][j]);
			minScore = Math.min(minScore, minCount(N, scores, i + 1, j + 1) + scores[i][j]);
			break;

		case 2:
			minScore = Math.min(minScore, minCount(N, scores, i + 1, j - 1) + scores[i][j]);

			break;
		}

		// 결과 값을 캐시에 저장 및 리턴
		return cache[i][j] = minScore;
	}
}