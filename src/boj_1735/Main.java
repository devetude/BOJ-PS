package boj_1735;
import java.util.Scanner;

/**
 * 백준 온라인 저지 1735번 (분수 합) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/1735
 * @author devetude
 */
public class Main {
	public static void main(String args[]) {
		// 입력 값을 받음
		Scanner sc = new Scanner(System.in);
		int nA = sc.nextInt();
		int dA = sc.nextInt();
		int nB = sc.nextInt();
		int dB = sc.nextInt();
		sc.close();

		// 두 분수의 합을 구함
		int nC = nA * dB + nB * dA;
		int dC = dA * dB;
		int nTmp = nC;
		int dTmp = dC;

		// 두 분수의 합의 분자와 분모의 최대공약수를 구함
		while (true) {
			if (dTmp == 0) {
				// 분자와 분모를 최대공약수로 나눠서 기약 분수 형태로 만듬
				nC /= nTmp;
				dC /= nTmp;
				break;
			}

			int tmp = dTmp;
			dTmp = nTmp % dTmp;
			nTmp = tmp;
		}

		// 결과 값 출력
		System.out.println(nC + " " + dC);
	}
}