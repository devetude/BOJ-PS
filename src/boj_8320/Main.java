package boj_8320;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 8320번 (직사각형을 만드는 방법) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/8320
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();

		// 만들 수 있는 직사각형 갯수 변수 저장 변수
		int cnt = 0;

		// 루프를 돌며 한 변의 길이가 1부터 n까지 가능한 직사각형의 갯수를 셈
		for (int i = 1; i <= n; i++) {
			for (int j = i; i * j <= n; j++) {
				cnt++;
			}
		}

		// 결과 값 출력
		System.out.println(cnt);
	}
}