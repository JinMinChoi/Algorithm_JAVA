package inflearnLecture.question.recursion2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q78 {
    private static int v, e;
    private static ArrayList<Info> mst;
    private static int[] unf;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        mst = new ArrayList<>(v + 1);
        unf = new int[v + 1];
        for (int i = 0; i <= v; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            mst.add(new Info(a, b, c));
        }
        Collections.sort(mst);

        for (Info info : mst) {
            union(info.a, info.b, info.c);
        }

        System.out.println(answer);
    }

    private static void union(int a, int b, int c) {
        a = find(a);
        b = find(b);

        if (a != b) {
            unf[b] = a;
            answer += c;
        }
    }

    private static int find(int a) {
        if (a == unf[a]) {
            return a;
        }

        return unf[a] = find(unf[a]);
    }

    private static class Info implements Comparable<Info> {
        int a;
        int b;
        int c;

        public Info(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Info o) {
            return this.c - o.c;
        }
    }
}
