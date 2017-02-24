package boj_1773;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1773번 (폭죽쇼) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1773
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] seqs = new int[N];

		for (int i = 0; i < N; i++) {
			seqs[i] = Integer.parseInt(br.readLine());
		}

		br.close();

		// 해당 시간에 폭죽이 터졌는지 여부를 저장하는 배열 초기화
		boolean[] isPoped = new boolean[C + 1];

		// 학생별 폭죽을 터트리는 시간을 계산하여 여부를 변경
		for (int seq : seqs) {
			for (int i = 1; seq * i <= C; i++) {
				isPoped[seq * i] = true;
			}
		}

		// 폭죽이 터지는 시간 저장 변수 초기화
		int hours = 0;

		// 폭죽이 터진 시간을 구함
		for (boolean status : isPoped) {
			if (status) {
				hours++;
			}
		}

		// 결과 값 출력
		System.out.println(hours);
	}
}