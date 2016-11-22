package boj_1834;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 1834번 (나머지와 몫이 같은 수) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1834
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		br.close();

		// 풀이과정
		// 생각1. 나머지는 1부터 N - 1까지 범위에서 나타남
		// 생각2. 나머지와 몫이 같으면 나머지가 i일 때, 몫은 i * N이 되야함
		// 생각3. 나머지와 몫이 같은 수는 결국 i * N + i가 됨
		// 생각4. 결국, 공차가 N + 1이면서 1 부터 N - 1항 까지의 합을 구하면 됨
		// 생각5. 등차수열의 합 공식 (n * (a + l) / 2 (단 a는 첫항, l은 끝항)) 이용
		// 생각7. 등차수열 합 공식에 대입한 아래의 식을 정리
		// (N - 1) * (N + 1 + N^2 - 1) / 2
		// = (N - 1) * (N + 1 + N^2 - 1) / 2
		// = (N - 1) * (N + N^2) / 2
		// = (N - 1) * N * (N + 1) / 2
		System.out.println((N - 1) * N * (N + 1) / 2);
	}
}