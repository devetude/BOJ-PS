package boj_2588;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 2588번 (곱셈) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/2588
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		String bStr = br.readLine();
		String[] bStrs = bStr.split("");
		StringBuilder sb = new StringBuilder();

		// b를 한 자리씩 곱해서 결과 값에 저장
		for (int i = 2; i >= 0; i--) {
			sb.append(a * Integer.parseInt(bStrs[i])).append("\n");
		}

		br.close();

		// a와 b의 곱을 결과 값에 저장
		sb.append(a * Integer.parseInt(bStr));

		// 결과 값 출력
		System.out.println(sb.toString());
	}
}