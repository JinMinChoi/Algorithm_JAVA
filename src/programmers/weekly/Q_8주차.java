//https://programmers.co.kr/learn/courses/30/lessons/86491
package programmers.weekly;

import java.util.ArrayList;
import java.util.List;

public class Q_8주차 {
    public static void main(String[] args) {
        Q_8주차 q = new Q_8주차();

        int[][] s = {
                {10, 7},
                {12, 3},
                {8, 15},
                {14, 7},
                {5, 15}
        };

        System.out.println(q.solution(s));
    }

    public int solution(int[][] sizes) {
        List<Info> list = new ArrayList<>();

        for (int i = 0; i < sizes.length; i++) {
            int a = sizes[i][0];
            int b = sizes[i][1];

            if (a > b) {
                list.add(new Info(b, a));
            } else {
                list.add(new Info(a, b));
            }
        }

        int max1 = 0;
        int max2 = 0;

        for (Info info : list) {
            max1 = Math.max(max1, info.min);
            max2 = Math.max(max2, info.max);
        }

        return max1 * max2;
    }

    private static class Info {
        int min;
        int max;

        public Info(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
}
