package boj_2783;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2783번 (삼각 김밥) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2783
 * @author devetude
 */
public class Main {
	// 무게 상수
	private static final int TOTAL_WEIGHT = 1_000;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		double X = Double.parseDouble(st.nextToken());
		double Y = Double.parseDouble(st.nextToken());
		int N = Integer.parseInt(br.readLine());

		// 초기에 세븐 25의 1000g 가격을 최솟 값으로 설정
		double minCost = TOTAL_WEIGHT / Y * X;

		// 다른 편의점들과 루프를 돌며 가격 비교
		while (N-- != 0) {
			st = new StringTokenizer(br.readLine(), " ");
			double Xi = Double.parseDouble(st.nextToken());
			double Yi = Double.parseDouble(st.nextToken());

			// 더 싼 가격을 저장함
			minCost = Math.min(minCost, TOTAL_WEIGHT / Yi * Xi);
		}

		br.close();

		// 결과 값 출력
		System.out.printf("%.2f", minCost);
	}
}