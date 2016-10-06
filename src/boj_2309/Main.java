package boj_2309;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 온라인 저지 2309번 (일곱 난쟁이) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/2309
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] statures = new int[9];
		int statureSum = 0;

		for (int i = 0; i < 9; i++) {
			int stature = Integer.parseInt(br.readLine());
			statureSum += stature;
			statures[i] = stature;
		}

		br.close();

		// 키를 오름차순으로 정렬
		Arrays.sort(statures);

		// 일곱 난쟁이가 아닌 2명 때문에 100보다 커진 키의 차이 값을 구함
		int statureDiff = statureSum - 100;

		// 9명 중 2명을 골라 키의 차이 값과 일치 할 때 까지 검색
		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				// 키의 차이 값이 일치 할 경우
				if (statures[i] + statures[j] == statureDiff && i != j && statures[i] != 0 && statures[j] != 0) {
					// 두 난쟁이의 키 값을 0으로 바꿈
					statures[i] = 0;
					statures[j] = 0;

					break;
				}
			}
		}

		// 버퍼를 이용해 출력 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (int stature : statures) {
			// 일곱 난쟁이의 키만 출력 값에 추가
			if (stature != 0) {
				sb.append(stature).append("\n");
			}
		}

		// 출력 값을 한꺼번에 출력
		System.out.println(sb.toString());
	}
}