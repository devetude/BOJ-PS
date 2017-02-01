package boj_10984;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 10984번 (내 학점을 구해줘) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/10984
 * @author devetude
 */
public class Main {
	// 문자열 상수
	private static final String NEW_LINE = "\n";
	private static final String SPACE = " ";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (T-- != 0) {
			int N = Integer.parseInt(br.readLine());
			int cSum = 0;
			double avg = 0.0f;

			while (N-- != 0) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int C = Integer.parseInt(st.nextToken());
				double G = Double.parseDouble(st.nextToken());
				cSum += C;
				avg += C * G;
			}

			// 평균 평점이 0이 아닌 경우에만
			if (avg != 0.0f) {
				avg = Math.round(avg / cSum * 10.0f);
				avg /= 10.0f;
			}

			// 버퍼를 이용해 결과 값을 만듬
			sb.append(cSum).append(SPACE).append(avg).append(NEW_LINE);
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}