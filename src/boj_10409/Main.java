package boj_10409;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 10409번 (서버) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/10409
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");

		// 처리된 일의 갯수 저장 변수
		int i = 0;

		// 처리된 일의 시간의 합 저장 변수
		int sum = 0;

		// 루프를 돌며 처리 가능한 일의 갯수를 구함
		for (; i < n; i++) {
			int time = Integer.parseInt(st.nextToken());

			if (sum + time <= T) {
				sum += time;
			}

			else {
				break;
			}
		}

		br.close();

		// 결과 값 출력
		System.out.println(i);
	}
}