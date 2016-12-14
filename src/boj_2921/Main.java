package boj_2921;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 2921번 (도미노) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2921
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();

		// 결과 저장 변수
		int res = 0;

		// i가 0부터 N까지 커지면서 첫항이 i 끝항이 (2 * i) 공차가 1인 등차수열의 합들의 합을 구함
		for (int i = 0; i <= N; i++) {
			res += 3 * i * (i + 1) / 2;
		}

		// 결과 값 출력
		System.out.println(res);
	}
}