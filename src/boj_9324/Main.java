package boj_9324;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 9324번 (진짜 메시지) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/9324
 * @author devetude
 */
public class Main {
	private static final String OK = "OK";
	private static final String FAKE = "FAKE";
	private static final String NEW_LINE = "\n";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		while (T-- != 0) {
			String msg = br.readLine();
			// A ~ Z 사이의 각 문자가 몇 번 등장했는지 저장하는 배열
			int[] charCnts = new int[26];

			// 결과 값 저장 변수
			boolean res = true;

			// 입력 받은 문자열 길이 저장 변수
			int msgLen = msg.length();

			// 루프를 돌며 문자열의 진짜 여부를 판별
			for (int i = 0; i < msgLen; i++) {
				char msgChar = msg.charAt(i);
				int charCntsIdx = (int) msgChar - 65;

				// 해당 문자의 등장 횟수 변경
				charCnts[charCntsIdx]++;

				// 해당 문자의 등장 횟수가 3일 경우
				if (charCnts[charCntsIdx] == 3) {
					int nextIdx = i + 1;

					// 다음 인덱스가 문자열의 길이와 일치하거나, 현재 문자와 다음 문자가 일치하지 않는 경우
					if (nextIdx == msgLen || msgChar != msg.charAt(nextIdx)) {
						// 거짓임으로 루프 탈출
						res = false;

						break;
					}

					else {
						// 해당 문자의 등장 횟수를 0으로 초기화
						charCnts[charCntsIdx] = 0;

						// 다음 문자를 확인했으므로 인덱스를 하나 더 증가시킴
						i++;
					}
				}
			}

			// 결과 값을 만듬
			if (res) {
				sb.append(OK);
			}

			else {
				sb.append(FAKE);
			}

			sb.append(NEW_LINE);
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}