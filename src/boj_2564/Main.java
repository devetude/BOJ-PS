package boj_2564;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2564번 (경비원) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/2564
 * @author devetude
 */
public class Main {
	// 4방위 상수
	private static final int NORTH = 1;
	private static final int SOUTH = 2;
	private static final int WEST = 3;
	private static final int EAST = 4;

	// 블록 너비, 높이 변수
	private static int width;
	private static int height;

	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// 블록의 크기를 받음
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());

		// 상점의 갯수를 받음
		int N = Integer.parseInt(br.readLine());
		Position[] positions = new Position[N];

		// 상점 입력 값을 받음
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			positions[i] = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		// 동근이의 입력 값을 받음
		st = new StringTokenizer(br.readLine(), " ");
		Position myPosition = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

		// 동근이와 상점간의 최단거리의 합을 구함
		int shortestDistanceSum = 0;

		for (Position position : positions) {
			shortestDistanceSum += myPosition.getShortestDistance(position);
		}

		// 결과 값 출력
		System.out.println(shortestDistanceSum);
	}

	/**
	 * 좌표 이너 클래스
	 * 
	 * @author devetude
	 */
	private static class Position {
		public int dir;
		public int v;

		/**
		 * 생성자
		 * 
		 * @param dir
		 * @param v
		 */
		public Position(int dir, int v) {
			this.dir = dir;
			this.v = v;
		}

		/**
		 * 내 좌표와 다른 한 좌표간의 최단거리를 구하는 메소드
		 * 
		 * @param anotherPosition
		 * @return
		 */
		public int getShortestDistance(Position anotherPosition) {
			// 같은 방향에 있을 경우
			if (this.dir == anotherPosition.dir) {
				return Math.abs(this.v - anotherPosition.v);
			}

			// 북, 남 또는 남, 북으로 마주보고 있는 경우
			// (왼쪽으로 돌아가는 경우와 오른쪽으로 돌아가는 경우 중 짧은 쪽과 블록의 높이를 더함)
			else if ((this.dir == NORTH && anotherPosition.dir == SOUTH)
					|| this.dir == SOUTH && anotherPosition.dir == NORTH) {
				return Math.min(this.v + anotherPosition.v, width - this.v + width - anotherPosition.v) + height;
			}

			// 동, 서 또는 서, 동으로 마주보고 있는 경우
			// (위쪽으로 돌아가는 경우와 아랫쪽으로 돌아가는 경우 중 짧은 쪽과 블록의 너비를 더함)
			else if ((this.dir == EAST && anotherPosition.dir == WEST)
					|| this.dir == WEST && anotherPosition.dir == EAST) {
				return Math.min(this.v + anotherPosition.v, height - this.v + height - anotherPosition.v) + width;
			}

			// 내 위치를 기준으로 왼변 또는 오른변에 있는 경우
			else {
				if (this.dir == NORTH) {
					if (anotherPosition.dir == EAST) {
						return width - this.v + anotherPosition.v;
					}

					else {
						return this.v + anotherPosition.v;
					}
				}

				else if (this.dir == SOUTH) {
					if (anotherPosition.dir == EAST) {
						return width - this.v + height - anotherPosition.v;
					}

					else {
						return this.v + height - anotherPosition.v;
					}
				}

				else if (this.dir == EAST) {
					if (anotherPosition.dir == NORTH) {
						return width - anotherPosition.v + this.v;
					}

					else {
						return width - anotherPosition.v + height - this.v;
					}
				}

				else {
					if (anotherPosition.dir == NORTH) {
						return anotherPosition.v + this.v;
					}

					else {
						return anotherPosition.v + height - this.v;
					}
				}
			}
		}
	}
}