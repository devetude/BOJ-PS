package boj_2455;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2455번 (지능형 기차) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/2455
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int maxCounts = 0;
		int currentCounts = 0;

		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			// 현재 타고 있는 사람 수 계산
			currentCounts += (-Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));

			// 현재 타고 있는 사람 수가 최대 인원인지 비교
			if (maxCounts < currentCounts) {
				maxCounts = currentCounts;
			}
		}

		br.close();

		// 결과 값 출력
		System.out.println(maxCounts);
	}
}