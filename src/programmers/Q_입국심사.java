//https://programmers.co.kr/learn/courses/30/lessons/43238
package programmers;

import java.util.Arrays;

public class Q_입국심사 {
    public static void main(String[] args) {
        int n = 21;
        int[] times = {4, 5, 8};
        Q_입국심사 q = new Q_입국심사();
        System.out.println(q.solution(n, times));

    }

    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);

        long left = 0;
        long right = (long) n * times[times.length - 1];

        while (left <= right) {
            long sum = 0;
            long mid = (left + right) / 2;

            for (int time : times) {
                sum += mid / time;
            }

            if (sum < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}
