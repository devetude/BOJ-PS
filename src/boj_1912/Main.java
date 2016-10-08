package boj_1912;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1912번 (연속합) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/1912
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] res = new int[n];

		// 결과 배열의 0번 인덱스의 값은 첫번째 입력 값과 같음
		res[0] = Integer.parseInt(st.nextToken());

		for (int i = 1; i < n; i++) {
			// 먼저 결과 배열에 입력 값을 넣어줌
			res[i] = Integer.parseInt(st.nextToken());

			// 이전 값과 현재 값을 더한 것이 현재 값 보다 클 경우 결과 값에 그 값을 저장, 아닐 경우 그냥 현재 값 저장
			res[i] = Math.max(res[i], res[i - 1] + res[i]);
		}

		br.close();

		// 결과 배열을 오름차순으로 정렬
		Arrays.sort(res);

		// 가장 큰 값을 결과 값으로 출력
		System.out.println(res[n - 1]);
	}
}