package boj_1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1010번 (다리 놓기) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1010
 * @author devetude
 */
public class Main {
	private static final int MAX = 30;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// 캐시 배열 초기화
		int[][] cache = new int[MAX + 1][MAX + 1];

		for (int i = 1; i <= MAX; i++) {
			cache[1][i] = i;
			cache[i][i] = 1;
		}

		// 점화식 : [i][j] = [i][j - 1] + [i - 1][j - 1] (단, i >= 2이고 j = i + 1)
		for (int i = 2; i <= MAX; i++) {
			for (int j = i + 1; j <= MAX; j++)
				cache[i][j] = cache[i][j - 1] + cache[i - 1][j - 1];
		}

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			sb.append(cache[N][M]).append("\n");
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}