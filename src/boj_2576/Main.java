package boj_2576;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 백준 온라인 저지 2576번 (홀수) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/2576
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> oddArrayList = new ArrayList<>();
		int oddSum = 0;

		for (int i = 0; i < 7; i++) {
			int input = Integer.parseInt(br.readLine());

			// 홀수라면 배열리스트에 저장하고 합산에 추가
			if (input % 2 == 1) {
				oddArrayList.add(input);
				oddSum += input;
			}
		}

		br.close();

		// 홀수 배열리스트를 오름차순으로 정렬
		Collections.sort(oddArrayList);

		// 홀수가 존재 할 경우 홀수들의 합과 가장 작은 값을 출력
		if (oddArrayList.size() != 0) {
			System.out.println(oddSum);
			System.out.println(oddArrayList.get(0));
		}

		// 홀수가 존재하지 않을 경우
		else {
			System.out.println(-1);
		}
	}
}