package boj_5046;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 5046번 (전국 대학생 프로그래밍 대회 동아리 연합) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/5046
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		// 최소 비용 저장 변수 초기화
		int minCost = Integer.MAX_VALUE;

		while (H-- > 0) {
			int p = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < W; i++) {
				int available = Integer.parseInt(st.nextToken());

				// 인원을 수용할 수 있는지 확인
				if (available >= N) {
					int cost = p * N;

					// 예산내에 있는지 확인
					if (cost <= B) {
						minCost = Math.min(minCost, cost);
					}
				}
			}
		}

		br.close();

		// 결과 값을 찾은 경우
		if (minCost < Integer.MAX_VALUE) {
			System.out.println(minCost);
		}

		// 결과 값을 찾지 못한 경우
		else {
			System.out.println("stay home");
		}
	}
}