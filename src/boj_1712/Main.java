package boj_1712;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1712번 (손익분기점) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1712
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		br.close();

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		// 손익분기점이 생길 수 없는 예외일 경우
		if (B >= C) {
			System.out.println(-1);
		}

		else {
			// 결과 값 출력
			System.out.println(A / (C - B) + 1);
		}
	}
}