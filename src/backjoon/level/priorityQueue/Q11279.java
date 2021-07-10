package backjoon.level.priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q11279 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        while ((n--) > 0) {
            int cm = sc.nextInt();

            if (cm == 0) {
                if (pq.isEmpty()) {
                    sb.append(cm).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                pq.add(cm);
            }
        }

        System.out.println(sb.toString());
    }
}
