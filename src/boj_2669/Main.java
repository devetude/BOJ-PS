package boj_2669;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2669번 (직사각형 네개의 합집합의 면적 구하기) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/2669
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 입력 값을 버퍼를 이용해서 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] res = new int[101][101];

		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			// 루프를 돌면서 영역이 되는 부분을 1로 바꿈
			for (int x = x1; x < x2; x++) {
				for (int y = y1; y < y2; y++) {
					res[x][y] = 1;
				}
			}
		}

		br.close();

		// 총 면적 변수
		int area = 0;

		// 루프를 돌면서 영역이 1인 부분의 총 갯수를 구함
		for (int x = 1; x <= 100; x++) {
			for (int y = 1; y <= 100; y++) {
				if (res[x][y] == 1) {
					area++;
				}
			}
		}

		// 결과 값 출력
		System.out.println(area);
	}
}