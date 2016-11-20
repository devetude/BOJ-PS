package boj_13411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 13411번 (하늘에서 정의가 빗발친다!) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/13411
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Robot[] robots = new Robot[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			robots[i] = new Robot(i + 1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}

		br.close();

		// 로봇 객체들을 정렬
		Arrays.sort(robots, Robot.comparator);

		// 버퍼를 이용해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (Robot r : robots) {
			sb.append(r.idx).append("\n");
		}

		// 결과 값 출력
		System.out.println(sb.toString());
	}

	/**
	 * 로봇 이너 클래스
	 * 
	 * @author devetude
	 */
	private static class Robot {
		// 규현이의 x, y 좌표 상수
		private static final int KYUHYUN_X_POS = 0;
		private static final int KYUHYUN_Y_POS = 0;

		// 로봇의 멤버 변수 (인덱스, x 좌표, y 좌표, 미사일 속력, 도달 시간)
		private int idx;
		private int x;
		private int y;
		private int v;
		private double reachTime;

		/**
		 * 생성자
		 * 
		 * @param idx
		 * @param x
		 * @param y
		 * @param v
		 */
		public Robot(int idx, int x, int y, int v) {
			this.idx = idx;
			this.x = x;
			this.y = y;
			this.v = v;

			// 두 점 사이의 거리 공식을 이용하여 규현이와 로봇 사이의 거리를 구함
			// d = sqrt((x1 - x2)^2 + (y1 - y2)^2)
			double distance = Math.sqrt(Math.pow(this.x - KYUHYUN_X_POS, 2) + Math.pow(this.y - KYUHYUN_Y_POS, 2));

			// 시간, 거리 속력 공식을 이용하여 도달 시간을 구함
			// 시간 = 거리 / 속력
			this.reachTime = distance / v;
		}

		// 비교 객체 변수
		private static Comparator<Robot> comparator = new Comparator<Main.Robot>() {
			@Override
			public int compare(Robot r1, Robot r2) {
				// 도달 시간이 작을수록 앞으로
				if (r1.reachTime < r2.reachTime) {
					return -1;
				}

				// 도달 시간이 같은 경우
				else if (r1.reachTime == r2.reachTime) {
					// 인덱스가 작을수록 앞으로
					if (r1.idx < r2.idx) {
						return -1;
					}

					else {
						return 1;
					}
				}

				else {
					return 1;
				}
			}
		};
	}
}