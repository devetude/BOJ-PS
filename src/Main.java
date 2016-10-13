import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 번 () 문제풀이
 *
 * @see https://www.acmicpc.net/problem/
 * @author devetude
 */
public class Main {
	// 캐시 배열 ([인덱스] = 카드 배열 수)
	private static int[] cache = null;

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String numStr = br.readLine();
		br.close();

		// 입력 받은 문자열을 길이를 구함
		int numStrLen = numStr.length();

		// 캐시 배열 초기화
		cache = new int[numStrLen];

		// 결과 값 출력
		System.out.println(count(numStr, numStrLen, 0));
	}

	/**
	 * 카드 배열 수를 구하는 재귀 메소드
	 * 
	 * @param numStr
	 * @param numStrLen
	 * @param index
	 * @return
	 */
	private static int count(String numStr, int numStrLen, int index) {
		// 기저조건1 : 마지막 카드가 0이 될 경우 불가능함으로 0을 리턴
		if (index == numStrLen - 1 && numStr.charAt(index) == '0') {
			return 0;
		}

		// 기저조건2 : 인덱스가 문자열의 끝에 도달했거나 그 이상 일 경우 1가지 경우임으로 1을 리턴
		if (index >= numStrLen - 1) {
			return 1;
		}

		// 캐시 배열에 캐시 값이 있을 경우 캐시를 사용
		if (cache[index] != 0) {
			return cache[index];
		}

		// 카드 배열 갯수를 0으로 초기화
		int counts = 0;

		// 다음 카드가 1자리 숫자 일 경우 (0인 경우 제외)
		if (0 < Integer.parseInt(numStr.substring(index, index + 1))) {
			counts += count(numStr, numStrLen, index + 1);

			// 다음 카드가 2자리 숫자 일 경우 (0으로 시작하는 숫자 제외, 34보다 큰 숫자 제외)
			if (Integer.parseInt(numStr.substring(index, index + 2)) <= 34) {
				counts += count(numStr, numStrLen, index + 2);
			}
		}

		// 결과 값을 캐시에 저장 및 리턴
		return cache[index] = counts;
	}
}