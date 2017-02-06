package boj_5554;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 5554번 (심부름 가는 길) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/5554
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 총 걸린시간 저장 변수 (단위 : 초)
		int sec = 0;

		for (int i = 0; i < 4; i++) {
			sec += Integer.parseInt(br.readLine());
		}

		br.close();

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();
		sb.append(sec / 60).append("\n").append(sec % 60);

		// 결과 값 출력
		System.out.println(sb.toString());
	}
}