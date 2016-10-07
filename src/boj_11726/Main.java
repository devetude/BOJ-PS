package boj_11726;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 11726번 (2×n 타일링) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/11726
 * @author devetude
 */
public class Main {
	private static int[] cache = null;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();

		cache = new int[n + 1];

		System.out.println(fill(n));
	}

	private static int fill(int n) {
		if (n == 1) {
			return 1;
		}

		if (n == 2) {
			return 2;
		}

		if (cache[n] != 0) {
			return cache[n];
		}

		return cache[n] = (fill(n - 1) % 10007 + fill(n - 2) % 10007) % 10007;
	}
}