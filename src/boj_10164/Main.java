package boj_10164;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 10164번 (격자상의 경로) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/10164
 * @author devetude
 */
public class Main {
	// 참 상수
	private static final int TRUE = 1;

	// K 미존재 상수
	private static final int IS_NOT_EXIST_K = 0;

	// 캐시 배열
	private static int[][][] cache = null;

	// 입력 변수
	private static int N = 0;
	private static int M = 0;
	private static int K = 0;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		br.close();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// 캐시 배열 초기화
		cache = new int[N][M][2];

		// 결과 값 출력
		System.out.println(count(0, 0, 0));
	}

	/**
	 * 로봇이 중간에 K를 들려서 끝까지 갈 수 있는 경우의 수를 구하는 재귀 메소드
	 * 
	 * @param row
	 * @param col
	 * @param isVisitedK
	 * @return
	 */
	private static int count(int row, int col, int isVisitedK) {
		// 현재 값을 구함
		int current = row * M + col + 1;

		// 현재 값이 끝 지점 일 경우
		if (current == N * M) {
			// K를 거쳐왔거나, K가 없는 경우
			if (isVisitedK == TRUE || K == IS_NOT_EXIST_K) {
				// 1가지 경우로 생각
				return 1;
			}

			else {
				return 0;
			}
		}

		// 캐시 배열에 값이 있는 경우 캐시 배열 값을 사용
		if (cache[row][col][isVisitedK] != 0) {
			return cache[row][col][isVisitedK];
		}

		// 현재 값이 K인 경우 저장
		if (current == K) {
			isVisitedK = TRUE;
		}

		// 맨 밑에 도달한 경우
		if (row == N - 1) {
			// 오른쪽으로만 이동하는 경우만 재귀 호출
			return cache[row][col][isVisitedK] = count(row, col + 1, isVisitedK);
		}

		// 맨 오른쪽에 도달한 경우
		else if (col == M - 1) {
			// 아랫쪽으로만 이동하는 경우만 재귀 호출
			return cache[row][col][isVisitedK] = count(row + 1, col, isVisitedK);
		}

		else {
			// 오른쪽, 아랫쪽으로 이동하는 경우 모두 재귀 호출
			return cache[row][col][isVisitedK] = count(row + 1, col, isVisitedK) + count(row, col + 1, isVisitedK);
		}
	}
}