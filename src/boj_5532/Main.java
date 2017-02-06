package boj_5532;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 5532번 (방학 숙제) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/5532
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		double A = Double.parseDouble(br.readLine());
		double B = Double.parseDouble(br.readLine());
		double C = Double.parseDouble(br.readLine());
		double D = Double.parseDouble(br.readLine());

		br.close();

		// 결과 값 출력
		System.out.println(L - (int) Math.max(Math.ceil(A / C), Math.ceil(B / D)));
	}
}