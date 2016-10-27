package boj_2010;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 2010번 (플러그) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2010
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int totalCounts = 1;

		for (int i = 0; i < N; i++) {
			// 현재까지 가능한 플러그 + 새롭게 추가되는 플러스 - 자기자신을 끼우는 플러그 (1) = 전체 플러그 수
			totalCounts += Integer.parseInt(br.readLine()) - 1;
		}

		br.close();

		// 결과 값 출력
		System.out.println(totalCounts);
	}
}