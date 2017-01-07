package boj_10250;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 10250번 (ACM 호텔) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/10250
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// 결과 값을 저장 할 버퍼 초기화
		StringBuilder sb = new StringBuilder();

		while (T-- != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken());
			st.nextToken();
			int N = Integer.parseInt(st.nextToken());

			// 버퍼를 통해 결과 값을 만듬
			// 층수 = (N - 1) % H + 1
			// 호실 = (N - 1) / H + 1
			sb.append(String.format("%d%02d\n", (N - 1) % H + 1, (N - 1) / H + 1));
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}