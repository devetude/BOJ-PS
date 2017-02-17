package boj_10709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 10709번 (기상캐스터) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/10709
 * @author devetude
 */
public class Main {
	// 구름이 뜨지 않을 경우를 나타내는 상수
	private static final int IMPOSSIBLE_EMERGE = -1;

	// 문자열 상수
	private static final String SPACE = " ";
	private static final String NEW_LINE = "\n";
	private static final String CLOUD = "c";

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		// 지도 배열 초기화
		String[][] map = new String[H][W];

		// 지도의 상태를 채움
		for (int i = 0; i < H; i++) {
			map[i] = br.readLine().split("");
		}

		br.close();

		// 결과 저장 배열 초기화
		int[][] res = new int[H][W];

		// 버퍼를 이용해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				// 현재 구름이 떠 있는 경우
				if (map[i][j].equals(CLOUD)) {
					res[i][j] = 0;
				}

				// 지도의 맨 왼쪽이 아니면서 바로 왼쪽 부분이 구름이 뜨지 않는 경우가 아니라면
				else if (j >= 1 && res[i][j - 1] != IMPOSSIBLE_EMERGE) {
					// 이전 상태보다 1시간 늦게 구름이 도착
					res[i][j] = res[i][j - 1] + 1;
				}

				// 그 외 구름이 뜰 수 없는 경우
				else {
					res[i][j] = IMPOSSIBLE_EMERGE;
				}

				sb.append(res[i][j]).append(SPACE);
			}

			sb.append(NEW_LINE);
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}