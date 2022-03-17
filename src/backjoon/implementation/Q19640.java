package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q19640 {
    private static int n, m, k;
    private static ArrayList<Person>[] people;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        people = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            people[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            people[i % m].add(new Person(
                    i,
                    i % m,
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        PriorityQueue<Person> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.day == o2.day) {
                if (o1.hurry == o2.hurry) {
                    return o1.pq_idx - o2.pq_idx;
                }
                return o2.hurry - o1.hurry;
            }
            return o2.day - o1.day;
        });

        int cnt = 0;

        for (int i = 0; i < m; i++) {
            if (people[i].size() == 0) break;
            pq.add(people[i].remove(0));
        }

        while (!pq.isEmpty()) {
            cnt++;
            Person per = pq.poll();
            if (per.idx == k) break;
            if (people[per.pq_idx].size() == 0) continue;

            pq.add(people[per.pq_idx].remove(0));
        }

        System.out.println(cnt - 1);
    }

    private static class Person {

        int idx;
        int pq_idx;
        int day;
        int hurry;

        public Person(int idx, int pq_idx, int day, int hurry) {
            this.idx = idx;
            this.pq_idx = pq_idx;
            this.day = day;
            this.hurry = hurry;
        }
    }
}
