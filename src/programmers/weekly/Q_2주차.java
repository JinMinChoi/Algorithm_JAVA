//https://programmers.co.kr/learn/courses/30/lessons/83201
package programmers.weekly;

public class Q_2주차 {
    public static void main(String[] args) {
        int[][] s = {
                {100, 90, 98, 88, 65},
                {50, 45, 99, 85, 77},
                {47, 88, 95, 80, 67},
                {61, 57, 100, 80, 65},
                {24, 90, 94, 75, 65}};

        int[][] s2 = {
                {70, 70, 70, 70},
                {50, 50, 50, 50},
                {70, 70, 70, 70},
                {50, 50, 50, 50}
        };
        Q_2주차 q = new Q_2주차();
        System.out.println(q.solution(s2));

    }

    public String solution(int[][] scores) {
        String answer = "";
        double[] avr = new double[scores.length];

        for (int i = 0; i < scores.length; i++) {
            int max = -1;
            int maxEqualCount = -1;
            int min = 101;
            int minEqualCount = -1;

            int myScore = scores[i][i];

            for (int j = 0; j < scores[i].length; j++) {
                max = Math.max(max, scores[j][i]);
                min = Math.min(min, scores[j][i]);
            }

            for (int j = 0; j < scores[i].length; j++) {
                if (scores[j][i] == max) {
                    maxEqualCount++;
                }

                if (scores[j][i] == min) {
                    minEqualCount++;
                }
            }

            if ((myScore == max && maxEqualCount == 0) || (myScore == min && minEqualCount == 0)) {
                scores[i][i] = -1;
            }
        }

        for (int i = 0; i < scores.length; i++) {
            int cnt = 0;
            double sum = 0.0;
            for (int j = 0; j < scores[i].length; j++) {
                if (scores[j][i] != -1) {
                    cnt++;
                    sum += scores[j][i];
                }
            }

            avr[i] = sum / cnt;
        }
        for (double value : avr) {
            if (value >= 90.0) {
                answer += "A";
            } else if (value >= 80.0) {
                answer += "B";
            } else if (value >= 70.0) {
                answer += "C";
            } else if (value >= 50.0) {
                answer += "D";
            } else answer += "F";

        }

        return answer;
    }
}
