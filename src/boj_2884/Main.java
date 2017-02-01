package boj_2884;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2884번 (알람 시계) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2884
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();

		int H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 분이 45보다 작은 경우
		// (시간을 감소시켜야 함)
		if (M < 45) {
			// 시간이 0인 경우
			// (시간을 23으로 설정)
			if (H == 0) {
				H = 23;
			}

			// 시간이 0이 아닌 경우
			// (시간을 1 감소시킴)
			else {
				H--;
			}

			// 분에서 45를 빼고 60을 더함
			M -= 45 - 60;
		}

		// 분이 45보다 크거나 같은 경우
		// (분만 45분 감소)
		else {
			M -= 45;
		}

		// 버퍼를 이용해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();
		sb.append(H).append(" ").append(M);

		// 결과 값 출력
		System.out.println(sb.toString());
	}
}