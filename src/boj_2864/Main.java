package boj_2864;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2864번 (5와 6의 차이) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String A = st.nextToken();
		String B = st.nextToken();
		br.close();

		StringBuilder sb = new StringBuilder();

		// 최소 값은 6을 모두 5로 바꾼 것
		sb.append(Integer.parseInt(A.replaceAll("6", "5")) + Integer.parseInt(B.replaceAll("6", "5"))).append(" ");

		// 최대 값은 5를 모두 6으로 바꾼 것
		sb.append(Integer.parseInt(A.replaceAll("5", "6")) + Integer.parseInt(B.replaceAll("5", "6")));

		// 결과 값 출력
		System.out.println(sb.toString());
	}
}