package boj_5567;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 5567번 (결혼식) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/5567
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		// 인접 행렬 배열 초기화
		boolean[][] adjacencyMatrix = new boolean[n + 1][n + 1];

		// 루프를 돌며 인접 행렬을 만듬
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			adjacencyMatrix[k][v] = adjacencyMatrix[v][k] = true;
		}

		br.close();

		// 해당 인덱스의 동기가 초대되었는지 저장하는 배열 초기화
		boolean[] isInvited = new boolean[n + 1];

		for (int v = 2; v <= n; v++) {
			// 상근이의 친구 일 경우
			if (adjacencyMatrix[1][v]) {
				// 해당 동기를 초대
				isInvited[v] = true;

				for (int v2 = 2; v2 <= n; v2++) {
					// 친구의 친구 일 경우
					if (adjacencyMatrix[v][v2]) {
						// 해당 동기를 초대
						isInvited[v2] = true;
					}
				}
			}
		}

		// 초대 인원 저장 변수
		int cnt = 0;

		// 루프를 돌며 초대 인원을 셈
		for (int i = 1; i <= n; i++) {
			if (isInvited[i]) {
				cnt++;
			}
		}

		// 결과 값 출력
		System.out.println(cnt);
	}
}