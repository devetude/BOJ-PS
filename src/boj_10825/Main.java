package boj_10825;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 10825번 (국영수) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/10825
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		// (이유 : Scanner를 이용 할 경우 매우 느림)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<User> userArrayList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			// 사용자 정보를 받아와서 배열 리스트 형태로 만듬
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			userArrayList.add(new User(st.nextToken(), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		br.close();

		// 사용자 배열 리스트 정렬
		Collections.sort(userArrayList, User.comparator);

		// 버퍼를 통해 출력 값을 만듬
		// (이유 : System.out.println을 여러번 호출 할 경우 매우 느림)
		StringBuilder sb = new StringBuilder();

		for (User user : userArrayList) {
			sb.append(user.name).append("\n");
		}

		// 출력 값 한꺼번에 출력
		System.out.println(sb.toString());
	}

	/**
	 * 사용자 이너 클래스
	 * 
	 * @author devetude
	 */
	private static class User {
		public String name;
		public int korean;
		public int english;
		public int math;

		/**
		 * 생성자
		 * 
		 * @param name
		 * @param korean
		 * @param english
		 * @param math
		 */
		public User(String name, int korean, int english, int math) {
			this.name = name;
			this.korean = korean;
			this.english = english;
			this.math = math;
		}

		/**
		 * 사용자 객체 비교 이너 클래스
		 */
		private static Comparator<User> comparator = new Comparator<User>() {
			@Override
			public int compare(User u1, User u2) {
				// 국어 점수는 내림차순으로
				if (u1.korean > u2.korean) {
					return -1;
				}

				else if (u1.korean == u2.korean) {
					// 영어 점수는 오름차순으로
					if (u1.english > u2.english) {
						return 1;
					}

					else if (u1.english == u2.english) {
						// 수학 점수는 내림차순으로
						if (u1.math > u2.math) {
							return -1;
						}

						else if (u1.math == u2.math) {
							// 이름은 사전순으로
							return u1.name.compareTo(u2.name);
						}

						else {
							return 1;
						}
					}

					else {
						return -1;
					}
				}

				else {
					return 1;
				}
			}
		};
	}
}