package boj_11652;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * 백준 온라인 저지 11652번 (카드) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/11652
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해서 입력 값을 받음
		// (이유 : Scanner를 이용하면 매우 느리기 때문)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		BigInteger[] inputs = new BigInteger[N];

		for (int i = 0; i < N; i++) {
			inputs[i] = new BigInteger(br.readLine());
		}

		br.close();

		// 입력 값들을 오름차순으로 정렬
		Arrays.sort(inputs);

		// 최초의 이전 값을 0번 아이템으로 설정
		BigInteger preNumber = inputs[0];

		// 아이템의 반복되는 횟수를 저장 할 변수
		int numberCounts = 0;

		// 가장 많이 등장한 아이템의 값을 저장 할 변수
		BigInteger withMostNumber = BigInteger.ZERO;

		// 가장 많이 등장한 아이템의 반복되는 횟수를 저장 할 변수
		int withMostNumberCounts = 0;

		for (int i = 0; i < N; i++) {
			// 이전 아이템 값과 현재 아이템 값이 같은 숫자가 아니라면
			if (!preNumber.equals(inputs[i])) {
				// 이전 값의 반복 횟수가 가장 많이 등장한 아이템의 반복 횟수 보다 클 경우에만
				if (numberCounts > withMostNumberCounts) {
					// 가장 많이 등장한 아이템의 반복 횟수를 변경
					withMostNumberCounts = numberCounts;

					// 가장 많이 등장한 아이템의 값을 변경
					withMostNumber = preNumber;
				}

				// 아이템의 반복 횟수 초기화
				numberCounts = 1;

				// 이전 값을 현재 값으로 설정
				preNumber = inputs[i];
			}

			else {
				numberCounts++;
			}
		}

		// 입력 값의 마지막 아이템 값은 비교되지 않고 빠져나오므로 마지막으로 비교
		if (numberCounts > withMostNumberCounts) {
			withMostNumberCounts = numberCounts;
			withMostNumber = preNumber;
		}

		// 결과 값 출력 (가장 많이 등장한 아이템 값)
		System.out.println(withMostNumber);
	}
}