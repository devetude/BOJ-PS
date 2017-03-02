package boj_1544;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * 백준 온라인 저지 1544번 (사이클 단어) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1544
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

		// 서로 다른 단어 갯수 저장 변수
		int cnt = 0;

		// 루프를 돌며 단어의 갯수를 셈
		for (int i = 0; i < N; i++) {
			// 중복된 단어가 아닌 경우
			if (words[i] != null) {
				int len = words[i].length();

				// 버퍼를 이용하여 단어의 글자들을 회전하여 만들 수 있는 경우를 모두 해시셋에 저장
				StringBuilder sb = new StringBuilder();
				sb.append(words[i]).append(words[i]);

				// 단어의 글자들을 회전하여 만들 수 있는 단어 저장 해시셋 초기화
				HashSet<String> hashSet = new HashSet<>();
				hashSet.add(words[i]);

				while (len-- > 0) {
					sb.append(sb.charAt(0)).deleteCharAt(0);
					hashSet.add(sb.toString());
				}

				// 그 이후 단어 중에서 해시셋에 포함되어있는 중복되는 단어들을 null로 변경
				for (int j = i + 1; j < N; j++) {
					if (words[j] != null && hashSet.contains(words[j])) {
						words[j] = null;
					}
				}

				// 단어 갯수 1 증가
				cnt++;
			}
		}

		// 결과 값 출력
		System.out.println(cnt);
	}
}