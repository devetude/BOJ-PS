package boj_submitter;

/**
 * 백준 온라인 저지 답안 제출기 메인 클래스
 *
 * @author devetude
 */
public class Main {
	// 제출 문제 번호 상수
	private static final String PROBLEM_ID = "1000";

	/**
	 * 메인 메소드
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
		String source = Process.getSource(PROBLEM_ID);

		if (source == null) {
			System.out.println("제출을 위한 코드 읽기 실패");
			
			return;
		}

		System.out.println("제출을 위한 코드 읽기 성공");

		if (!Process.signIn(User.BOJ_ID, User.BOJ_PASSWORD)) {
			System.out.println("백준 온라인 저지 로그인 실패");
			
			return;
		}

		System.out.println("백준 온라인 저지 로그인 성공");

		if (!Process.submit(PROBLEM_ID, source)) {
			System.out.println("정답 제출 실패");
			
			return;
		}

		System.out.println("정답 제출 완료");
	}
}