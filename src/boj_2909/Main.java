package boj_2909;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2909번 (캔디 구매) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2909
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();

		int C = Integer.parseInt(st.nextToken());

		// 10^K 저장 변수
		int tenPowK = (int) Math.pow(10, Integer.parseInt(st.nextToken()));

		// 결과 값 출력
		System.out.println(Math.round((double) C / (double) tenPowK) * tenPowK);
	}
}