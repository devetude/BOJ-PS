package boj_2246;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2246번 (콘도 선정) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2246
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Condo[] condos = new Condo[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			condos[i] = new Condo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		br.close();

		// 후보 콘도 갯수 저장 변수 초기화
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			int j = 0;

			for (; j < N; j++) {
				// 비교하려는 콘도의 인덱스와 기준 콘도 인덱스가 같은 경우
				if (i == j) {
					continue;
				}

				// 문제의 조건에 부합하지 않는 경우 루프를 탈출
				if (condos[i].distance > condos[j].distance && condos[i].cost >= condos[j].cost
						|| condos[i].cost > condos[j].cost && condos[i].distance >= condos[j].distance) {
					break;
				}
			}

			// 루프를 끝까지 실행했을 경우
			if (j == N) {
				// 후보 콘도 갯수 1 증가
				cnt++;
			}
		}

		// 결과 값 출력
		System.out.println(cnt);
	}

	/**
	 * 콘도 이너 클래스
	 * 
	 * @author devetude
	 */
	private static class Condo {
		public int distance;
		public int cost;

		/**
		 * 생성자
		 * 
		 * @param distance
		 * @param cost
		 */
		public Condo(int distance, int cost) {
			this.distance = distance;
			this.cost = cost;
		}
	}
}