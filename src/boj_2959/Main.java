package boj_2959;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준 온라인 저지 2959번 (거북이) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/2959
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 입력 값을 받음
		Scanner sc = new Scanner(System.in);
		int[] inputs = new int[4];

		for (int i = 0; i < 4; i++) {
			inputs[i] = sc.nextInt();
		}

		sc.close();

		// 입력 값 정렬
		Arrays.sort(inputs);

		// 결과 값 출력 (직사각형이나 정사각형을 만드는데 넓이를 결정 짓는 두 변은 가장 짧은 변과 두번째로 긴 변)
		System.out.println(inputs[0] * inputs[2]);
	}
}