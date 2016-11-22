package boj_2004;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2004번 (조합 0의 개수) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2004
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		br.close();

		// 2의 갯수를 구함
		int twoCounts = findTrailingNum(n, 2);

		if (m != 0) {
			twoCounts -= findTrailingNum(m, 2);
		}

		if (m != n) {
			twoCounts -= findTrailingNum(n - m, 2);
		}

		// 5의 갯수를 구함
		int fiveCounts = findTrailingNum(n, 5);

		if (m != 0) {
			fiveCounts -= findTrailingNum(m, 5);
		}

		if (m != n) {
			fiveCounts -= findTrailingNum(n - m, 5);
		}

		// 2의 갯수와 5의 갯수 중 작은쪽을 결과 값으로 출력
		System.out.println(Math.min(twoCounts, fiveCounts));
	}

	/**
	 * num에 trailingNum이 몇번 곱해있는지 알아내는 메소드
	 * 
	 * @param num
	 * @param trailingNum
	 * @return
	 */
	private static int findTrailingNum(int num, int trailingNum) {
		int counts = 0;

		for (long i = trailingNum; num / i >= 1; i *= trailingNum) {
			counts += num / i;
		}

		return counts;
	}
}