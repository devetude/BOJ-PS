package boj_10814;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 10814번 (나이순 정렬) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/10814
 * @author devetude
 */
public class Main {
	// 문자열 상수
	private static final String SPACE = " ";
	private static final String NEW_LINE = "\n";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 사용자 객체 배열 초기화
		User[] users = new User[N];

		// 이름과 나이를 받아서 사용자 객체로 만들어 배열에 저장
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			users[i] = new User(i, Integer.parseInt(st.nextToken()), st.nextToken());
		}

		br.close();

		// 객체간의 정렬 실행
		Arrays.sort(users, User.comparator);

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (User user : users) {
			sb.append(user.age).append(SPACE).append(user.name).append(NEW_LINE);
		}

		// 결과 값을 한꺼번에 출력
		System.out.print(sb.toString());
	}

	/**
	 * 사용자 이너 클래스
	 * 
	 * @author devetude
	 */
	private static class User {
		private int index;
		private int age;
		private String name;

		/**
		 * 생성자
		 * 
		 * @param index
		 * @param age
		 * @param name
		 */
		public User(int index, int age, String name) {
			this.index = index;
			this.age = age;
			this.name = name;
		}

		// 비교 객체 변수
		private static Comparator<User> comparator = new Comparator<User>() {
			@Override
			public int compare(User u1, User u2) {
				// 각 객체의 나이를 먼저 비교
				if (u1.age < u2.age) {
					return -1;
				}

				// 나이가 같은 경우 가입순서를 비교
				else if (u1.age == u2.age) {
					if (u1.index < u2.index) {
						return -1;
					}

					else if (u1.index == u2.index) {
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
		};
	}
}