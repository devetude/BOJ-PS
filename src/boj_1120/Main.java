package boj_1120;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1120번 (문자열) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1120
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		br.close();

		char[] aChars = st.nextToken().toCharArray();
		char[] bChars = st.nextToken().toCharArray();
		int diffLen = bChars.length - aChars.length;

		// 최소 차이 갯수 저장 변수 초기화
		// (최대 : B 문자열의 길이)
		int minDiffCnt = bChars.length;

		// 루프를 돌며 A 문자열이 B 문자열과 차이나는 문자의 갯수가 최소가 되도록 찾음
		for (int i = 0; i <= diffLen; i++) {
			int diffCnt = 0;

			for (int j = 0; j < aChars.length; j++) {
				if (aChars[j] != bChars[i + j]) {
					diffCnt++;
				}
			}

			minDiffCnt = Math.min(minDiffCnt, diffCnt);
		}

		// 결과 값 출력
		System.out.println(minDiffCnt);
	}
}