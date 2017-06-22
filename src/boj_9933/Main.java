package boj_9933;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 9933번 (민균이의 비밀번호) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/9933
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] words = new String[N];

		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}

		br.close();

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		MAIN_LOOP: for (int i = 0; i < N; i++) {
			int wordLen = words[i].length();

			// 펠린드롬 여부 검사 변수 초기화
			boolean isPalindrome = true;

			// 팰린드롬 여부 검사
			for (int l = 0; l < wordLen / 2; l++) {
				if (words[i].charAt(l) != words[i].charAt(wordLen - 1 - l)) {
					isPalindrome = false;

					break;
				}
			}

			// 펠린드롬일 경우에만
			if (isPalindrome) {
				sb.append(wordLen).append(" ").append(words[i].charAt(wordLen / 2));

				break;
			}

			for (int j = i + 1; j < N; j++) {
				// 두 문자열의 길이가 같을 경우에만
				if (wordLen == words[j].length()) {
					// 역전 여부 검사 변수 초기화
					boolean isReversed = true;

					// 역전 여부 검사
					for (int k = 0; k < wordLen; k++) {
						if (words[i].charAt(k) != words[j].charAt(wordLen - 1 - k)) {
							isReversed = false;

							break;
						}
					}

					// 역전일 경우에만
					if (isReversed) {
						sb.append(wordLen).append(" ").append(words[i].charAt(wordLen / 2));

						break MAIN_LOOP;
					}
				}
			}
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}