package boj_5596;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 5596번 (시험 점수) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/5596
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// 점수의 합 저장 변수
		int S = 0;
		int T = 0;

		for (int i = 0; i < 4; i++) {
			S += Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < 4; i++) {
			T += Integer.parseInt(st.nextToken());
		}

		br.close();

		// 결과 값 출력
		System.out.println(Math.max(S, T));
	}
}