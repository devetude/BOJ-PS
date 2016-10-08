package boj_10827;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 10827번 (a^b) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/10827
 * @author devetude
 */
public class Main {
	public static void main(String[] args) throws Exception {
		// 버퍼를 이용해 입력을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();

		BigDecimal a = new BigDecimal(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		// 결과 값 출력 (지수승의 형태로 나오는 것을 방지하기 위해 toPlainString() 메소드 사용)
		System.out.println(a.pow(b).toPlainString());
	}
}