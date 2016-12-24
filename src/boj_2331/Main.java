package boj_2331;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2331번 (반복수열) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2331
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		br.close();

		// 수열을 저장 할 배열리스트 초기화
		ArrayList<Integer> numList = new ArrayList<Integer>();
		numList.add(A);

		// 사이클 시작 인덱스를 저장 변수
		int cycleStartingIdx = 0;

		while (true) {
			char[] aChars = String.valueOf(numList.get(numList.size() - 1)).toCharArray();
			int sum = 0;

			// 각 자릿수의 P 제곱 형태의 합을 구해서 다음 수열을 만듬
			for (char aChar : aChars) {
				sum += (int) Math.pow(Character.getNumericValue(aChar), P);
			}

			// 이미 배열리스트에 있는 값이라면 사이클이 생긴 것이므로 종료
			if (numList.contains(sum)) {
				cycleStartingIdx = numList.indexOf(sum);

				break;
			}

			numList.add(sum);
		}

		// 결과 값 출력
		System.out.println(cycleStartingIdx);
	}
}