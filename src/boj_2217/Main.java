package boj_2217;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 * 백준 온라인 저지 2217번 (로프) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2217
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 로프가 견딜 수 있는 무게 저장 배열 초기화
		Integer[] weights = new Integer[N];

		for (int i = 0; i < N; i++) {
			weights[i] = Integer.parseInt(br.readLine());
		}

		br.close();

		// 내림차순으로 정렬
		Arrays.sort(weights, Collections.reverseOrder());

		// 초기 최대 무게를 로프 중 가장 무거운 무게를 견딜 수 있는 값으로 초기화
		int max = weights[0];

		// 루프를 돌며 최대 무게를 구함
		for (int i = 1; i < N; i++) {
			max = Math.max(max, weights[i] * (i + 1));
		}

		// 결과 값 출력
		System.out.println(max);
	}
}