package inflearnLecture.question.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q75 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Info> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            lists.add(new Info(cost, day));
        }

        Collections.sort(lists);
        int maxDay = lists.get(0).day;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int curIdx = 0;
        int sum = 0;
        for (int i = maxDay; i > 0; i--) {
            while (curIdx < n) {
                if (lists.get(curIdx).day < i) break;
                pq.add(lists.get(curIdx).cost);
                curIdx++;
            }

            if (pq.size() != 0) sum += pq.poll();
        }
        System.out.println(sum);
    }

    private static class Info implements Comparable<Info> {
        int cost;
        int day;

        public Info(int cost, int day) {
            this.cost = cost;
            this.day = day;
        }

        @Override
        public int compareTo(Info i) {
            if (this.day == i.day) {
                return i.cost - this.cost;
            }
            return i.day - this.day;
        }
    }
}
