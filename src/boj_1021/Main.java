package boj_1021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 번 () 문제풀이
 *
 * @see https://www.acmicpc.net/problem/
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");

		// 찾으려는 수 저장 배열 초기화
		int[] items = new int[M];

		for (int i = 0; i < M; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}

		br.close();

		// 왼쪽, 오른쪽으로 돌리는 덱 초기화
		ArrayDeque<Integer> rotateLeftDeque = new ArrayDeque<>(N);
		ArrayDeque<Integer> rotateRightDeque = new ArrayDeque<>(N);

		for (int i = 1; i <= N; i++) {
			rotateLeftDeque.offerLast(i);
			rotateRightDeque.offerLast(i);
		}

		// 연산 횟수 저장 변수 초기화
		int cnt = 0;

		// 루프를 돌며 덱을 돌려보면서 연산이 적은 경우를 찾아나감
		for (int item : items) {
			int dequeSize = rotateLeftDeque.size();

			for (int i = 0; i < dequeSize; i++) {
				// 왼쪽으로 돌리는 경우
				int leftFront = rotateLeftDeque.pollFirst();

				// 찾는 값이 맞으면
				if (leftFront == item) {
					// 연산 횟수 추가 후 오른쪽으로 돌리는 덱을 현재 상태로 일치시킴
					cnt += i;
					rotateRightDeque = rotateLeftDeque.clone();

					break;
				}

				// 오른쪽으로 돌리는 경우
				int rightFront = rotateRightDeque.pollLast();

				// 찾는 값이 맞으면
				if (rightFront == item) {
					// 연산 횟수 추가 후 왼쪽으로 돌리는 덱을 현재 상태로 일치시킴
					cnt += i + 1;
					rotateLeftDeque = rotateRightDeque.clone();

					break;
				}

				// 두 경우가 모두 일치하지 않으면 각각 방향으로 덱을 돌림
				rotateLeftDeque.offerLast(leftFront);
				rotateRightDeque.offerFirst(rightFront);
			}
		}

		// 결과 값 출력
		System.out.println(cnt);
	}
}