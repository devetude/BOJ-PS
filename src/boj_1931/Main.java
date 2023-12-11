package boj_1931;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Schedule[] schedules = new Schedule[T];

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            schedules[i] = new Schedule(startTime, endTime);
        }

        Arrays.sort(schedules);

        int lastEndTime = 0;
        int availableMaxRoomCount = 0;

        for (Schedule schedule : schedules) {
            int startTime = schedule.startTime;
            int endTime = schedule.endTime;

            if (lastEndTime <= startTime) {
                ++availableMaxRoomCount;
                lastEndTime = endTime;
            }
        }

        br.close();

        System.out.println(availableMaxRoomCount);
    }

    private static class Schedule implements Comparable<Schedule> {
        int startTime;
        int endTime;

        public Schedule(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Schedule schedule) {
            if (this.endTime == schedule.endTime) {
                return this.startTime - schedule.startTime;
            } else {
                return this.endTime - schedule.endTime;
            }
        }
    }
}
