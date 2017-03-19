package boj_2566;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2566번 (최댓값) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2566
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 가장 큰 값과 그 행, 열 저장 변수 초기화
		int max = 0;
		int maxRow = 1;
		int maxCol = 1;

		// 루프를 돌며 가장 큰 값과 그 행, 열을 찾음
		for (int row = 1; row <= 9; row++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int col = 1; col <= 9; col++) {
				int input = Integer.parseInt(st.nextToken());

				if (max < input) {
					max = input;
					maxRow = row;
					maxCol = col;
				}
			}
		}

		br.close();

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();
		sb.append(max).append('\n');
		sb.append(maxRow).append(' ').append(maxCol);

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}