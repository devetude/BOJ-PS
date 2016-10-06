package boj_11055;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 11055번 (가장 큰 증가 부분 수열) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/11055
 * @author devetude
 */
public class Main {
	private static int[] cache;

	public static void main(String[] args) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();

		int[] arr = new int[N];
		cache = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 증가 부분 수열의 합의 최대 값을 저장하기 위한 변수
		int maxSum = 0;

		for (int i = 0; i < N; i++) {
			// i항 부터 시작하는 증가 부분 수열의 최대 합을 구함
			maxSum = Math.max(maxSum, add(arr, i));
		}

		// 결과 값 출력
		System.out.println(maxSum);
	}

	/**
	 * 증가 부분 수열의 합의 최대 값을 구하는 재귀 메소드
	 * 
	 * @param arr
	 * @param currentIndex
	 * @return
	 */
	private static int add(int[] arr, int currentIndex) {
		// 기저조건 : 증가 부분 수열의 합이 구해져 있는 경우
		if (cache[currentIndex] != 0) {
			return cache[currentIndex];
		}

		// 증가 부분 수열의 합의 값을 현재 값으로 초기화
		cache[currentIndex] = arr[currentIndex];

		for (int i = currentIndex + 1; i < arr.length; i++) {
			// 현재 값 보다 큰 값 일 경우
			if (arr[currentIndex] < arr[i]) {
				// 증가 부분 수열의 합이 큰 것을 캐시에 저장
				cache[currentIndex] = Math.max(cache[currentIndex], add(arr, i) + arr[currentIndex]);
			}
		}

		return cache[currentIndex];
	}
}