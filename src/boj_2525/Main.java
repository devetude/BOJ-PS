package boj_2525;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2525번 (오븐 시계) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/2525
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(br.readLine());
		br.close();

		// 시간 계산
		int sumMinutes = B + C;
		int hours = (A + sumMinutes / 60) % 24;
		int minutes = sumMinutes % 60;

		// 결과 값 출력
		System.out.println(new StringBuilder().append(hours).append(" ").append(minutes).toString());
	}
}