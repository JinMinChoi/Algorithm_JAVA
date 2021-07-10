package level.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Info> list = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list.add(new Info(s, e));
        }

        Collections.sort(list);

        int cnt = 0;
        int past = 0;

        for (int i = 0; i < n; i++) {
            if(list.get(i).start >= past){
                past = list.get(i).end;
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static class Info implements Comparable<Info> {
        int start;
        int end;

        public Info(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Info o) {
            if (this.end == o.end) return this.start - o.start;
            return this.end - o.end;
        }
    }
}
