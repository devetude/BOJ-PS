package boj_1157;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 1157번 (단어 공부) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1157
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] strChars = br.readLine().toUpperCase().toCharArray();
		br.close();

		// 알파벳 등장 횟수 저장 배열
		int[] alphabetCnts = new int[26];

		// 알파벳 등장 횟수를 셈
		for (int strChar : strChars) {
			alphabetCnts[strChar - 65]++;
		}

		int maxCntIdx = 0;
		int maxCnt = alphabetCnts[maxCntIdx];

		for (int i = 1; i <= 25; i++) {
			// 현재 가장 높은 등장 횟수와 동일한 횟수가 등장했을 경우
			if (alphabetCnts[i] == maxCnt) {
				maxCntIdx = -1;
			}

			// 현재 가장 높은 등장 횟수보다 큰 횟수가 등장했을 경우
			else if (alphabetCnts[i] > maxCnt) {
				maxCntIdx = i;
				maxCnt = alphabetCnts[i];
			}
		}

		// 가장 높은 등장 횟수가 2개 이상있는 경우
		if (maxCntIdx == -1) {
			System.out.println("?");
		}

		else {
			System.out.println((char) (maxCntIdx + 65));
		}
	}
}