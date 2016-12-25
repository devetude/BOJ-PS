package boj_2941;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 2941번 (크로아티아 알파벳) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2941
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] chars = br.readLine().toCharArray();
		br.close();

		// 결과 값 저장 변수
		int res = 0;

		// 루프를 돌며 크로아티아 알파벳의 갯수를 구함
		for (int i = 0; i < chars.length; i++) {
			res++;

			if (chars[i] == 'c') {
				if (i != chars.length - 1 && (chars[i + 1] == '=' || chars[i + 1] == '-')) {
					i++;
				}
			}

			else if (chars[i] == 'd') {
				if (i != chars.length - 2 && chars[i + 1] == 'z' && chars[i + 2] == '=') {
					i += 2;
				}

				else if (i != chars.length - 1 && chars[i + 1] == '-') {
					i++;
				}
			}

			else if (chars[i] == 'l') {
				if (i != chars.length - 1 && chars[i + 1] == 'j') {
					i++;
				}
			}

			else if (chars[i] == 'n') {
				if (i != chars.length - 1 && chars[i + 1] == 'j') {
					i++;
				}
			}

			else if (chars[i] == 's') {
				if (i != chars.length - 1 && chars[i + 1] == '=') {
					i++;
				}
			}

			else if (chars[i] == 'z') {
				if (i != chars.length - 1 && chars[i + 1] == '=') {
					i++;
				}
			}
		}

		// 결과 값 출력
		System.out.println(res);
	}
}