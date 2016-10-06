package boj_10158;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 10158번 (개미) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/10158
 * @author devetude
 */
public class Main {
	// 4방향 상수
	private static final int UP_RIGHT = 1;
	private static final int UP_LEFT = 2;
	private static final int DOWN_LEFT = 3;
	private static final int DOWN_RIGHT = 4;

	public static void main(String[] args) throws Exception {
		// 버퍼를 이용해 입력을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());
		br.close();

		// 현재 개미의 진행 방향 저장 변수
		int dir = UP_RIGHT;
		int moveCounts = 0;

		// 루프를 돌면서 이동
		while (true) {
			if (t == 0) {
				break;
			}

			switch (dir) {
			case UP_RIGHT:
				moveCounts = Math.min(w - p, h - q);

				if (moveCounts >= t) {
					p += t;
					q += t;
					t = 0;
				}

				else {
					p += moveCounts;
					q += moveCounts;

					if (q == h && p < w) {
						dir = DOWN_RIGHT;
					}

					else if (p == w && q == h) {
						dir = DOWN_LEFT;
					}

					else {
						dir = UP_LEFT;
					}

					t -= moveCounts;
				}

				break;

			case UP_LEFT:
				moveCounts = Math.min(p, h - q);

				if (moveCounts >= t) {
					p -= t;
					q += t;
					t = 0;
				}

				else {
					p -= moveCounts;
					q += moveCounts;

					if (q == h && p > 0) {
						dir = DOWN_LEFT;
					}

					else if (q == h && p == 0) {
						dir = DOWN_RIGHT;
					}

					else {
						dir = UP_RIGHT;
					}

					t -= moveCounts;
				}

				break;

			case DOWN_RIGHT:
				moveCounts = Math.min(w - p, q);

				if (moveCounts >= t) {
					p += t;
					q -= t;
					t = 0;
				}

				else {
					p += moveCounts;
					q -= moveCounts;

					if (q == 0 && p < w) {
						dir = UP_RIGHT;
					}

					else if (q == 0 && p == w) {
						dir = UP_LEFT;
					}

					else {
						dir = DOWN_LEFT;
					}

					t -= moveCounts;
				}

				break;

			case DOWN_LEFT:
				moveCounts = Math.min(p, q);

				if (moveCounts >= t) {
					p -= t;
					q -= t;
					t = 0;
				}

				else {
					p -= moveCounts;
					q -= moveCounts;

					if (q == 0 && p > 0) {
						dir = UP_LEFT;
					}

					else if (q == 0 && p == 0) {
						dir = UP_RIGHT;
					}

					else {
						dir = DOWN_RIGHT;
					}

					t -= moveCounts;
				}

				break;
			}
		}

		// 버퍼를 이용해 결과 값 출력
		StringBuilder sb = new StringBuilder();
		sb.append(p).append(" ").append(q);
		System.out.println(sb.toString());
	}
}