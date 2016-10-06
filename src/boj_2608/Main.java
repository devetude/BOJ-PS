package boj_2608;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 백준 온라인 저지 2608번 (로마 숫자) 문제풀이
 * 
 * @see https://www.acmicpc.net/problem/2608
 * @author devetude
 */
public class Main {
	// 로마 문자 -> 숫자 해시맵
	private static HashMap<String, Integer> ROM_HASHMAP_1 = new HashMap<>();

	// 숫자 -> 로마 문자 해시맵
	private static HashMap<Integer, String> ROM_HASHMAP_2 = new HashMap<>();

	public static void main(String args[]) throws Exception {
		// 해시맵 초기화
		ROM_HASHMAP_1.put("I", 1);
		ROM_HASHMAP_1.put("V", 5);
		ROM_HASHMAP_1.put("X", 10);
		ROM_HASHMAP_1.put("L", 50);
		ROM_HASHMAP_1.put("C", 100);
		ROM_HASHMAP_1.put("D", 500);
		ROM_HASHMAP_1.put("M", 1000);
		ROM_HASHMAP_2.put(1, "I");
		ROM_HASHMAP_2.put(5, "V");
		ROM_HASHMAP_2.put(10, "X");
		ROM_HASHMAP_2.put(50, "L");
		ROM_HASHMAP_2.put(100, "C");
		ROM_HASHMAP_2.put(500, "D");
		ROM_HASHMAP_2.put(1000, "M");

		// 버퍼를 이용하여 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String romA = br.readLine();
		String romB = br.readLine();
		br.close();

		// 입력 받은 두 로마 문자를 더함
		int sumAB = romStr2Num(romA) + romStr2Num(romB);

		// 더한 결과 값을 출력
		System.out.println(sumAB);

		// 더한 결과 값을 로마 문자로 출력
		System.out.println(num2RomStr(sumAB));
	}

	/**
	 * 로마 문자를 숫자로 변환하는 메소드
	 * 
	 * @param rom
	 * @return
	 */
	private static int romStr2Num(String rom) {
		int romLen = rom.length();
		int res = 0;

		// 길이가 1인 경우 로마 문자의 숫자 값을 리턴
		if (romLen == 1) {
			return ROM_HASHMAP_1.get(rom);
		}

		for (int i = 0; i < romLen; i++) {
			// 마지막 문자라면 로마 문자의 숫자 값을 더하고 끝냄
			if (i == romLen - 1) {
				res += ROM_HASHMAP_1.get(String.valueOf(rom.charAt(i)));
				break;
			}

			int current = ROM_HASHMAP_1.get(String.valueOf(rom.charAt(i)));
			int next = ROM_HASHMAP_1.get(String.valueOf(rom.charAt(i + 1)));

			// 현재 로마 문자의 크기가 다음 로마 문자의 크기보다 클 경우
			if (current > next) {
				// 현재 로마 문자의 숫자 값을 결과 값에 더함
				res += current;
			}

			// 현재 로마 문자의 크기가 다음 로마 문자의 크기보다 작을 경우
			else if (current < next) {
				// 다음 로마 문자의 숫자 값에서 현재 로마 문자의 숫자 값을 뺀 값을 결과 값에 더함
				res += next - current;

				// 변환 포인터를 1 증가 (다음 것 까지 처리했으므로)
				i++;
			}

			// 현재 로마 문자의 크기가 다음 로마 문자의 크기와 같을 경우
			else {
				// 2번 또는 3번 반복되는 만큼 결과 값에 추가 후 포인터를 해당 횟수 만큼 증가
				if (i <= romLen - 3 && current == ROM_HASHMAP_1.get(String.valueOf(rom.charAt(i + 2)))) {
					res += current * 3;
					i += 2;
				}

				else {
					res += current * 2;
					i++;
				}
			}
		}

		return res;
	}

	/**
	 * 숫자를 로마 문자로 변환하는 메소드
	 * 
	 * @param num
	 * @return
	 */
	private static String num2RomStr(int num) {
		String numStr = String.valueOf(num);
		int numStrLen = numStr.length();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < numStrLen; i++) {
			String dStr = String.valueOf(numStr.charAt(i));

			// 자릿수
			int d = (int) Math.pow(10, numStrLen - 1 - i);

			// 숫자 값
			int n = Integer.parseInt(dStr);

			// 실제 값 (실제 값 = 자릿수 * 숫자 값)
			int v = d * n;

			// 숫자 값이 1 ~ 3인 경우
			if (1 <= n && n <= 3) {
				String rom = ROM_HASHMAP_2.get(d);

				for (int j = 0; j < n; j++) {
					sb.append(rom);
				}
			}

			// 숫자 값이 4인 경우
			else if (n == 4) {
				sb.append(ROM_HASHMAP_2.get(d));
				sb.append(ROM_HASHMAP_2.get(5 * d));
			}

			// 숫자 값이 5인 경우
			else if (n == 5) {
				sb.append(ROM_HASHMAP_2.get(v));
			}

			// 숫자 값이 6 ~ 8인 경우
			else if (6 <= n && n <= 8) {
				sb.append(ROM_HASHMAP_2.get(5 * d));
				String rom = ROM_HASHMAP_2.get(d);

				for (int j = 0; j < n - 5; j++) {
					sb.append(rom);
				}
			}

			// 숫자 값이 9인 경우
			else if (n == 9) {
				sb.append(ROM_HASHMAP_2.get(d));
				sb.append(ROM_HASHMAP_2.get(d * 10));
			}
		}

		return sb.toString();
	}
}