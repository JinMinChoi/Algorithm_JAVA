package level.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 실패!!!!!!
 */
public class Q12865_x {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Info> list = new ArrayList<>(n);
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.add(new Info(w, v));
        }
        Collections.sort(list);

        /*for(Info a : list){
            System.out.println(a.w + " " + a.v);
        }*/

        dp[0] = list.get(0).w;
        //.out.println(dp[0]);

        int ans = list.get(0).v;

        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1];
            if (dp[i] < dp[i - 1] + list.get(i).w) {
                dp[i] = dp[i - 1] + list.get(i).w;
                ans += list.get(i).v;
            }

            if(dp[i] <= k) break;
        }

        System.out.println(ans);
    }

    private static class Info implements Comparable<Info> {
        int w;
        int v;

        public Info(int w, int v) {
            this.w = w;
            this.v = v;
        }

        @Override
        public int compareTo(Info o) {
            return this.w - o.w;
        }
    }
}
