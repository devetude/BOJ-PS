package boj_submitter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 처리 클래스
 *
 * @author devetude
 */
public class Process {
	/**
	 * 로그인 메소드
	 * 
	 * @param id
	 * @param password
	 * @return
	 */
	public static boolean signIn(String id, String password) {
		if (id.length() == 0) {
			System.out.print("백준 온라인 저지 아이디를 입력해주세요 : ");
			id = new Scanner(System.in).nextLine();
		}

		if (password.length() == 0) {
			System.out.print("백준 온라인 저지 비밀번호를 입력해주세요 : ");
			password = new Scanner(System.in).nextLine();
		}

		Map<String, String> params = new HashMap<String, String>();
		params.put("login_user_id", id);
		params.put("login_password", password);

		try {
			String htmlBody = HTTPRequest.post(URL.SIGN_IN, params);

			if (htmlBody.indexOf("<meta name=\"username\" content=\"\">") != -1) {
				throw new Exception();
			}
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	/**
	 * 정답 제출시 필요한 CSRF key를 가져오는 메소드
	 * 
	 * @param problemID
	 * @return
	 */
	private static String getSubmitCSRFKey(String problemID) {
		try {
			String htmlBody = HTTPRequest.post(URL.SUBMIT.replace("{problem_id}", problemID), null);
			htmlBody = htmlBody.substring(htmlBody.indexOf("csrf_key\" value=\""));

			return htmlBody.substring(17, htmlBody.indexOf("\">"));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 정답 제출 메소드
	 * 
	 * @param problemID
	 * @param source
	 * @return
	 */
	public static boolean submit(String problemID, String source) {
		String csrfKey = getSubmitCSRFKey(problemID);

		if (csrfKey == null) {
			return false;
		}

		else {
			Map<String, String> params = new HashMap<String, String>();
			params.put("problem_id", problemID);
			params.put("language", Setting.LANGUAGE_CODE);
			params.put("code_open", Setting.CODE_OPEN);
			params.put("csrf_key", csrfKey);
			params.put("source", source);

			try {
				HTTPRequest.post(URL.SUBMIT.replace("{problem_id}", problemID), params);
			} catch (Exception e) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 소스를 읽어오는 메소드
	 * 
	 * @param problemID
	 * @return
	 */
	public static String getSource(String problemID) {
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(Setting.SRC_PATH.replace("{problem_id}", problemID)));
			String line = null;
			StringBuilder sb = new StringBuilder();

			br.readLine();

			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}

			return sb.substring(0, sb.length() - 1).toString();
		} catch (Exception e) {
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
				}
			}
		}

		return null;
	}
}