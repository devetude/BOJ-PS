package boj_6359;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 6359번 (만취한 상범) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/6359
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해 입력을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] rooms = new int[n + 1];
			int openRoomCounts = 0;

			// 루프를 돌면서 방문을 열고 닫음
			for (int j = 1; j <= n; j++) {
				for (int k = j; k <= n; k++) {
					if (k % j == 0) {
						if (rooms[k] == 1) {
							rooms[k] = 0;
							openRoomCounts--;
						}

						else {
							rooms[k] = 1;
							openRoomCounts++;
						}
					}
				}
			}

			// 버퍼를 이용해 결과 값을 만듬
			sb.append(openRoomCounts).append("\n");
		}

		br.close();

		// 결과 값을 한꺼번에 출력
		System.out.println(sb.toString());
	}
}