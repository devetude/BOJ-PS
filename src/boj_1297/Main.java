package boj_1297;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1297번 (TV 크기) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1297
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int diagonalLen = Integer.parseInt(st.nextToken());
		int heightRatio = Integer.parseInt(st.nextToken());
		int widthRatio = Integer.parseInt(st.nextToken());
		br.close();

		// 비율 계산 (피타고라스의 정의 a^2 + b^2 = c^2을 이용하여 대각선 비율을 구하고 실제 비율을 구함)
		double ratio = diagonalLen / Math.sqrt(Math.pow(heightRatio, 2) + Math.pow(widthRatio, 2));

		// 버퍼를 이용해 결과 값 출력
		StringBuilder sb = new StringBuilder();
		sb.append((int) (heightRatio * ratio)).append(" ").append((int) (widthRatio * ratio));
		System.out.println(sb.toString());
	}
}