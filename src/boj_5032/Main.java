package boj_5032;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 5032번 (탄산 음료) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/5032
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();

		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		// 준민이가 현재 가지고 있는 빈 병의 갯수 저장 변수
		int remainCnt = e + f;

		// 준민이가 마실 수 있는 탄산 음료의 갯수 저장 변수
		int resCnt = 0;

		// 더 이상 빈 병으로 탄산 음료를 바꿀 수 없을 때 까지 반복
		while (remainCnt >= c) {
			int changeCnt = remainCnt / c;
			resCnt += changeCnt;
			remainCnt -= changeCnt * c - changeCnt;
		}

		// 결과 값 출력
		System.out.println(resCnt);
	}
}