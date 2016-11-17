package boj_2965;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2965번 (캥거루 세마리) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] pos = new int[3];

		for (int i = 0; i < 3; i++) {
			pos[i] = Integer.parseInt(st.nextToken());
		}

		br.close();

		// 최대 움직일 수 있는 거리 = 0번, 1번 간격과 1번, 2번 간격 중 큰 쪽 - 1
		int maxCnt = Math.max(pos[1] - pos[0], pos[2] - pos[1]) - 1;

		// 결과 값 출력
		System.out.println(maxCnt);
	}
}