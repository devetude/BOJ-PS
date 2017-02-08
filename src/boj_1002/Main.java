package boj_1002;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1002번 (터렛) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1002
 * @author devetude
 */
public class Main {
	// 개행 문자열 상수
	private static final String NEW_LINE = "\n";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		while (T-- != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			Circle[] circles = new Circle[2];

			for (int i = 0; i < 2; i++) {
				circles[i] = new Circle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
			}

			// 반지름이 작은 원부터 큰 원 순서대로 정렬
			Arrays.sort(circles, Circle.comparator);

			// 두 원의 중심점 사이 거리를 구함
			double distance = Math
					.sqrt(Math.pow(circles[0].x - circles[1].x, 2) + Math.pow(circles[0].y - circles[1].y, 2));

			// 교점이 무수히 많이 생기는 경우 (두 원이 완전히 일치)
			if (distance == 0 && circles[0].r == circles[1].r) {
				sb.append(-1);
			}

			// 두 교점이 생기는 경우
			else if (circles[1].r - circles[0].r < distance && distance < circles[1].r + circles[0].r) {
				sb.append(2);
			}

			// 한 교점이 생기는 경우 (내접, 외접)
			else if (circles[1].r - circles[0].r == distance || circles[1].r + circles[0].r == distance) {
				sb.append(1);
			}

			// 교점이 생기지 않는 경우 (두 원이 완전이 떨어져 있거나, 큰 원 안에 작은 원이 있거나, 동심원)
			else if (circles[1].r + circles[0].r < distance || distance < circles[1].r - circles[0].r
					|| (distance == 0 && circles[0].r != circles[1].r)) {
				sb.append(0);
			}

			sb.append(NEW_LINE);
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}

	/**
	 * 원 이너 클래스
	 * 
	 * @author devetude
	 */
	private static class Circle {
		public int x;
		public int y;
		public int r;

		/**
		 * 생성자
		 * 
		 * @param x
		 * @param y
		 * @param r
		 */
		public Circle(int x, int y, int r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}

		// 비교 객체 변수
		private static Comparator<Circle> comparator = new Comparator<Main.Circle>() {
			@Override
			public int compare(Circle c1, Circle c2) {
				// 반지름의 길이가 작으면 앞으로
				if (c1.r < c2.r) {
					return -1;
				}

				// 같으면 그대로
				else if (c1.r == c2.r) {
					return 0;
				}

				// 크면 뒤로
				else {
					return 1;
				}
			}
		};
	}
}