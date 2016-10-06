package boj_1934;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1934번 (최소공배수) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/1934
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해서 입력 값을 받아옴
		// (이유 : Scanner를 반복적으로 이용 할 경우 매우 느림)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int[] resArr = new int[T];

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int multiplyAB = a * b;

			// 유클리드 호제법을 이용하여 두 수의 최대공약수를 구한 후
			while (true) {
				if (b == 0) {
					// 두 수의 곱에서 나누면 두 수의 최소공배수를 구할 수 있음
					resArr[i] = multiplyAB / a;
					break;
				}

				int tmp = b;
				b = a % b;
				a = tmp;
			}
		}

		br.close();

		// 버퍼를 이용하여 결과 값을 만듬
		// (이유 : System.out.println을 여러번 호출 할 경우 매우 느림)
		StringBuilder sb = new StringBuilder();

		for (int res : resArr) {
			sb.append(res).append("\n");
		}

		// 결과 값을 한꺼번에 출력
		System.out.println(sb.toString());
	}
}