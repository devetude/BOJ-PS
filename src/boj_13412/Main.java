package boj_13412;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 13412번 (서로소 쌍) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/13412
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int sqrtN = (int) Math.sqrt(N);

			// 1과 N은 문제의 조건을 항상 만족함으로 갯수는 1로 초기화
			int counts = 1;

			// N의 약수를 루프를 돌며 구함
			for (int j = 2; j <= sqrtN; j++) {
				if (N % j == 0) {
					boolean isExcept = false;

					// N의 약수인 j가 (N / j)와 서로소 관계인지 검증
					for (int k = 2; k <= j; k++) {
						if (j % k == 0 && N / j % k == 0) {
							isExcept = true;

							break;
						}
					}

					// 서로소일 경우 갯수를 추가
					if (!isExcept) {
						counts++;
					}
				}
			}

			// 버퍼를 통해 결과 값을 만듬
			sb.append(counts).append("\n");
		}

		br.close();

		// 결과 값 출력
		System.out.println(sb.toString());
	}
}