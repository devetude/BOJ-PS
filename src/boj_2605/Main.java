package boj_2605;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2605번 (줄 세우기) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2605
 * @author devetude
 */
public class Main {
	// 공백 문자 상수
	private static final char SPACE = ' ';

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		br.close();

		// 링크드리스트 객체 변수 초기화
		LinkedList<Integer> linkedList = new LinkedList<>();

		// 문제의 조건에 맞게 해당 위치에 학생들을 배치
		for (int i = 1; i <= N; i++) {
			linkedList.add(linkedList.size() - Integer.parseInt(st.nextToken()), i);
		}

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		for (int item : linkedList) {
			sb.append(item).append(SPACE);
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}