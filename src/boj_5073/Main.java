package boj_5073;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 5073번 (삼각형과 세 변) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/5073
 * @author devetude
 */
public class Main {
	// 문자열 상수
	private static final String EOF = "0 0 0";
	private static final String EQU = "Equilateral";
	private static final String ISO = "Isosceles";
	private static final String SCA = "Scalene";
	private static final String INV = "Invalid";
	private static final String NEW_LINE = "\n";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		while (!(line = br.readLine()).equals(EOF)) {
			StringTokenizer st = new StringTokenizer(line, " ");
			int[] lines = new int[3];

			for (int i = 0; i < 3; i++) {
				lines[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(lines);

			// 삼각형이 될 수 없는 경우
			if (lines[2] >= lines[0] + lines[1]) {
				sb.append(INV);
			}

			// 정삼각형인 경우
			else if (lines[0] == lines[1] && lines[1] == lines[2] && lines[0] == lines[2]) {
				sb.append(EQU);
			}

			// 모든 변의 길이가 다른 삼각형인 경우
			else if (lines[0] != lines[1] && lines[1] != lines[2] && lines[0] != lines[2]) {
				sb.append(SCA);
			}

			// 이등변 삼각형인 경우
			else {
				sb.append(ISO);
			}

			sb.append(NEW_LINE);
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}