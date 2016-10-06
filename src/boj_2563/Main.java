package boj_2563;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2563번 (색종이) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/2563
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[][] pos = new int[100][100];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = startX + 10;
			int endY = startY + 10;

			// 색종이가 덮는 검은 영역을 1로 표시
			for (int j = startX; j < endX; j++) {
				for (int k = startY; k < endY; k++) {
					pos[j][k] = 1;
				}
			}
		}

		br.close();

		int areaSize = 0;

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				// 전체 도화지 중 검은 영역의 갯수를 찾음
				if (pos[i][j] == 1) {
					areaSize++;
				}
			}
		}

		// 결과 값 출력
		System.out.println(areaSize);
	}
}