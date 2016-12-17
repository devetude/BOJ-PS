package boj_4344;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 4344번 (평균은 넘겠지) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/4344
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (C-- != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());

			// 점수 저장 배열, 점수 합계 저장 변수 선언
			int[] scores = new int[N];
			int scoreSum = 0;

			// 점수를 저장하고 점수 합계를 구함
			for (int i = 0; i < N; i++) {
				scores[i] = Integer.parseInt(st.nextToken());
				scoreSum += scores[i];
			}

			// 평균 점수를 구함
			float averageScore = (float) scoreSum / (float) N;

			// 평균 점수 보다 높은 사람수 저장 변수
			int moreThanAverageScoreCnt = 0;

			// 평균 점수 보다 높은 사람수를 셈
			for (int i = 0; i < N; i++) {
				if (scores[i] > averageScore) {
					moreThanAverageScoreCnt++;
				}
			}

			// 버퍼를 이용해 결과 값을 만듬 (소숫점 3째 자리에서 반올림)
			sb.append(String.format("%.3f", (float) moreThanAverageScoreCnt / (float) N * 100f)).append("%\n");
		}

		br.close();

		// 결과 값 출력
		System.out.println(sb.toString());
	}
}