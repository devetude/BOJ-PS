package boj_10039;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 10039번 (평균 점수) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/10039
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 점수의 합 저장 변수
		int sum = 0;

		for (int i = 0; i < 5; i++) {
			int score = Integer.parseInt(br.readLine());

			// 점수가 40점 미만인 경우 40점을 점수의 합에 더함
			if (score < 40) {
				sum += 40;
			}

			// 점수가 40점 이상일 경우 입력된 점수를 점수의 합에 더함
			else {
				sum += score;
			}
		}

		br.close();

		// 결과 값 출력
		System.out.println(sum / 5);
	}
}