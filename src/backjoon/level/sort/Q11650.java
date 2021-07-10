package level.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        List<Pos> list = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new Pos(x, y));
        }

        Collections.sort(list);

        for (Pos p : list) {
            System.out.println(p.x + " " + p.y);
        }
    }

    private static class Pos implements Comparable<Pos> {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pos p) {
            if (this.x == p.x) {
                return this.y - p.y;
            }
            return this.x - p.x;
        }
    }
}
