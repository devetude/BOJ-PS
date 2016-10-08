package boj_11094;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 11094번 (꿍 가라사대) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/11094
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			String say = br.readLine();

			// 'Simon says '로 시작하면 결과 값을 버퍼에 저장
			if (say.startsWith("Simon says ")) {
				sb.append(say.substring(10)).append("\n");
			}
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}