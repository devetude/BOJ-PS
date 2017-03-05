package boj_11403;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 11403번 (경로 찾기) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/11403
 * @author devetude
 */
public class Main {
	// 문자 상수
	private static final char SPACE = ' ';
	private static final char NEW_LINE = '\n';

	// 정점 갯수 저장 변수
	private static int N = 0;

	// 인접 행렬 배열
	private static int[][] matrix = null;

	// 방문 여부 확인 배열
	private static int[] isVisited = null;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		// 인접 행렬 배열 초기화
		matrix = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 방문 여부 확인 배열 초기화
		isVisited = new int[N];

		// 결과 값 저장 배열 초기화
		int[][] isExist = new int[N][N];

		// 루프를 돌며 dfs 탐색
		for (int u = 0; u < N; u++) {
			dfs(u, true);

			for (int v = 0; v < N; v++) {
				// 결과 저장
				isExist[u][v] = isVisited[v];

				// 다음 시작 지점 탐색을 위해 방문 여부를 초기화
				isVisited[v] = 0;
			}
		}

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(isExist[i][j]).append(SPACE);
			}

			sb.append(NEW_LINE);
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}

	/**
	 * dfs 메소드
	 * 
	 * @param u
	 * @param isStartPoint
	 */
	private static void dfs(int u, boolean isStartPoint) {
		if (!isStartPoint) {
			isVisited[u] = 1;
		}

		for (int v = 0; v < N; v++) {
			if (matrix[u][v] == 1 && isVisited[v] == 0) {
				dfs(v, false);
			}
		}
	}
}