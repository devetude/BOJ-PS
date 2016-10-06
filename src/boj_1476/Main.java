package boj_1476;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1476번 (날짜 계산) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/1476
 * @author devetude
 */
public class Main {
	public static void main(String[] args) throws Exception {
		// 버퍼를 이용해 입력을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();

		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 날짜 계산 (역으로 1 1 1 까지 얼마나 숫자가 증가하는지 확인)
		int years = 1;

		while (true) {
			if (E == 1 && S == 1 && M == 1) {
				break;
			}

			years++;
			E--;
			S--;
			M--;

			if (E < 1) {
				E = 15;
			}

			if (S < 1) {
				S = 28;
			}

			if (M < 1) {
				M = 19;
			}
		}

		// 결과 값 출력
		System.out.println(years);
	}
}