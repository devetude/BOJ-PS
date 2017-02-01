package boj_2822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 백준 온라인 저지 2822번 (점수 계산) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2822
 * @author devetude
 */
public class Main {
	// 공백 문자열 상수
	private static final String SPACE = " ";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Problem[] problems = new Problem[8];

		for (int i = 0; i < 8; i++) {
			problems[i] = new Problem(i, Integer.parseInt(br.readLine().trim()));
		}

		br.close();

		// 점수를 기준으로 내림차순으로 정렬
		Arrays.sort(problems, Problem.comparator2Score);

		// 상위 점수 5개를 인덱스를 기준으로 오름차순으로 정렬
		Arrays.sort(problems, 0, 5, Problem.comparator2Idx);

		// 버퍼를 이용해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		// 총점 저장 변수
		int sum = 0;

		for (int i = 0; i < 5; i++) {
			sb.append(problems[i].getIdx() + 1).append(SPACE);
			sum += problems[i].getScore();
		}

		sb.insert(0, "\n");
		sb.insert(0, sum);

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}

	/**
	 * 문제 이너 클래스
	 * 
	 * @author devetude
	 */
	static class Problem {
		private int idx;
		private int score;

		/**
		 * 생성자
		 * 
		 * @param idx
		 * @param score
		 */
		public Problem(int idx, int score) {
			this.idx = idx;
			this.score = score;
		}

		/**
		 * 인덱스 반환 메소드
		 * 
		 * @return
		 */
		public int getIdx() {
			return this.idx;
		}

		/**
		 * 점수 반환 메소드
		 * 
		 * @return
		 */
		public int getScore() {
			return this.score;
		}

		// 점수 기준 내림차순 객체 변수
		public static Comparator<Problem> comparator2Score = new Comparator<Main.Problem>() {
			@Override
			public int compare(Problem p1, Problem p2) {
				if (p1.score > p2.score) {
					return -1;
				}

				else if (p1.score == p2.score) {
					return 0;
				}

				else {
					return 1;
				}
			}
		};

		// 인덱스 기준 오름차순 객체 변수
		public static Comparator<Problem> comparator2Idx = new Comparator<Main.Problem>() {
			@Override
			public int compare(Problem p1, Problem p2) {
				if (p1.idx < p2.idx) {
					return -1;
				}

				else {
					return 1;
				}
			}
		};
	}
}