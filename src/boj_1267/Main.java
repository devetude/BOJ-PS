package boj_1267;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1267번 (핸드폰 요금) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1267
 * @author devetude
 */
public class Main {
	// 요금제 상수
	private static final int Y_FEE_PER_SEC = 10;
	private static final int M_FEE_PER_SEC = 15;
	private static final int Y_FEE_INTERVAL = 30;
	private static final int M_FEE_INTERVAL = 60;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();

		// 요금제를 계산
		int yFeeTotal = 0;
		int mFeeTotal = 0;

		for (int i = 0; i < N; i++) {
			int sec = Integer.parseInt(st.nextToken());
			yFeeTotal += (sec / Y_FEE_INTERVAL + 1) * Y_FEE_PER_SEC;
			mFeeTotal += (sec / M_FEE_INTERVAL + 1) * M_FEE_PER_SEC;
		}

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		if (yFeeTotal > mFeeTotal) {
			sb.append("M ").append(mFeeTotal);
		}

		else if (yFeeTotal < mFeeTotal) {
			sb.append("Y ").append(yFeeTotal);
		}

		else {
			sb.append("Y M ").append(mFeeTotal);
		}

		// 결과 값 출력
		System.out.println(sb.toString());
	}
}