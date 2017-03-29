package boj_9205;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 9205번 (맥주 마시면서 걸어가기) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/9205
 * @author devetude
 */
public class Main {
	// 문자열 상수
	private static final String NEW_LINE = "\n";
	private static final String HAPPY = "happy";
	private static final String SAD = "sad";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			// 큐 객체 변수 초기화
			Queue<Point> queue = new LinkedList<>();

			// 상근이의 좌표를 큐에 담음
			queue.offer(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));

			// 편의점, 페스티벌 좌표를 저장 할 배열리스트 객체 변수 초기화
			ArrayList<Point> points = new ArrayList<>(n + 1);

			// 루프를 돌며 편의점 좌표를 배열리스트에 저장
			while (n-- > 0) {
				st = new StringTokenizer(br.readLine(), " ");
				points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			// 페스티벌 좌표를 배열리스트에 저장
			st = new StringTokenizer(br.readLine(), " ");
			Point endingPoint = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			points.add(endingPoint);

			// bfs 실행
			while (!queue.isEmpty()) {
				Point current = queue.poll();

				// 페스티벌 지점에 도착한 경우 탐색 종료
				if (current == endingPoint) {
					break;
				}

				for (Point next : points) {
					// 방문한 지점이 아니면서 1000미터 내에 있는 지점인 경우
					if (!next.isVisited && Math.abs(current.x - next.x) + Math.abs(current.y - next.y) <= 1000) {
						next.isVisited = true;

						queue.offer(next);
					}
				}
			}

			// 페스티벌 지점에 도착한 경우
			if (endingPoint.isVisited) {
				sb.append(HAPPY);
			}

			// 페스티벌 지점에 도착하지 못한 경우
			else {
				sb.append(SAD);
			}

			sb.append(NEW_LINE);
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}

	/**
	 * 좌표 이너 클래스
	 * 
	 * @author devetude
	 */
	private static class Point {
		public int x;
		public int y;
		public boolean isVisited;

		/**
		 * 생성자
		 * 
		 * @param x
		 * @param y
		 */
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}