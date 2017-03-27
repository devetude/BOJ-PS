package boj_1431;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 백준 온라인 저지 1431번 (시리얼 번호) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1431
 * @author devetude
 */
public class Main {
	// 개행 문자 상수
	private static final char NEW_LINE = '\n';

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 문자열 저장 배열 초기화
		String[] strs = new String[N];

		for (int i = 0; i < N; i++) {
			strs[i] = br.readLine();
		}

		br.close();

		// 문제의 조건에 맞게 문자열 배열을 정렬
		Arrays.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				int s1Len = s1.length();
				int s2Len = s2.length();

				// 문자열의 길이가 짧은 경우 앞으로
				if (s1Len < s2Len) {
					return -1;
				}

				else if (s1Len == s2Len) {
					int s1Sum = 0;

					for (int i = 0; i < s1Len; i++) {
						int num = Character.getNumericValue(s1.charAt(i));

						if (0 <= num && num <= 9) {
							s1Sum += num;
						}
					}

					int s2Sum = 0;

					for (int i = 0; i < s2Len; i++) {
						int num = Character.getNumericValue(s2.charAt(i));

						if (0 <= num && num <= 9) {
							s2Sum += num;
						}
					}

					// 숫자의 합이 작은 경우 앞으로
					if (s1Sum < s2Sum) {
						return -1;
					}

					else if (s1Sum == s2Sum) {
						// 사전순으로
						return s1.compareTo(s2);
					}

					else {
						return 1;
					}
				}

				else {
					return 1;
				}
			}
		});

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (String str : strs) {
			sb.append(str).append(NEW_LINE);
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}