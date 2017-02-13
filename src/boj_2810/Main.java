package boj_2810;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 2810번 (컵홀더) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2810
 * @author devetude
 */
public class Main {
	// 일반 좌석 문자 상수
	private static final char S = 'S';

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String chair = br.readLine();

		br.close();

		// 컵 홀더 갯수 저장 변수 (맨 좌측 컵 홀더 갯수로 초기화)
		int cnt = 1;

		// 루프를 돌며 컵 홀더의 갯수를 셈
		for (int i = 0; i < N; i++) {
			// 일반 좌석 일 경우
			if (chair.charAt(i) == S) {
				cnt++;
			}

			// 커플 좌석 일 경우
			else {
				cnt++;
				i++;
			}
		}

		// 결과 값 출력
		System.out.println(cnt);
	}
}