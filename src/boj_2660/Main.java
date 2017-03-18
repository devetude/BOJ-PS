package boj_2660;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2660번 (회장뽑기) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2660
 * @author devetude
 */
public class Main {
	// 입력 종료 문자열 상수
	private static final String EOF = "-1 -1";

	// 문자 상수
	private static final char SPACE = ' ';
	private static final char NEW_LINE = '\n';

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 가중치 저장 배열 초기화
		int[][] matrix = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i != j) {
					matrix[i][j] = N;
				}
			}
		}

		String line = null;

		while (!(line = br.readLine()).equals(EOF)) {
			StringTokenizer st = new StringTokenizer(line, " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			matrix[a][b] = matrix[b][a] = 1;
		}

		br.close();

		// 플로이드 와샬 알고리즘을 이용하여 회원간 가중치를 최소로 만듬
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
				}
			}
		}

		// 회원 저장 배열 초기화
		User[] users = new User[N + 1];

		for (int i = 1; i <= N; i++) {
			int max = 0;

			for (int j = 1; j <= N; j++) {
				max = Math.max(max, matrix[i][j]);
			}

			users[i] = new User(i, max);
		}

		// 회원의 점수를 오름차순으로 정렬
		Arrays.sort(users, 1, N);

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		// 정렬 후 첫번째 회원은 회장 후보임으로 버퍼에 추가
		sb.append(users[1].idx).append(SPACE);

		// 회장 후보 사람 수 저장 변수 초기화
		int candidateCnt = 1;

		// 회장 후보 점수 저장 변수 초기화
		int candidateScore = users[1].score;

		// 루프를 돌며 회장 후보 점수와 같은 나머지 사람들을 버퍼에 추가
		for (int i = 2; i <= N; i++) {
			if (users[i].score == candidateScore) {
				candidateCnt++;

				sb.append(users[i].idx).append(SPACE);
			}

			else {
				break;
			}
		}

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb2 = new StringBuilder();
		sb2.append(candidateScore).append(SPACE).append(candidateCnt).append(NEW_LINE).append(sb);

		// 결과 값 한꺼번에 출력
		System.out.println(sb2.toString());
	}

	/**
	 * 회원 이너 클래스
	 * 
	 * @author devetude
	 */
	private static class User implements Comparable<User> {
		public int idx;
		public int score;

		/**
		 * 생성자
		 * 
		 * @param idx
		 * @param score
		 */
		public User(int idx, int score) {
			this.idx = idx;
			this.score = score;
		}

		@Override
		public int compareTo(User u) {
			// 점수가 낮으면 앞으로
			return score < u.score ? -1 : 1;
		}
	}
}