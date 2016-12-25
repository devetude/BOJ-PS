package boj_1316;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 1316번 (그룹 단어 체커) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1316
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통핵 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int groupWordCnt = 0;

		for (int i = 0; i < N; i++) {
			char[] wordChars = br.readLine().toCharArray();

			// 알파벳 등장 확인 배열
			boolean[] isChecked = new boolean[26];

			// 결과 값 저장 변수
			boolean isGroupWord = true;

			// 이전 문자열 저장 변수
			char beforeChar = ' ';

			for (char c : wordChars) {
				// 영소문자 아스키 코드는 97(a)번 부터 시작
				int n = (int) c - 97;

				// 처음 등장한 알파벳이거나, 이미 등장했지만 이전 문자열과 같은 경우
				if (!isChecked[n] || c == beforeChar) {
					isChecked[n] = true;
				}

				// 그룹 단어가 아닌 경우
				else {
					isGroupWord = false;

					break;
				}

				// 현재 문자열을 이전 문자열로 저장
				beforeChar = c;
			}

			if (isGroupWord) {
				groupWordCnt++;
			}
		}

		br.close();

		// 결과 값 출력
		System.out.println(groupWordCnt);
	}
}