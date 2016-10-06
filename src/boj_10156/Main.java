package boj_10156;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 10156번 (과자) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/10156
 * @author devetude
 */
public class Main {
	public static void main(String[] args) throws Exception {
		// 버퍼를 이용해 입력을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();

		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 부족한 금액 계산
		int lackMoney = K * N - M;

		// 결과 값 출력
		System.out.println(lackMoney > 0 ? lackMoney : 0);
	}
}