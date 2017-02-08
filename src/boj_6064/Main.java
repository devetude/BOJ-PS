package boj_6064;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 6064번 (카잉 달력) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/6064
 * @author devetude
 */
public class Main {
	// 개행 문자열 상수
	private static final String NEW_LINE = "\n";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (T-- != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			// <작은 숫자, 큰 숫자> 순으로 바꿈
			// ex) (M, N, x, y)가 (13, 11, 5, 6)이면, (11, 13, 6, 5)로 바꿈
			if (M > N) {
				int tmp = M;
				M = N;
				N = tmp;
				tmp = x;
				x = y;
				y = tmp;
			}

			// 큰 숫자 빼기 작은 숫자 결과 저장 변수
			int diff = N - M;

			// 사이클 반복 횟수 저장 변수
			int cnt = 0;

			// 시작점은 x로 초기화
			int current = x;

			// 루프를 돌며 몇번만에 y를 찾을 수 있는지 구함
			// ex) (M, N, x, y)가 (11, 13, 6, 5) 일 때 규칙성
			// 6, 6 (6년) -> 6, 4 (17년) -> 6, 2 (28년) -> 6, 13 (39년)
			// -> 6, 11 (50년) -> 6, 9 (61년) -> 6, 7 (72년) -> 6, 5 (83년)
			while (current != y) {
				cnt++;

				if (current > diff) {
					current -= diff;
				}

				else {
					current = N - (diff - current);
				}

				// 사이클이 발생되면 만들 수 없는 연도 임으로 루프 탈출
				if (current == x) {
					break;
				}
			}

			// 만들 수 없는 연도인 경우
			if (cnt != 0 && current == x) {
				sb.append(-1).append(NEW_LINE);
			}

			else {
				sb.append(x + cnt * M).append(NEW_LINE);
			}
		}

		br.close();

		// 결과 값을 한꺼번에 출력
		System.out.println(sb.toString());
	}
}