package boj_9550;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 9550번 (아이들은 사탕을 좋아해) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/9550
 * @author devetude
 */
public class Main {
	// 개행 문자 상수
	private static final char NEW_LINE = '\n';

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");

			// 아이들의 수 저장 변수 초기화
			int cnt = 0;

			// 루프를 통해 아이들의 수를 구함
			while (N-- > 0) {
				cnt += Integer.parseInt(st.nextToken()) / K;
			}

			sb.append(cnt).append(NEW_LINE);
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}