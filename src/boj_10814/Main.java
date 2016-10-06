package boj_10814;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 10814번 (나이순 정렬) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/10814
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		// 이유 : Scanner를 통해 입력을 받으면 실행속도 느림
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<User> userList = new ArrayList<>();

		// 이름과 나이를 받아서 사용자 객체로 만들어서 배열 리스트에 저장
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			userList.add(new User(i, Integer.parseInt(st.nextToken()), st.nextToken()));
		}

		br.close();

		// 객체간의 정렬
		Collections.sort(userList, User.Comparator);

		// 버퍼를 통해 결과 값을 만듬
		// 이유 : System.out.println을 여러번 이용하면 실행속도 느림
		StringBuilder sb = new StringBuilder();

		for (User user : userList) {
			sb.append(user.age).append(" ").append(user.name).append("\n");
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

		/**
		 * 사용자 비교 이너 클래스
		 */
		private static Comparator<User> Comparator = new Comparator<User>() {
			@Override
			public int compare(User u1, User u2) {
				// 각 객체의 나이를 먼저 비교
				if (u1.age < u2.age) {
					return -1;
				}

				// 나이가 같은 경우 가입순서를 비교
				else if (u1.age == u2.age) {
					// y좌표 값 비교
					if (u1.index < u2.index) {
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