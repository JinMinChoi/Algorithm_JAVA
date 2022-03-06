package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q19638 {
    private static int n, h, t; //n : 거인 수 / h : 키 / t : 망치 횟수
    private static int cnt;
    private static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            int giant_h = Integer.parseInt(br.readLine());
            pq.add(giant_h);
        }

        /*for (Integer integer : pq) {
            System.out.println(integer);
        }*/
        while (true) {
            int giant_max_h = pq.poll();

            if (giant_max_h < h) {
                break;
            } else {
                if (t == 0 || giant_max_h <= 1) {
                    ans = giant_max_h;
                    break;
                }
                pq.add(giant_max_h / 2);
                t--;
                cnt++;
            }
        }

        System.out.println(ans == 0 ? "YES" + "\n" + cnt : "NO" + "\n" + ans);
    }
}
