package boj_2667;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 온라인 저지 2667번 (단지번호붙이기) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2667
 * @author devetude
 */
public class Main {
	// 개행 문자열 상수
	private static final String NEW_LINE = "\n";

	// 단지의 상태 상수
	private static final int IS_HOUSE = 1;
	private static final int IS_NOT_HOUSE = 0;

	// 위, 아래, 오른쪽, 왼쪽 상수
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	// 지도의 크기, 지도 저장 배열
	private static int N = 0;
	private static int[][] map = null;

	// 단지 인덱스, 단지별 포함되어있는 집의 갯수 저장 배열
	private static int groupIdx = 0;
	private static int[] houseCntInGroup = null;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		// 지도 배열 초기화
		map = new int[N][N];

		// 단지별 포함되어있는 집의 갯수 저장 배열 초기화
		houseCntInGroup = new int[N * N];

		// 루프를 돌며 지도를 만듬
		for (int i = 0; i < N; i++) {
			String line = br.readLine();

			for (int j = 0; j < N; j++) {
				map[i][j] = Character.getNumericValue(line.charAt(j));
			}
		}

		br.close();

		// 루프를 돌며 집인 경우 dfs를 시작
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == IS_HOUSE) {
					// 단지 번호를 1 증가시킴 (새로운 단지가 형성된 것 임으로)
					groupIdx++;
					dfs(i, j);
				}
			}
		}

		// 단지별 포함되어있는 집의 갯수를 오름차순으로 정렬
		Arrays.sort(houseCntInGroup, 1, groupIdx + 1);

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();
		sb.append(groupIdx).append(NEW_LINE);

		for (int i = 1; i <= groupIdx; i++) {
			sb.append(houseCntInGroup[i]).append(NEW_LINE);
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}

	/**
	 * dfs 메소드
	 * 
	 * @param x
	 * @param y
	 */
	private static void dfs(int x, int y) {
		// 현재 지점을 집 -> 집이 아님 상태로 변경하여 다시 방문하지 않도록 설정
		map[x][y] = IS_NOT_HOUSE;

		// 해당 단지의 포함되어있는 집의 갯수 1 증가
		houseCntInGroup[groupIdx]++;

		// 지도의 위, 아래, 오른쪽, 왼쪽을 찾아가며 집인 경우 다시 dfs를 시작
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if (map[nx][ny] == IS_HOUSE) {
					dfs(nx, ny);
				}
			}
		}
	}
}