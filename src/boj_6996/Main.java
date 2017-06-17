package boj_6996;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 6996번 (애너그램) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/6996
 * @author devetude
 */
public class Main {
	// 문자열 상수
	private static final String SPACE = " ";
	private static final String AND = " & ";
	private static final String ARE_ANAGRAM = " are anagrams.";
	private static final String ARE_NOT_ANAGRAM = " are NOT anagrams.";
	private static final String NEW_LINE = "\n";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);
			String str1 = st.nextToken();
			String str2 = st.nextToken();

			sb.append(str1).append(AND).append(str2);

			if (isAnagram(str1, str2)) {
				sb.append(ARE_ANAGRAM);
			}

			else {
				sb.append(ARE_NOT_ANAGRAM);
			}

			sb.append(NEW_LINE);
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}

	/**
	 * 애너그램 판별 메소드
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	private static boolean isAnagram(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}

		byte[] str1CharCnt = getAlphabetCntArr(str1);
		byte[] str2CharCnt = getAlphabetCntArr(str2);

		for (int i = 0; i < 26; i++) {
			if (str1CharCnt[i] != str2CharCnt[i]) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 문자열의 각 알파벳 소문자의 갯수 배열을 구하는 메소드
	 * 
	 * @param str
	 * @return
	 */
	private static byte[] getAlphabetCntArr(String str) {
		byte[] charCnt = new byte[26];
		int strLen = str.length();

		for (int i = 0; i < strLen; i++) {
			charCnt[str.charAt(i) - 97]++;
		}

		return charCnt;
	}
}