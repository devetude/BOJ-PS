package boj_2659;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2659번 (십자카드 문제) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2659
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();

		char[] inputNumChars = new char[4];

		for (int i = 0; i < 4; i++) {
			inputNumChars[i] = st.nextToken().charAt(0);
		}

		// 입력 값의 시계수를 찾음
		int inputClockNum = Integer.MAX_VALUE;

		for (int i = 0; i < 4; i++) {
			StringBuilder sb = new StringBuilder();

			for (int j = i; j < 4; j++) {
				sb.append(inputNumChars[j]);
			}

			for (int j = 0; j < i; j++) {
				sb.append(inputNumChars[j]);
			}

			inputClockNum = Math.min(inputClockNum, Integer.parseInt(sb.toString()));
		}

		// 1111부터 9999까지 해당 숫자가 시계수인지 확인하는 배열
		boolean[] isClockNum = new boolean[10000];

		// 초기에 모두 시계수로 설정
		Arrays.fill(isClockNum, true);

		for (int i = 1111; i <= inputClockNum; i++) {
			// 시계수에는 0이 들어갈 수 없으므로 0이 들어간 수는 시계수에서 제외
			if (String.valueOf(i).indexOf('0') != -1) {
				isClockNum[i] = false;

				continue;
			}

			if (isClockNum[i]) {
				char[] numChars = String.valueOf(i).toCharArray();
				int clockNum = i;

				// 숫자를 돌려가며 가장 작은 숫자를 제외한 나머지 시계수에서 제외
				for (int j = 1; j < 4; j++) {
					StringBuilder sb = new StringBuilder();

					for (int k = j; k < 4; k++) {
						sb.append(numChars[k]);
					}

					for (int k = 0; k < j; k++) {
						sb.append(numChars[k]);
					}

					int num = Integer.parseInt(sb.toString());

					if (clockNum > num) {
						isClockNum[clockNum] = false;
						clockNum = num;
					}
				}
			}
		}

		int idx = 0;

		// 입력 시계수가 몇번째 시계수인지 찾음
		for (int i = 1111; i <= inputClockNum; i++) {
			if (isClockNum[i]) {
				idx++;
			}
		}

		// 결과 값 출력
		System.out.println(idx);
	}
}