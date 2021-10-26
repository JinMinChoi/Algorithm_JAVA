package programmers.weekly;

import java.util.ArrayList;
import java.util.List;

public class Q_12주차 {
    private static boolean[] visit;
    private static List<DungeonInfos> list;
    private static int answer = -1;

    public static void main(String[] args) {
        int k = 80;

        int[][] d = {
                {80, 20},
                {50, 40},
                {30, 10}
        };

        Q_12주차 q = new Q_12주차();

        System.out.println(q.solution(k, d));
    }

    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        list = new ArrayList<>();

        for (int i = 0; i < dungeons.length; i++) {
            list.add(new DungeonInfos(dungeons[i][0], dungeons[i][1]));
        }

        dfs(k, 0);

        return answer;
    }

    private void dfs(int curTiredValue, int curCount) {

        if (curTiredValue >= 0) {
            answer = Math.max(answer, curCount);
        }

        for (int i = 0; i < list.size(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                if (curTiredValue >= list.get(i).need) {
                    dfs(curTiredValue - list.get(i).use, curCount + 1);
                }
                visit[i] = false;
            }
        }
    }

    private static class DungeonInfos {
        int need;
        int use;

        public DungeonInfos(int need, int use) {
            this.need = need;
            this.use = use;
        }
    }
}
