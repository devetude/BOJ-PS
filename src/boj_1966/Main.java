package boj_1966;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1966번 (프린터 큐) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1966
 * @author devetude
 */
public class Main {
	// 개행 문자열 상수
	private static final String NEW_LINE = "\n";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		while (T-- != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");

			// 문서 저장 큐 객체 변수 초기화
			Queue<Doc> queue = new LinkedList<>();

			// 입력 받은 문서 정보를 큐에 담음
			for (int i = 0; i < N; i++) {
				queue.offer(new Doc(i, Integer.parseInt(st.nextToken())));
			}

			// 인쇄 순서 저장 변수 초기화
			int seq = 0;

			MAIN_LOOP: while (!queue.isEmpty()) {
				// 큐에서 문서 하나를 꺼내옴
				Doc doc = queue.poll();

				Iterator<Doc> iterator = queue.iterator();

				// 큐에 남아있는 문서들 중에서 꺼내온 문서보다 중요도가 높은 문서가 있는지 검사
				while (iterator.hasNext()) {
					// 중요도가 더 높은 문서를 발견한 경우
					if (doc.imp < iterator.next().imp) {
						// 꺼내온 문서를 다시 큐에 넣음
						queue.offer(doc);

						continue MAIN_LOOP;
					}
				}

				// 꺼내온 문서의 중요도가 현재 가장 높은 경우 인쇄 순서 1증가
				seq++;

				// 찾는 문서 일 경우 루프 종료
				if (doc.idx == M) {
					break;
				}
			}

			sb.append(seq).append(NEW_LINE);
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}

	/**
	 * 문서 이너 클래스
	 * 
	 * @author devetude
	 */
	private static class Doc {
		public int idx;
		public int imp;

		/**
		 * 생성자
		 * 
		 * @param idx
		 * @param imp
		 */
		Doc(int idx, int imp) {
			this.idx = idx;
			this.imp = imp;
		}
	}
}