//https://programmers.co.kr/learn/courses/30/lessons/85002
package programmers.weekly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q_6주차 {
    public static void main(String[] args) {
        Q_6주차 q = new Q_6주차();

        int[] w = {50, 82, 75, 120};
        String[] h = {"NLWL", "WNLL", "LWNW", "WWLN"};
        int[] ans = q.solution(w, h);

        for (int an : ans) {
            System.out.print(an + " ");
        }
    }

    public int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];

        List<Integer> boxerWeights = new ArrayList<>();
        List<Info> infos = new ArrayList<>();

        for (int i = 0; i < weights.length; i++) {
            boxerWeights.add(weights[i]);
        }

        for (int i = 0; i < head2head.length; i++) { // i = 나(i)의 복싱 경기수
            int winCount = 0;
            int totalCount = 0;
            int overWinCount = 0;
            int weightMe = boxerWeights.get(i);

            for (int j = 0; j < head2head[i].length(); j++) { // j = 상대 선수와 경기
                char round = head2head[i].charAt(j);

                int weightYou = boxerWeights.get(j);

                if (round == 'N' || i == j) continue;

                if (round == 'W') {
                    winCount++;
                    if (weightMe < weightYou) {
                        overWinCount++;
                    }
                }
                totalCount++;
            }

            double winRate = (totalCount > 0) ? (double) winCount / totalCount : 0.0;

            infos.add(new Info(new Boxer(i + 1, weightMe), winRate, overWinCount));
        }

        Collections.sort(infos);

        for (int i = 0; i < answer.length; i++) {
            answer[i] = infos.get(i).boxer.index;
        }
        return answer;
    }

    private static class Info implements Comparable<Info> {
        Boxer boxer;
        Double winRate;
        int overWinCnt;

        public Info(Boxer boxer, double winRate, int overWinCnt) {
            this.boxer = boxer;
            this.winRate = winRate;
            this.overWinCnt = overWinCnt;
        }

        @Override
        public int compareTo(Info o) {
            if (this.winRate.equals(o.winRate)) {
                if (this.overWinCnt == o.overWinCnt) {
                    if (this.boxer.weight == o.boxer.weight) {
                        return this.boxer.index - o.boxer.index;
                    }
                    return o.boxer.weight - this.boxer.weight;
                }
                return o.overWinCnt - this.overWinCnt;
            }
            return o.winRate.compareTo(this.winRate);
        }
    }

    private static class Boxer {
        int index;
        int weight;

        public Boxer(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }
}
