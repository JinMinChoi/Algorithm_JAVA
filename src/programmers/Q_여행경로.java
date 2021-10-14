//https://programmers.co.kr/learn/courses/30/lessons/43164
package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q_여행경로 {
    private static List<String> answerList;
    private static boolean[] visit;

    public static void main(String[] args) {
        Q_여행경로 q = new Q_여행경로();

        String[][] t = {
                {"ICN", "SFO"},
                {"ICN", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "ICN"},
                {"ATL", "SFO"}
        };

        String[] ret = q.solution(t);

        for (String s : ret) {
            System.out.print(s + " ");
        }
    }

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visit = new boolean[tickets.length];
        answerList = new ArrayList<>();
        int count = 0;
        dfs(count, "ICN", "ICN", tickets);
        Collections.sort(answerList);

        return answer = answerList.get(0).split(" ");
    }

    private void dfs(int count, String start, String answer, String[][] tickets) {
        if (count == tickets.length) {
            answerList.add(answer);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visit[i] && tickets[i][0].equals(start)) {
                visit[i] = true;
                dfs(count + 1, tickets[i][1], answer + " " + tickets[i][1], tickets);
                visit[i] = false;
            }
        }
    }
}
