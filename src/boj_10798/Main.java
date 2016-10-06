package boj_10798;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 10798번 (세로읽기) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/10798
 * @author devetude
 */
public class Main {
	public static void main(String[] args) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] chars = new char[5][15];

		for (int i = 0; i < 5; i++) {
			char[] charTmp = br.readLine().toCharArray();

			for (int j = 0; j < charTmp.length; j++) {
				chars[i][j] = charTmp[j];
			}

			for (int j = charTmp.length; j < 15; j++) {
				chars[i][j] = ' ';
			}
		}

		// 버퍼를 이용해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				sb.append(chars[j][i]);
			}
		}

		// 결과 값을 한꺼번에 출력 (공백은 제외)
		System.out.println(sb.toString().replaceAll(" ", ""));
	}
}