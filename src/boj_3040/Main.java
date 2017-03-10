package boj_3040;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 3040번 (백설 공주와 일곱 난쟁이) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/3040
 * @author devetude
 */
public class Main {
	// 거짓말쟁이 설정 상수
	private static final int LIER = 0;

	// 개행 문자열 상수
	private static final String NEW_LINE = "\n";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] heights = new int[9];

		// 아홉 난쟁이의 키의 합 저장 변수 초기화
		int sum = 0;

		for (int i = 0; i < 9; i++) {
			sum += heights[i] = Integer.parseInt(br.readLine());
		}

		br.close();

		// 거짓말쟁이 2명의 키를 합한 결과를 구함
		sum -= 100;

		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				// 거짓말쟁이 2명을 찾은 경우 2명의 키를 0으로 변경
				if (heights[i] + heights[j] == sum) {
					heights[i] = heights[j] = LIER;
				}
			}
		}

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (int height : heights) {
			if (height != LIER) {
				sb.append(height).append(NEW_LINE);
			}
		}

		// 결과 값 출력
		System.out.println(sb.toString());
	}
}