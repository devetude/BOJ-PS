package boj_11651;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 11651번 (좌표 정렬하기 2) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/11651
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		// 이유 : Scanner를 통해 입력을 받으면 실행속도 느림
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Pos> posList = new ArrayList<>();

		// 좌표를 받아서 Pos 객체로 만들어서 배열 리스트에 저장
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			posList.add(new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		br.close();

		// 객체간의 정렬
		Collections.sort(posList, Pos.Comparator);

		// 버퍼를 통해 결과 값을 만듬
		// 이유 : System.out.println을 여러번 이용하면 실행속도 느림
		StringBuilder sb = new StringBuilder();

		for (Pos pos : posList) {
			sb.append(pos.x).append(" ").append(pos.y).append("\n");
		}

		// 결과값 한꺼번에 출력
		System.out.print(sb.toString());
	}

	/**
	 * 좌표 값 저장 이너 클래스
	 * 
	 * @author devetude
	 */
	private static class Pos {
		private int x;
		private int y;

		/**
		 * 생성자
		 * 
		 * @param x
		 * @param y
		 */
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		/**
		 * 좌표 값 비교 이너 클래스
		 */
		private static Comparator<Pos> Comparator = new Comparator<Pos>() {
			@Override
			public int compare(Pos p1, Pos p2) {
				// 각 객체의 y좌표 먼저 비교
				if (p1.y < p2.y) {
					return -1;
				}

				// y좌표 값이 같은 경우
				else if (p1.y == p2.y) {
					// x좌표 값 비교
					if (p1.x < p2.x) {
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