package boj_12791;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 12791번 (Starman) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/12791
 * @author devetude
 */
public class Main {
	// 문자열 상수
	private static final String NEW_LINE = "\n";
	private static final String SPACE = " ";

	// 앨범 저장 해시맵
	private static HashMap<Integer, String[]> albums = new HashMap<>();

	public static void main(String args[]) throws Exception {
		// 앨범 저장 해시맵을 만듬
		albums.put(1967, new String[] { "DavidBowie" });
		albums.put(1969, new String[] { "SpaceOddity" });
		albums.put(1970, new String[] { "TheManWhoSoldTheWorld" });
		albums.put(1971, new String[] { "HunkyDory" });
		albums.put(1972, new String[] { "TheRiseAndFallOfZiggyStardustAndTheSpidersFromMars" });
		albums.put(1973, new String[] { "AladdinSane", "PinUps" });
		albums.put(1974, new String[] { "DiamondDogs" });
		albums.put(1975, new String[] { "YoungAmericans" });
		albums.put(1976, new String[] { "StationToStation" });
		albums.put(1977, new String[] { "Low", "Heroes" });
		albums.put(1979, new String[] { "Lodger" });
		albums.put(1980, new String[] { "ScaryMonstersAndSuperCreeps" });
		albums.put(1983, new String[] { "LetsDance" });
		albums.put(1984, new String[] { "Tonight" });
		albums.put(1987, new String[] { "NeverLetMeDown" });
		albums.put(1993, new String[] { "BlackTieWhiteNoise" });
		albums.put(1995, new String[] { "1.Outside" });
		albums.put(1997, new String[] { "Earthling" });
		albums.put(1999, new String[] { "Hours" });
		albums.put(2002, new String[] { "Heathen" });
		albums.put(2003, new String[] { "Reality" });
		albums.put(2013, new String[] { "TheNextDay" });
		albums.put(2016, new String[] { "BlackStar" });

		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Q = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (Q-- != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			// 버퍼를 통해 결과 값을 만듬
			StringBuilder sb2 = new StringBuilder();
			int albumCnt = 0;

			for (int i = S; i <= E; i++) {
				String[] musicNames = albums.get(i);

				if (musicNames != null) {
					for (String musicName : musicNames) {
						albumCnt++;
						sb2.append(i).append(SPACE).append(musicName).append(NEW_LINE);
					}
				}
			}

			sb.append(albumCnt).append(NEW_LINE);
			sb.append(sb2);
		}

		br.close();

		// 결과 값 한꺼번에 출력
		System.out.println(sb.toString());
	}
}