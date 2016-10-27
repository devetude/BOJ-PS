package boj_3046;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 3046번 (R2) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/3046
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();

		int R1 = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		System.out.println(2 * S - R1);
	}
}