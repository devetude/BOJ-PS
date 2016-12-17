package boj_2839;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 2839번 (설탕 배달) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2839
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();

		// 결과 값을 저장 할 변수
		int fiveCnt = 0;
		int threeCnt = 0;

		while (N >= 3) {
			// 5로 나누어 떨어지는 경우 종료
			if (N % 5 == 0) {
				fiveCnt = N / 5;
				N = 0;

				break;
			}

			// 5로 나누어 떨어지지 않는 경우 N에서 3을 뺌
			else {
				N -= 3;
				threeCnt++;
			}
		}

		// 남아있는 N이 없을 경우
		if (N == 0) {
			// 결과 값 출력
			System.out.println(fiveCnt + threeCnt);
		}

		else {
			System.out.println(-1);
		}
	}
}