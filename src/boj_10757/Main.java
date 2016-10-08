package boj_10757;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 10757번 (큰 수 A+B) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/10757
 * @author devetude
 */
public class Main {
	public static void main(String[] args) throws Exception {
		// 버퍼를 이용해 입력을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();

		BigInteger A = new BigInteger(st.nextToken());
		BigInteger B = new BigInteger(st.nextToken());

		// 결과 값 출력
		System.out.println(A.add(B));
	}
}