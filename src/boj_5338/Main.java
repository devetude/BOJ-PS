package boj_5338;

/**
 * 백준 온라인 저지 5338번 (마이크로소프트 로고) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/5338
 * @author devetude
 */
public class Main {
	private static final char NEW_LINE = '\n';

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		sb.append("       _.-;;-._").append(NEW_LINE);
		sb.append("'-..-'|   ||   |").append(NEW_LINE);
		sb.append("'-..-'|_.-;;-._|").append(NEW_LINE);
		sb.append("'-..-'|   ||   |").append(NEW_LINE);
		sb.append("'-..-'|_.-''-._|").append(NEW_LINE);

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}