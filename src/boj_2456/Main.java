package boj_2456;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2456번 (나는 학급회장이다) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/2456
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 3명의 후보자 객체 초기화
		Candidate[] candidates = new Candidate[3];

		for (int i = 0; i < 3; i++) {
			candidates[i] = new Candidate(i + 1);
		}

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			// 3명의 후보자들에게 점수를 부여
			for (int j = 0; j < 3; j++) {
				candidates[j].addPoint(Integer.parseInt(st.nextToken()));
			}
		}

		br.close();

		// 점수를 내림차순으로 정렬
		Arrays.sort(candidates, Candidate.comparator);

		// 버퍼를 이용해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		// 1등과 2등이 점수 구성이 모두 같아서 승부를 낼 수 없는 경우를 조사
		if (candidates[0].threePointCounts == candidates[1].threePointCounts
				&& candidates[0].twoPointCounts == candidates[1].twoPointCounts) {
			sb.append(0).append(" ").append(candidates[0].totalPoints);
		}

		// 승부가 난 경우
		else {
			sb.append(candidates[0].index).append(" ").append(candidates[0].totalPoints);
		}

		// 결과 값 출력
		System.out.println(sb.toString());
	}

	/**
	 * 후보자 이너 클래스
	 * 
	 * @author devetude
	 */
	private static class Candidate {
		public int index;
		public int twoPointCounts;
		public int threePointCounts;
		public int totalPoints;

		/**
		 * 생성자
		 * 
		 * @param index
		 */
		public Candidate(int index) {
			this.index = index;
			this.twoPointCounts = 0;
			this.threePointCounts = 0;
			this.totalPoints = 0;
		}

		/**
		 * 점수를 추가하는 메소드
		 * 
		 * @param point
		 */
		private void addPoint(int point) {
			if (point == 3) {
				this.threePointCounts++;
			}

			else if (point == 2) {
				this.twoPointCounts++;
			}

			this.totalPoints += point;
		}

		/**
		 * 정렬 객체
		 */
		public static Comparator<Candidate> comparator = new Comparator<Candidate>() {
			@Override
			public int compare(Candidate c1, Candidate c2) {
				// 종합점수가 높은 후보자가 앞으로
				if (c1.totalPoints > c2.totalPoints) {
					return -1;
				}

				else if (c1.totalPoints < c2.totalPoints) {
					return 1;
				}

				else {
					// 3점을 많이 받은 후보자가 앞으로
					if (c1.threePointCounts > c2.threePointCounts) {
						return -1;
					}

					else if (c1.threePointCounts < c2.threePointCounts) {
						return 1;
					}

					else {
						// 2점을 많이 받은 후보자가 앞으로
						if (c1.twoPointCounts > c2.twoPointCounts) {
							return -1;
						}

						else if (c1.twoPointCounts < c2.twoPointCounts) {
							return 1;
						}

						else {
							// 후보를 정하지 못함
							return 0;
						}
					}
				}
			}
		};
	}
}