package boj_10172;

/**
 * 백준 온라인 저지 10172번 (개) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/10172
 * @author devetude
 */
public class Main {
	public static void main(String args[]) throws Exception {
		// 개 모양 문자열을 버퍼를 이용하여 만듬
		StringBuilder sb = new StringBuilder();
		sb.append("|\\_/|\n");
		sb.append("|q p|   /}\n");
		sb.append("( 0 )\"\"\"\\\n");
		sb.append("|\"^\"`    |\n");
		sb.append("||_/=\\\\__|");

		// 결과 값 출력
		System.out.println(sb.toString());
	}
}