package boj_2033;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 2033번 (반올림) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2033
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();

		// 비교 변수 초기화
		int comp = 10;

		// 루프를 돌며 문제의 조건에 맞게 반올림 실행
		while (N > comp) {
			int nModComp = N % comp;

			if (nModComp * 10 / comp >= 5) {
				N += comp;
			}

			N -= nModComp;
			comp *= 10;
		}

		// 결과 값 출력
		System.out.println(N);
	}
}