package boj_2490;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2490번 (윷놀이) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/2490
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			// 등이 나오는 경우를 세기 위한 변수
			int backCounts = 0;

			for (int j = 0; j < 4; j++) {
				// 등의 갯수를 셈
				if (Integer.parseInt(st.nextToken()) == 1) {
					backCounts++;
				}
			}

			// 등의 갯수에 따라 버퍼에 결과 값 저장
			switch (backCounts) {
			case 0:
				sb.append("D\n");
				break;

			case 1:
				sb.append("C\n");
				break;

			case 2:
				sb.append("B\n");
				break;

			case 3:
				sb.append("A\n");
				break;

			case 4:
				sb.append("E\n");
				break;
			}
		}

		br.close();

		// 결과 값 출력
		System.out.println(sb.toString());
	}
}