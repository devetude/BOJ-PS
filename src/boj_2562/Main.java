package boj_2562;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 온라인 저지 2562번 (최대값) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/2562
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 버퍼를 이용해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr1 = new int[9];
		int[] arr2 = new int[100];

		for (int i = 0; i < 9; i++) {
			int num = Integer.parseInt(br.readLine());
			arr1[i] = num;
			arr2[num] = i;
		}

		br.close();

		// arr1 오름차순으로 정렬
		Arrays.sort(arr1);

		// 최대값, 최대값을 인덱스를 구함
		int maxNum = arr1[8];
		int maxIndex = arr2[maxNum];

		// 결과 값 출력
		System.out.println(maxNum);
		System.out.println(maxIndex + 1);
	}
}