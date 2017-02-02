package res;

/**
 * 환경설정 클래스
 * 
 * @author devetude
 */
public class Setting {
	// 언어 코드 상수 (Java : 3)
	public static final String LANGUAGE_CODE = "3";

	// 코드 공개 상수 (open, close)
	public static final String CODE_OPEN = "open";

	// 소스 경로 상수
	public static final String SRC_PATH = System.getProperty("user.dir") + "/src/boj_{problem_id}/Main.java";
}