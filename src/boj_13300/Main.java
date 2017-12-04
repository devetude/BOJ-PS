package boj_13300;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 13300번 (방 배정) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/13300
 * @author devetude
 */
public class Main {
	// 공백 문자열 상수
	private static final String SPACE = " ";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 정보 저장 배열 초기화 ([학년][성별])
		int[][] classes = new int[7][2];

		while (N-- > 0) {
			st = new StringTokenizer(br.readLine(), SPACE);
			int S = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());

			classes[Y][S]++;
		}

		br.close();

		// 총 방의 수를 저장 할 변수 초기화
		int totalRoomCnt = 0;

		// 필요한 방의 수를 구함
		for (int[] c : classes) {
			for (int sex = 0; sex < 2; sex++) {
				int roomCnt = c[sex] / K;

				if (c[sex] % K > 0) {
					roomCnt++;
				}

				totalRoomCnt += roomCnt;
			}
		}

		// 결과 값 출력
		System.out.println(totalRoomCnt);
	}
}