package boj_1547;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1547번 (공) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1547
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());

		// 현재 공이 들어있는 컵의 번호 저장 변수 초기화
		int current = 1;

		// 루프를 돌며 공의 위치 변경
		while (M-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());

			if (current == X) {
				current = Y;
			}

			else if (current == Y) {
				current = X;
			}
		}

		br.close();

		// 결과 값 출력
		System.out.println(current);
	}
}