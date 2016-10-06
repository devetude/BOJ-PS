package boj_2491;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2491번 (수열) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/2491
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 길이가 1인 경우에 결과 값은 1
		if (N == 1) {
			System.out.println(1);
		}

		else {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[N];

			int maxInscreasingLength = 1;
			int increasingLength = 1;
			int maxDecreasingLength = 1;
			int decreasingLength = 1;

			// 수열을 받음
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < N - 1; i++) {
				if (arr[i] <= arr[i + 1]) {
					// 증가 수열의 길이 값을 증가
					increasingLength++;
				}

				else {
					// 증가 수열의 최대 길이를 저장 및 증가 수열의 길이 값 초기화
					maxInscreasingLength = Math.max(maxInscreasingLength, increasingLength);
					increasingLength = 1;
				}

				if (arr[i] >= arr[i + 1]) {
					// 감소 수열의 길이 값을 증가
					decreasingLength++;
				}

				else {
					// 감소 수열의 최대 길이를 저장 및 감소 수열의 길이 값 초기화
					maxDecreasingLength = Math.max(maxDecreasingLength, decreasingLength);
					decreasingLength = 1;
				}
			}

			// 마지막 항목을 포함하기 위해 최대 길이를 다시 한번 검사
			maxInscreasingLength = Math.max(maxInscreasingLength, increasingLength);
			maxDecreasingLength = Math.max(maxDecreasingLength, decreasingLength);

			// 증가 수열의 최대 길이와 감소 수열의 최대 길이 중 더 큰 값을 결과 값으로 출력
			System.out.println(Math.max(maxInscreasingLength, maxDecreasingLength));
		}

		br.close();
	}
}