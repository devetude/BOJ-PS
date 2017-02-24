package boj_10807;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 10807번 (개수 세기) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/10807
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int v = Integer.parseInt(br.readLine());

		br.close();

		// 갯수 저장 변수 초기화
		int cnt = 0;

		// v의 갯수를 셈
		while (N-- != 0) {
			if (Integer.parseInt(st.nextToken()) == v) {
				cnt++;
			}
		}

		// 결과 값 출력
		System.out.println(cnt);
	}
}