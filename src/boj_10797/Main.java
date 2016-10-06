package boj_10797;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 10797번 (10부제) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/10797
 * @author devetude
 */
public class Main {
	public static void main(String[] args) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String day = br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();

		int violateCounts = 0;

		// 위반 차량의 숫자를 셈
		for (int i = 0; i < 5; i++) {
			if (day.equals(st.nextToken())) {
				violateCounts++;
			}
		}

		br.close();

		// 결과 값 출력
		System.out.println(violateCounts);
	}
}