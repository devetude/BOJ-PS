package boj_8979;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 8979번 (올림픽) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/8979
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Nation[] nations = new Nation[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			nations[i] = new Nation(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		br.close();

		// 국가별 메달수를 기준으로 정렬
		Arrays.sort(nations, Nation.comparator);

		MAIN_LOOP: for (int i = 0; i < N; i++) {
			// 찾으려는 국가가 나왔을 경우 등수를 출력
			if (nations[i].idx == K) {
				System.out.println(i + 1);

				break;
			}

			// 같은 등수가 있는지 루프를 돌며 확인
			int sameRankCnt = 0;

			for (int j = i; j < N; j++) {
				if (j != N - 1 && nations[j].gCnt == nations[j + 1].gCnt && nations[j].sCnt == nations[j + 1].sCnt
						&& nations[j].bCnt == nations[j + 1].bCnt) {
					// 찾으려는 국가가 나왔을 경우 등수를 출력
					if (nations[j + 1].idx == K) {
						System.out.println(i + 1);

						break MAIN_LOOP;
					}

					sameRankCnt++;
				}

				else {
					i += sameRankCnt;

					break;
				}
			}
		}
	}

	/**
	 * 국가 이너 클래스
	 * 
	 * @author devetude
	 */
	private static class Nation {
		public int idx;
		public int gCnt;
		public int sCnt;
		public int bCnt;

		/**
		 * 생성자
		 * 
		 * @param idx
		 * @param gCnt
		 * @param sCnt
		 * @param bCnt
		 */
		public Nation(int idx, int gCnt, int sCnt, int bCnt) {
			this.idx = idx;
			this.gCnt = gCnt;
			this.sCnt = sCnt;
			this.bCnt = bCnt;
		}

		// 비교 객체 변수
		private static Comparator<Nation> comparator = new Comparator<Main.Nation>() {
			@Override
			public int compare(Nation n1, Nation n2) {
				// 금메달이 많은 경우 앞으로
				if (n1.gCnt > n2.gCnt) {
					return -1;
				}

				else if (n1.gCnt == n2.gCnt) {
					// 은메달이 많은 경우 앞으로
					if (n1.sCnt > n2.sCnt) {
						return -1;
					}

					else if (n1.sCnt == n2.sCnt) {
						// 동메달이 많은 경우 앞으로
						if (n1.bCnt > n2.bCnt) {
							return -1;
						}

						else if (n1.bCnt == n2.bCnt) {
							return 0;
						}

						else {
							return 1;
						}
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