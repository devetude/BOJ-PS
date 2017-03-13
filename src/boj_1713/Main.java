package boj_1713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1713번 (후보 추천하기) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1713
 * @author devetude
 */
public class Main {
	// 공백 문자열 상수
	private static final String SPACE = " ";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		br.close();

		// 큐 객체 변수 초기화
		Queue<Integer> queue = new LinkedList<>();

		// 후보 추천 수 저장 배열 초기화
		int[] points = new int[cnt + 1];

		for (int i = 0; i < cnt; i++) {
			int idx = Integer.parseInt(st.nextToken());
			points[idx]++;

			// 이미 해당 후보의 사진이 걸려있지 않은 경우에만
			if (!queue.contains(idx)) {
				// 후보의 사진이 사진틀의 갯수 보다 많을 경우에만
				if (queue.size() >= N) {
					Iterator<Integer> iterator = queue.iterator();
					int minPointIdx = iterator.next();

					// 가장 추천 수가 적은 후보를 찾아냄 (추천 수가 같은 경우 오래 걸려있던 순서또한 찾아냄)
					while (iterator.hasNext()) {
						int comparingIdx = iterator.next();

						if (points[comparingIdx] < points[minPointIdx]) {
							minPointIdx = comparingIdx;
						}
					}

					// 해당 후보를 큐에서 삭제 및 값을 0으로 만듬
					queue.remove(minPointIdx);
					points[minPointIdx] = 0;
				}

				// 해당 후보의 사진을 사진틀에 추가
				queue.offer(idx);
			}
		}

		// 큐를 오름차순으로 정렬
		Collections.sort((LinkedList<Integer>) queue);

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		while (!queue.isEmpty()) {
			sb.append(queue.poll()).append(SPACE);
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}