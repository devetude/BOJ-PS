package boj_9653;

/**
 * 백준 온라인 저지 9653번 (스타워즈 로고) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/9653
 * @author devetude
 */
public class Main {
	// 개행 문자열 상수
	private static final char NEW_LINE = '\n';

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();

		sb.append("    8888888888  888    88888").append(NEW_LINE);
		sb.append("   88     88   88 88   88  88").append(NEW_LINE);
		sb.append("    8888  88  88   88  88888").append(NEW_LINE);
		sb.append("       88 88 888888888 88   88").append(NEW_LINE);
		sb.append("88888888  88 88     88 88    888888").append(NEW_LINE);
		sb.append(NEW_LINE);
		sb.append("88  88  88   888    88888    888888").append(NEW_LINE);
		sb.append("88  88  88  88 88   88  88  88").append(NEW_LINE);
		sb.append("88 8888 88 88   88  88888    8888").append(NEW_LINE);
		sb.append(" 888  888 888888888 88  88      88").append(NEW_LINE);
		sb.append("  88  88  88     88 88   88888888").append(NEW_LINE);

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}