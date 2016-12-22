package boj_1676;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 1676번 (팩토리얼 0의 개수) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1676
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();

		// 팩토리얼의 0의 갯수 저장 변수
		int zeroCnt = 0;

		for (int i = 5; i <= N; i++) {
			int num = i;

			while (true) {
				// 팩토리얼의 0의 갯수는 (2^a * 5^b) 형태가 몇 개 나오는지 구하면 됨
				// 팩토리얼에서 5보다 2의 소인수가 많이 나오므로 결국, 5의 갯수를 구하면 됨
				if (num % 5 == 0) {
					zeroCnt++;
					num /= 5;
				}

				else {
					break;
				}
			}
		}

		// 결과 값 출력
		System.out.println(zeroCnt);
	}
}