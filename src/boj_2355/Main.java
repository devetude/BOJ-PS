package boj_2355;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 2355번 (시그마) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/2355
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long i = Long.parseLong(st.nextToken());
		long j = Long.parseLong(st.nextToken());
		br.close();

		// 앞에서 입력받은 숫자가 더 큰 경우 앞뒤 숫자를 변경
		if (i > j) {
			long tmp = i;
			i = j;
			j = tmp;
		}

		// 결과 값 출력
		// 등차수열의 합 공식 : n * (a + l) / 2
		System.out.println((j - i + 1L) * (i + j) / 2L);
	}
}