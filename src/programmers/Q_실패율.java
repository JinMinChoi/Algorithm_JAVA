//https://programmers.co.kr/learn/courses/30/lessons/42889?language=java
package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q_실패율 {
    public static void main(String[] args) {
        Q_실패율 q = new Q_실패율();
        int n = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] sol = q.solution(n, stages);
        for (int i : sol) {
            System.out.print(i + " ");
        }
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        List<Info> infos = new ArrayList<>(N);
        int[] arr = new int[N + 2];
        for (int stage : stages) {
            arr[stage]++;
        }
        int total = stages.length;

        for (int i = 1; i < N + 1; i++) {
            if (total != 0) {
                infos.add(new Info((double) arr[i] / total, i));
                total -= arr[i];
            } else {
                infos.add(new Info(0.0, i));
            }
        }
        Collections.sort(infos);

        print(infos);
        for (int i = 0; i < N; i++) {
            answer[i] = infos.get(i).index;
        }
        return answer;
    }

    private void print(List<Info> infos) {
        for (Info info : infos) {
            System.out.println(info.value + " " + info.index);
        }
    }

    private static class Info implements Comparable<Info> {
        double value;
        int index;

        public Info(double value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Info o) {
            if (this.value == o.value) {
                return this.index - o.index;
            }
            return (-1) * Double.compare(this.value, o.value);
        }
    }
}
