package boj_1350;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1350번 (진짜 공간) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1350
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] fileSizes = new int[N];

		for (int i = 0; i < N; i++) {
			fileSizes[i] = Integer.parseInt(st.nextToken());
		}

		int clusterSize = Integer.parseInt(br.readLine());

		br.close();

		// 클러스터 갯수 변수
		long clusterCounts = 0;

		// 루프를 돌면서 필요한 클러스터 갯수를 구함
		for (int i = 0; i < N; i++) {
			clusterCounts += fileSizes[i] / clusterSize;

			if (fileSizes[i] % clusterSize != 0) {
				clusterCounts++;
			}
		}

		// 결과 값 출력
		System.out.println(clusterCounts * clusterSize);
	}
}