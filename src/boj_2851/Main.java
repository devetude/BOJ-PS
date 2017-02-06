package boj_2851;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 2851번 (슈퍼 마리오) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2851
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 총 점수 저장 변수
		int totalPoint = 0;

		for (int i = 0; i < 10; i++) {
			int currentPoint = Integer.parseInt(br.readLine());
			int currentDistance = 100 - totalPoint;

			// 100점과 멀어진 결과가 나온 경우 루프를 탈출
			if (Math.abs(currentDistance) < Math.abs(currentDistance - currentPoint)) {
				break;
			}

			// 총 점수에 현재 점수를 더함
			totalPoint += currentPoint;
		}

		br.close();

		// 결과 값 출력
		System.out.println(totalPoint);
	}
}