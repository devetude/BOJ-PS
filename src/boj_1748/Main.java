package boj_1748;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 1748번 (수 이어 쓰기 1) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1748
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		br.close();

		// N을 밑이 10인 로그를 취한 결과 저장 변수
		int log10N = (int) Math.floor(Math.log10(N));

		// 자릿수 저장 변수
		int len = 0;

		// 루프를 돌며 자릿수를 더함
		for (int i = 0; i < log10N; i++) {
			// (1~9 : 총 9개, 1자릿수 -> 9*1=9자리)
			// (10~99 : 총 90개, 2자릿수 -> 90*2=180자리)
			// (10^n~10^(n+1)-1 : 총 9*10^(n-1)개, n자릿수 -> 9*10^(n-1)*n)
			len += 9 * (int) (Math.pow(10, i)) * (i + 1);
		}

		// 나머지 자투리 자릿수를 더함
		len += (N - (int) Math.pow(10, log10N) + 1) * (log10N + 1);

		// 결과 값 출력
		System.out.println(len);
	}
}