package boj_2477;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2477번 (참외밭) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/2477
 * @author devetude
 */
public class Main {
	private static final int EAST = 1;
	private static final int WEST = 2;
	private static final int SOUTH = 3;
	private static final int NORTH = 4;
	private static Queue<Side> que = new LinkedList<>();

	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int[] directions = new int[5];

		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int direction = Integer.parseInt(st.nextToken());

			// 사방위의 갯수를 배열에 저장
			directions[direction]++;

			// 큐에 각 변에 대한 정보 저장 (방위, 길이)
			que.offer(new Side(direction, Integer.parseInt(st.nextToken())));
		}

		br.close();

		// 경우1 : ┓ 모양인 경우
		if (directions[WEST] == 1 && directions[NORTH] == 1) {
			System.out.println(calcSize(NORTH) * K);
		}

		// 경우2 : ┏ 모양인 경우
		else if (directions[WEST] == 1 && directions[SOUTH] == 1) {
			System.out.println(calcSize(WEST) * K);
		}

		// 경우3 : ┛ 모양인 경우
		else if (directions[EAST] == 1 && directions[NORTH] == 1) {
			System.out.println(calcSize(EAST) * K);
		}

		// 경우4 : ┗ 모양인 경우
		else {
			System.out.println(calcSize(SOUTH) * K);
		}
	}

	/**
	 * 각 변의 정보를 저장하기 위한 이너 클래스
	 * 
	 * @author devetude
	 */
	private static class Side {
		public int direction;
		public int length;

		/**
		 * 생성자
		 * 
		 * @param direction
		 * @param length
		 */
		public Side(int direction, int length) {
			this.direction = direction;
			this.length = length;
		}
	}

	/**
	 * 밭의 면적을 계산하는 메소드
	 * 
	 * @param startDirection
	 * @return
	 */
	private static int calcSize(int startDirection) {
		// 지정한 시작 방위가 나올 때 까지 큐의 맨 앞 엘리먼트를 뒤로 보냄
		while (true) {
			if (que.peek().direction == startDirection) {
				break;
			}

			else {
				que.offer(que.poll());
			}
		}

		// 가장 긴 두변을 가져옴
		int longestSide1 = que.poll().length;
		int longestSide2 = que.poll().length;

		// 쓸모없는 변은 지나침
		que.poll();

		// 결과 리턴 (가장 긴 두변의 곱 - 구멍난 곳의 두변의 곱)
		return (longestSide1 * longestSide2 - que.poll().length * que.poll().length);
	}
}