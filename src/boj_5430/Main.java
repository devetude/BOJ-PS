package boj_5430;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 5430번 (AC) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/5430
 * @author devetude
 */
public class Main {
	// 방향 상수
	private static final int RIGHT = 1;

	// 문자 상수
	private static final char REVERSE = 'R';
	private static final char LEFT_BRACKET = '[';

	// 문자열 상수
	private static final String RIGHT_BRACKET_AND_NEW_LINE = "]\n";
	private static final String COMMA = ",";
	private static final String ERROR_AND_NEW_LINE = "error\n";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		MAIN_LOOP: while (T-- != 0) {
			char[] methods = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());

			// 숫자 저장 배열 초기화
			int[] nums = new int[n];

			if (n != 0) {
				// 입력 값 중 숫자만 뽑아내어 숫자 배열에 저장
				String numArrStr = br.readLine();
				StringTokenizer st = new StringTokenizer(numArrStr.substring(1, numArrStr.length() - 1), ",");

				for (int i = 0; i < n; i++) {
					nums[i] = Integer.parseInt(st.nextToken());
				}
			}

			else {
				br.readLine();
			}

			// 왼쪽, 오른쪽 위치 및 방향 저장 변수 초기화
			int left = 0;
			int right = n - 1;
			int direction = RIGHT;

			// 루프를 돌며 함수 실행
			for (char method : methods) {
				// 뒤집기 일 경우 진행 방향을 반대로 변경
				if (method == REVERSE) {
					direction *= -1;
				}

				else {
					// 왼쪽 위치가 오른쪽 위치 보다 클 경우 에러로 판단
					if (left > right) {
						sb.append(ERROR_AND_NEW_LINE);

						continue MAIN_LOOP;
					}

					// 오른쪽 방향 일 경우 왼쪽 위치를 1 증가
					else if (direction == RIGHT) {
						left++;
					}

					// 왼쪽 방향 일 경우 오른쪽 위치를 1 감소
					else {
						right--;
					}
				}
			}

			// 방향과 시작 위치를 기준으로 결과 값을 만듬
			sb.append(LEFT_BRACKET);

			if (left <= right) {
				if (direction == RIGHT) {
					int i = left;

					for (; i < right; i++) {
						sb.append(nums[i]).append(COMMA);
					}

					sb.append(nums[i]);
				}

				else {
					int i = right;

					for (; i > left; i--) {
						sb.append(nums[i]).append(COMMA);
					}

					sb.append(nums[i]);
				}
			}

			sb.append(RIGHT_BRACKET_AND_NEW_LINE);
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}