package boj_2493;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2493번 (탑) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/2493
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// 탑의 높이를 저장하기 위한 배열
		int[] heights = new int[N];

		for (int i = 0; i < N; i++) {
			// 테스트 케이스에 줄바꿈되어 있는 경우(버그)가 있어서 한번 더 읽어오는 코드를 삽입
			if (!st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine(), " ");
			}

			heights[i] = Integer.parseInt(st.nextToken());
		}

		br.close();

		// 수신 결과를 저장하기 위한 배열
		int[] res = new int[N];

		for (int i = N - 1; i >= 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				// 송신탑 보다 수신탑의 높이가 클 경우 탐색을 종료하고 해당 인덱스를 저장
				if (heights[i] < heights[j]) {
					res[i] = j + 1;
					break;
				}
			}
		}

		// 버퍼를 이용하여 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (int n : res) {
			sb.append(n).append(" ");
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}