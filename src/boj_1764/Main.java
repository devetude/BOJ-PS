package boj_1764;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1764번 (듣보잡) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1764
 * @author devetude
 */
public class Main {
	// 개행 문자열 상수
	private static final String NEW_LINE = "\n";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, Boolean> hashMap = new HashMap<>();

		for (int i = 0; i < N + M; i++) {
			String name = br.readLine();

			// 해시맵에 있는 이름일 경우 true로 설정
			if (hashMap.containsKey(name)) {
				hashMap.put(name, true);
			}

			// 해시맵에 없는 이름일 경우 false로 설정
			else {
				hashMap.put(name, false);
			}
		}

		br.close();

		Iterator<String> iterator = hashMap.keySet().iterator();
		ArrayList<String> arrayList = new ArrayList<>();

		while (iterator.hasNext()) {
			String name = iterator.next();

			// 해시맵에 true로 설정되어있는 값을 배열리스트에 담음
			if (hashMap.get(name)) {
				arrayList.add(name);
			}
		}

		// 사전순으로 이름 정렬
		Collections.sort(arrayList);

		// 버퍼를 통해 결과 값을 만듬
		StringBuilder sb = new StringBuilder();
		sb.append(arrayList.size()).append(NEW_LINE);

		for (String name : arrayList) {
			sb.append(name).append(NEW_LINE);
		}

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}