package boj_11003;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 11003번 (최소값 찾기) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/11003
 * @author devetude
 */
public class Main {
	// 공백 문자열 상수
	private static final String SPACE = " ";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), SPACE);

		br.close();

		// 아이템 저장 덱 객체 변수 초기화
		Deque<Item> deque = new LinkedList<>();

		// 버퍼를 통해 결과 값 출력
		// cf) 빌더를 사용하면 너무 긴 값을 저장하기 때문에 런타임 에러 발생 5억건씩 끊어서 저장하고 출력하는 방식은 가능
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 1; i <= N; i++) {
			int val = Integer.parseInt(st.nextToken());

			// 윈도우를 벗어난 아이템 제거
			while (!deque.isEmpty() && deque.peekFirst().idx <= i - L)
				deque.pollFirst();

			// 새로 넣을 값보다 작은 값을 가진 아이템 제거
			while (!deque.isEmpty() && deque.peekLast().val >= val)
				deque.pollLast();

			deque.offerLast(new Item(i, val));

			bw.write(deque.peekFirst().val + SPACE);
		}

		bw.flush();
		bw.close();
	}

	/**
	 * 아이템 클래스
	 * 
	 * @author devetude
	 */
	private static class Item {
		public int idx;
		public int val;

		/**
		 * 생성자
		 * 
		 * @param idx
		 * @param val
		 */
		public Item(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
	}
}