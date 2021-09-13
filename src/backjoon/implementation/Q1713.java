//https://www.acmicpc.net/problem/1713
package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        List<Info> infos = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean isSavedNum;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int student = Integer.parseInt(st.nextToken());

            if (infos.size() < n) {
                isSavedNum = false;

                for (Info info : infos) {
                    if (info.student == student) {
                        info.cnt++;
                        isSavedNum = true;
                        break;
                    }
                }
                if (!isSavedNum) infos.add(new Info(i, student, 1));
            } else {
                Collections.sort(infos);
                isSavedNum = false;

                for (Info info : infos) {
                    if (info.student == student) {
                        info.cnt++;
                        isSavedNum = true;
                        break;
                    }
                }
                if (!isSavedNum) {
                    infos.remove(0);
                    infos.add(new Info(i, student, 1));
                }
            }
        }

        for (Info info : infos) {
            answer.add(info.student);
        }

        Collections.sort(answer);

        for (Integer val : answer) {
            sb.append(val).append(" ");
        }

        System.out.println(sb.toString());
    }

    static class Info implements Comparable<Info> {
        int index;
        int student;
        int cnt;

        public Info(int index, int student, int cnt) {
            this.index = index;
            this.student = student;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Info o) {
            if (this.cnt == o.cnt) {
                return this.index - o.index;
            }
            return this.cnt - o.cnt;
        }
    }
}
