package inflearnLecture.question.recursion2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q84 {
    private static int day;
    private static Earn[] earns;
    private static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        day = Integer.parseInt(br.readLine());
        earns = new Earn[day + 1];
        ans = Integer.MIN_VALUE;

        for (int i = 1; i <= day; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int period = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            earns[i] = new Earn(period, cost);
        }

        for (int i = 1; i <= day; i++) {
            dfs(i, 0);
        }

        System.out.println(ans);
    }

    private static void dfs(int first_day, int sum) {
        if (first_day >= day) {
            ans = Math.max(ans, sum);
            return;
        }

        dfs(first_day + earns[first_day].period, sum + earns[first_day].cost);
    }

    private static class Earn {
        int period;
        int cost;

        public Earn(int period, int cost) {
            this.period = period;
            this.cost = cost;
        }
    }
}
