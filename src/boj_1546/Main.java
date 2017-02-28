package boj_1546;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1546번 (평균) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1546
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		br.close();

		// 점수 저장 배열 초기화
		double[] scores = new double[N];

		// 최대값 저장 변수 초기화
		double max = 0.0d;

		// 루프를 돌며 점수를 저장하고 최대값을 찾음
		for (int i = 0; i < N; i++) {
			scores[i] = Double.parseDouble(st.nextToken());
			max = Math.max(max, scores[i]);
		}

		// 합계 변수 초기화
		double sum = 0.0d;

		// 루프를 돌며 새로운 점수로 합계를 구함
		for (int i = 0; i < N; i++) {
			scores[i] /= max;
			sum += scores[i] * 100.0d;
		}

		// 결과 값 출력
		// (평균, 소숫점 2째 자리에서 반올림)
		System.out.printf("%.2f", sum / (double) N);
	}
}