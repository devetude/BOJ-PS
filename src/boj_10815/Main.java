package boj_10815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * 백준 온라인 저지 10815번 (숫자 카드) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/10815
 * @author devetude
 */
public class Main {
	// 존재 유무 판단 상수
	private static final int EXIST = 1;
	private static final int NOT_EXIST = 0;

	// 공백 문자 상수
	private static final char SPACE = ' ';

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 상근이가 가지고 있는 카드를 저장 할 트리셋 초기화
		TreeSet<Integer> treeSet = new TreeSet<>();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			treeSet.add(Integer.parseInt(st.nextToken()));
		}

		int M = Integer.parseInt(br.readLine());

		// 숫자 카드를 저장 할 배열 초기화
		int[] cards = new int[M];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < M; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}

		br.close();

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (int card : cards) {
			if (treeSet.contains(card)) {
				sb.append(EXIST);
			}

			else {
				sb.append(NOT_EXIST);
			}

			sb.append(SPACE);
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}