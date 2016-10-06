package boj_2502;

import java.util.Scanner;

/**
 * 백준 온라인 저지 2502번 (떡 먹는 호랑이) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/2502
 * @author devetude
 */
public class Main {
	private static Cake[] cache = new Cake[31];

	public static void main(String args[]) throws Exception {
		// 입력 값을 가져옴
		Scanner sc = new Scanner(System.in);
		Cake cake = calc(sc.nextInt());
		int K = sc.nextInt();
		sc.close();

		// 첫째날 준 떡의 갯수를 1부터 추론
		int firstDayCakeCounts = 1;

		// 첫째날 및 둘째날 준 떡의 갯수를 알아내야 하는데, 식은 1개 뿐이므로 부정방정식 중 가장 작은 자연수 해를 구함
		while (true) {
			// 둘째날 준 떡의 갯수를 계산함 (실수가 나올 수 도 있음)
			float secondDayCakeCounts = (float) (K - cake.xCounts * firstDayCakeCounts) / (float) cake.yCounts;

			// 문제의 조건에서 떡의 갯수는 정수 형태이므로 1로 나누어 나머지가 없는 정수인지 확인
			if (secondDayCakeCounts % 1.0f == 0.0f) {
				// 결과 값 출력
				System.out.println(firstDayCakeCounts);
				System.out.println((int) secondDayCakeCounts);
				return;
			}

			firstDayCakeCounts++;
		}
	}

	/**
	 * 2차 방정식 꼴로 만들어주기 위한 이너 클래스
	 * 
	 * @author devetude
	 */
	private static class Cake {
		public int xCounts = 0;
		public int yCounts = 0;

		/**
		 * 생성자
		 * 
		 * @param xCounts
		 * @param yCounts
		 */
		public Cake(int xCounts, int yCounts) {
			this.xCounts = xCounts;
			this.yCounts = yCounts;
		}

		/**
		 * 객체의 합 메소드
		 * 
		 * @param anotherCake
		 * @return
		 */
		public Cake add(Cake anotherCake) {
			return new Cake(this.xCounts + anotherCake.xCounts, this.yCounts + anotherCake.yCounts);
		}
	}

	/**
	 * 날짜에 따른 떡의 방정식을 생성하는 메소드
	 * 
	 * @param days
	 * @return
	 */
	private static Cake calc(int days) {
		// 기저조건1 : 첫날에 준 떡의 방정식은 x=1, y=0
		if (days == 1) {
			return new Cake(1, 0);
		}

		// 기저조건2 : 둘째날에 준 떡의 방정식은 x=0, y=1
		else if (days == 2) {
			return new Cake(0, 1);
		}

		// 속도를 빠르게 하기 위해 캐시에 저장된 값이 있을 경우 캐시를 사용
		if (cache[days] != null) {
			return cache[days];
		}

		// 메소드 재귀 호출
		return cache[days] = calc(days - 2).add(calc(days - 1));
	}
}