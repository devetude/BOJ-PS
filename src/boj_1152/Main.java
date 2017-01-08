package boj_1152;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 1152번 (단어의 개수) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1152
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 단어를 추출 (문장 앞 뒷 공백제거 -> 여러개의 공백을 1개의 띄어쓰기로 변환 -> 띄어쓰기로 단어 분리)
		String[] wordStrs = br.readLine().trim().replaceAll("\\s+", " ").split(" ");

		br.close();

		// 공백 단어인 경우 0 출력
		if (wordStrs[0].length() == 0) {
			System.out.println(0);
		}

		else {
			System.out.println(wordStrs.length);
		}
	}
}