package boj_10822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 10822번 (더하기) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/10822
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), ",");
		int sum = 0;

		// 입력 값들의 합을 구함
		while (st.hasMoreTokens()) {
			sum += Integer.parseInt(st.nextToken());
		}

		br.close();

		// 결과 값 출력
		System.out.println(sum);
	}
}