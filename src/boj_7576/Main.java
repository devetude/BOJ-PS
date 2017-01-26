package boj_7576;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 7576번 (토마토) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/7576
 * @author devetude
 */
public class Main {
	// 토마토의 상태 상수
	private static final int RIPE_STATUS = 1;
	private static final int NOT_RIPE_STAUS = 0;

	// 체크 여부 상수
	private static final int NOT_CHECKED = -1;
	private static final int CHECKED = 0;

	// 위, 아래, 오른쪽, 왼쪽 상수
	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 };

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		Queue<Point> queue = new LinkedList<>();
		int[][] box = new int[N][M];
		int[][] isChecked = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < M; j++) {
				int status = Integer.parseInt(st.nextToken());
				box[i][j] = status;
				isChecked[i][j] = NOT_CHECKED;

				// 익은 토마토의 경우 따로 큐에 좌표를 저장
				if (status == RIPE_STATUS) {
					queue.offer(new Point(i, j));
					isChecked[i][j] = CHECKED;
				}
			}
		}

		br.close();

		// 큐에 더 이상 익은 토마토의 좌표가 없을 때까지 반복
		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
					// 익어있지 않은 토마토를 발견한 경우
					if (box[nx][ny] == NOT_RIPE_STAUS && isChecked[nx][ny] == NOT_CHECKED) {
						// 깊이를 체크 배열에 저장
						isChecked[nx][ny] = isChecked[p.x][p.y] + 1;

						// 큐에 해당 좌표를 저장
						queue.offer(new Point(nx, ny));
					}
				}
			}

		}

		// 최대 일 수 저장 변수
		int maxDays = 0;

		// 체크 배열의 최대 깊이 값을 구함
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				maxDays = Math.max(maxDays, isChecked[i][j]);
			}
		}

		// 아직 익지 않은 토마토가 남아있는 경우 문제의 조건에서 -1로 처리
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == NOT_RIPE_STAUS && isChecked[i][j] == NOT_CHECKED)
					maxDays = -1;
			}
		}

		// 결과 값 출력
		System.out.println(maxDays);
	}

	/**
	 * 좌표 이너 클래스
	 * 
	 * @author devetude
	 */
	static class Point {
		public int x;
		public int y;

		/**
		 * 생성자
		 * 
		 * @param x
		 * @param y
		 */
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}