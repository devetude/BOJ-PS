package boj_11399;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 11399번 (ATM) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/11399
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		br.close();

		// 고객 별 소요 시간 저장 배열 초기화
		int[] minutes = new int[N];

		for (int i = 0; i < N; i++) {
			minutes[i] = Integer.parseInt(st.nextToken());
		}

		// 오름차순으로 정렬
		Arrays.sort(minutes);

		// 결과 값 저장 변수 초기화
		int res = 0;

		// 결과 값 계산
		for (int i = 0; i < N; i++) {
			res += minutes[i] * (N - i);
		}

		// 결과 값 출력
		System.out.println(res);
	}
}