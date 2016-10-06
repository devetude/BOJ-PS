package boj_7568;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 7568번 (덩치) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/7568
 * @author devetude
 */
public class Main {
	public static void main(String[] args) throws Exception {
		// 버퍼를 이용해 입력을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Person[] persons = new Person[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			persons[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		br.close();

		// 루프를 돌면서 나보다 덩치가 큰 경우 rank 값을 1씩 증가시킴
		for (Person p1 : persons) {
			for (Person p2 : persons) {
				if (p1.weight < p2.weight && p1.tall < p2.tall) {
					p1.rank++;
				}
			}
		}

		// 버퍼를 이용해 결과 값 출력
		StringBuilder sb = new StringBuilder();

		for (Person p : persons) {
			sb.append(p.rank).append(" ");
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}

	/**
	 * 키와 몸무게 및 등수를 저장하고 있는 사람 이너 객체
	 * 
	 * @author devetude
	 */
	private static class Person {
		public int weight;
		public int tall;
		public int rank;

		/**
		 * 생성자
		 * 
		 * @param weight
		 * @param tall
		 */
		public Person(int weight, int tall) {
			this.weight = weight;
			this.tall = tall;
			this.rank = 1;
		}
	}
}