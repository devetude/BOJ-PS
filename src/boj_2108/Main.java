package boj_2108;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 백준 온라인 저지 2108번 (통계학) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2108
 * @author devetude
 */
public class Main {
	private static final String NEW_LINE = "\n";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 숫자 저장 배열 초기화
		int[] nums = new int[N];

		// 빈도 저장 배열 초기화
		int[] freqCnts = new int[8002];

		// 합 저장 변수
		double sum = 0;

		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());

			// 입력 받은 숫자를 합에 더함
			sum += nums[i];

			// 입력 받은 숫자가 0 또는 양수면 빈도 배열의 해당 인덱스에 1을 올림
			if (nums[i] >= 0) {
				freqCnts[nums[i]]++;
			}

			// 음수면 빈도 배열의 해당 인덱스에 8001을 더한 이후 1을 올림
			else {
				freqCnts[nums[i] + 8001]++;
			}
		}

		br.close();

		// 초기 최대 빈도는 -1로 초기화
		int maxFreqCnt = -1;

		// 최대 빈도 숫자 저장 배열리스트 초기화
		ArrayList<Integer> maxFreqNums = new ArrayList<>();

		for (int i = 0; i < 8002; i++) {
			// 최빈값이 달라졌을 경우
			if (maxFreqCnt < freqCnts[i]) {
				// 새로운 최빈값으로 변경
				maxFreqCnt = freqCnts[i];

				// 최대 빈도 숫자 저장 배열리스트 초기화
				maxFreqNums = new ArrayList<>();

				// 음수일 경우 다시 원래 숫자로 변환하여 배열리스트에 저장
				if (i >= 4001) {
					maxFreqNums.add(i - 8001);
				}

				else {
					maxFreqNums.add(i);
				}
			}

			// 최빈값이 그대로일 경우
			else if (maxFreqCnt == freqCnts[i]) {
				// 음수일 경우 다시 원래 숫자로 변환하여 배열리스트에 저장
				if (i >= 4001) {
					maxFreqNums.add(i - 8001);
				}

				else {
					maxFreqNums.add(i);
				}
			}
		}

		// 최대 빈도 숫자를 가져옴
		int maxFreqNum = maxFreqNums.get(0);

		// 최대 빈도 숫자가 여러개일 경우
		if (maxFreqNums.size() != 1) {
			// 정렬 이후 2번째로 작은 값으로 변경
			Collections.sort(maxFreqNums);
			maxFreqNum = maxFreqNums.get(1);
		}

		// 숫자들을 오름차순으로 정렬
		Arrays.sort(nums);

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();
		sb.append(Math.round(sum / (double) N)).append(NEW_LINE);
		sb.append(nums[N / 2]).append(NEW_LINE);
		sb.append(maxFreqNum).append(NEW_LINE);
		sb.append(nums[N - 1] - nums[0]);

		// 결과 값 출력
		System.out.println(sb.toString());
	}
}