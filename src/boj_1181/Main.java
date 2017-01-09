package boj_1181;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

/**
 * 백준 온라인 저지 1181번 (단어 정렬) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1181
 * @author devetude
 */
public class Main {
	// 개행 문자열 상수
	private static final String NEW_LINE = "\n";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 단어 해쉬셋 초기화 (입력 단어간 중복 제거용)
		HashSet<String> wordHashSet = new HashSet<>();

		for (int i = 0; i < N; i++) {
			wordHashSet.add(br.readLine());
		}

		br.close();

		// 단어 해쉬셋을 단어 배열로 변환
		String[] words = wordHashSet.toArray(new String[wordHashSet.size()]);

		// 문제의 조건에 맞게 단어 정렬
		Arrays.sort(words, new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				// 길이가 짧은 것을 앞으로
				if (str1.length() < str2.length()) {
					return -1;
				}

				// 길이가 긴 것을 뒤로
				else if (str1.length() > str2.length()) {
					return 1;
				}

				// 그 외 길이가 같은 경우 사전순으로
				return str1.compareTo(str2);
			}
		});

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (String word : words) {
			sb.append(word).append(NEW_LINE);
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}