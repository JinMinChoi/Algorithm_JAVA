package backjoon.level.queueDeq;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q11866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        sb.append("<");
        while (q.size() != 1) {
            for (int i = 1; i <= k - 1; i++) {
                q.add(q.poll());
            }

            sb.append(q.poll()).append(", ");
        }

        sb.append(q.poll()).append(">");

        System.out.println(sb.toString());
    }
}
