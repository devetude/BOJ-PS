package boj_2346;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2346번 (풍선 터뜨리기) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2346
 * @author devetude
 */
public class Main {
	// 공백 문자 상수
	private static final char SPACE = ' ';

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		br.close();

		// 풍선 정보 저장 덱 객체 변수 초기화
		Deque<Balloon> deque = new LinkedList<>();

		// 풍선 정보를 덱에 넣음
		for (int i = 1; i <= N; i++) {
			deque.offer(new Balloon(i, Integer.parseInt(st.nextToken())));
		}

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		// 문제의 조건에 따라 풍선을 터트리며 결과 값을 만듬
		while (deque.size() > 1) {
			Balloon balloon = deque.pollFirst();
			sb.append(balloon.idx).append(SPACE);

			if (balloon.val > 0) {
				for (int i = 2; i <= balloon.val; i++) {
					deque.offerLast(deque.pollFirst());
				}
			}

			else {
				for (int i = balloon.val; i < 0; i++) {
					deque.offerFirst(deque.pollLast());
				}
			}
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.append(deque.pollFirst().idx).append(SPACE).toString());
	}

	/**
	 * 풍선 이너 클래스
	 * 
	 * @author devetude
	 */
	private static class Balloon {
		public int idx;
		public int val;

		/**
		 * 생성자
		 * 
		 * @param idx
		 * @param val
		 */
		public Balloon(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
	}
}