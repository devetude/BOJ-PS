package boj_2037;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2037번 (문자메시지) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/
 * @author devetude
 */
public class Main {
	// 문자열 상수
	private static final String SPACE = " ";

	// 버튼 그룹 배열 상수
	private static final char[][] BUTTON_GROUPS = { { ' ' }, { 'A', 'B', 'C' }, { 'D', 'E', 'F' }, { 'G', 'H', 'I' },
			{ 'J', 'K', 'L' }, { 'M', 'N', 'O' }, { 'P', 'Q', 'R', 'S' }, { 'T', 'U', 'V' }, { 'W', 'X', 'Y', 'Z' } };

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);
		int p = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		char[] chars = br.readLine().toCharArray();

		br.close();

		// 합 변수
		int sum = 0;

		// 이전 버튼 그룹 인덱스
		int lastButtonGroupIdx = -1;

		// 루프를 돌며 합을 구함
		for (char c : chars) {
			int[] buttonGroupsIdxs = getButtonGroupsIdxs(c);
			sum += (buttonGroupsIdxs[1] + 1) * p;

			if (c != ' ' && buttonGroupsIdxs[0] == lastButtonGroupIdx) {
				sum += w;
			}

			lastButtonGroupIdx = buttonGroupsIdxs[0];
		}

		// 결과 값 출력
		System.out.println(sum);
	}

	/**
	 * 버튼 그룹 인덱스를 찾는 메소드
	 * 
	 * @param c
	 * @return
	 */
	private static int[] getButtonGroupsIdxs(char c) {
		int[] res = new int[2];

		MAIN_LOOP: for (int i = 0; i < BUTTON_GROUPS.length; i++) {
			for (int j = 0; j < BUTTON_GROUPS[i].length; j++) {
				if (BUTTON_GROUPS[i][j] == c) {
					res[0] = i;
					res[1] = j;

					break MAIN_LOOP;
				}
			}
		}

		return res;
	}
}