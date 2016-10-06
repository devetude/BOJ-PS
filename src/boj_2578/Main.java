package boj_2578;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2578번 (빙고) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/2578
 * @author devetude
 */
public class Main {
	private static int[][] bingo = new int[5][5];
	private static int[][] res = new int[5][5];
	private static int bingoCounts = 0;
	private static int totalProcessCounts = 0;

	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 빙고판 입력 부분
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 사회자가 말하는 부분
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < 5; j++) {
				// 빙고가 됬다면
				if (isBingo(Integer.parseInt(st.nextToken()))) {
					// 몇 번째 호출이였는지 출력 후 종료
					System.out.println(totalProcessCounts);
					return;
				}
			}
		}

		br.close();
	}

	/**
	 * 빙고인지 판별하는 메소드
	 * 
	 * @param n
	 * @return
	 */
	private static boolean isBingo(int n) {
		totalProcessCounts++;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				// 빙고판에서 사회자가 부른 숫자의 행과 열을 찾아냄
				if (bingo[i][j] == n) {
					// 결과판에 1(X)로 표시
					res[i][j] = 1;

					// 1 빙고가 나오기 위해서는 적어도 5개 이상의 X가 필요하므로 사회자가 5개의 번호를 부르기 전까진
					// 확인하지 않음
					if (totalProcessCounts >= 5) {
						// 가로 빙고인지 확인
						if (isHorizontalBingo(i)) {
							bingoCounts++;
						}

						// 세로 빙고인지 확인
						if (isVerticalBingo(j)) {
							bingoCounts++;
						}

						// 특수한 경우1 : (0,0), (1,1), (3,3), (4,4)인 경우에는 3개의 빙고가
						// 동시에 나올 수 있음 (가로, 세로, 왼쪽 위에서 오른쪽 아래로 가는 대각선)
						if ((i == 0 && j == 0) || (i == 1 && j == 1) || (i == 3 && j == 3) || (i == 4 && j == 4)) {
							// 왼쪽 위에서 오른쪽 아래로 가는 대각선 빙고인지 확인
							if (isLeftRightDiagonalBingo()) {
								bingoCounts++;
							}
						}

						// 특수한 경우2 : (0,5), (1,3), (3,1), (4,0)인 경우에는 3개의 빙고가
						// 동시에 나올 수 있음 (가로, 세로, 오른쪽 위에서 왼쪽 아래로 가는 대각선)
						else if ((i == 0 && j == 5) || (i == 1 && j == 3) || (i == 3 && j == 1) || (i == 4 && j == 0)) {
							// 오른쪽 위에서 왼쪽 아래로 가는 대각선 빙고인지 확인
							if (isRightLeftDiagonalBingo()) {
								bingoCounts++;
							}
						}

						// 특수한 경우3 : (2,2)인 경우에는 4개의 빙고가 동시에 나올 수 있음 (가로, 세로, 왼쪽
						// 위에서 오른쪽 아래로 가는 대각선, 오른쪽 위에서 왼쪽 아래로 가는 대각선)
						else if (i == 2 && j == 2) {
							// 왼쪽 위에서 오른쪽 아래로 가는 대각선 빙고인지 확인
							if (isLeftRightDiagonalBingo()) {
								bingoCounts++;
							}

							// 오른쪽 위에서 왼쪽 아래로 가는 대각선 빙고인지 확인
							if (isRightLeftDiagonalBingo()) {
								bingoCounts++;
							}
						}

						// 총 빙고의 갯수가 3이면 종료
						if (bingoCounts >= 3) {
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	/**
	 * 가로 빙고 확인 메소드
	 * 
	 * @param i
	 * @return
	 */
	private static boolean isHorizontalBingo(int i) {
		for (int k = 0; k < 5; k++) {
			// 중간에 1개라도 X가 되어있지 않은 경우 빙고가 아님
			if (res[i][k] != 1) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 세로 빙고 확인 메소드
	 * 
	 * @param j
	 * @return
	 */
	private static boolean isVerticalBingo(int j) {
		for (int k = 0; k < 5; k++) {
			// 중간에 1개라도 X가 되어있지 않은 경우 빙고가 아님
			if (res[k][j] != 1) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 왼쪽 위에서 오른쪽 아래로 가는 대각선 빙고 확인 메소드
	 * 
	 * @return
	 */
	private static boolean isLeftRightDiagonalBingo() {
		for (int i = 0; i < 5; i++) {
			// 중간에 1개라도 X가 되어있지 않은 경우 빙고가 아님
			if (res[i][i] != 1) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 오른쪽 위에서 왼쪽 아래로 가는 대각선 빙고 확인 메소드
	 * 
	 * @return
	 */
	private static boolean isRightLeftDiagonalBingo() {
		int j = 4;

		for (int i = 0; i < 5; i++) {
			// 중간에 1개라도 X가 되어있지 않은 경우 빙고가 아님
			if (res[i][j] != 1) {
				return false;
			}

			j--;
		}

		return true;
	}
}