package backjoon.level.queueDeq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Q5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        while ((testCase--) > 0) {
            String[] p = br.readLine().split("");

            int n = Integer.parseInt(br.readLine());

            String[] str = br.readLine().replace("[", "").replace("]", "").split(",");

            System.out.println(ac(p, n, str));
        }
    }

    private static String ac(String[] p, int n, String[] str) {
        Deque<Integer> dq = makeDq(n, str);
        String dir = "l";

        for (String command : p) {
            if ("R".equals(command)) {
                if (dir.equals("l")) {
                    dir = "r";
                } else {
                    dir = "l";
                }
            } else if ("D".equals(command)) {
                if (dq.isEmpty()) return "error";
                else {
                    if (dir.equals("l")) {
                        dq.pollFirst();
                    } else {
                        dq.pollLast();
                    }
                }
            }
        }

        StringBuilder sb = makeSb(dq, dir);

        return sb.toString();
    }

    private static StringBuilder makeSb(Deque<Integer> dq, String dir) {
        StringBuilder sb = new StringBuilder("[");

        while (dq.size() > 1) {
            if (dir.equals("l")) {
                sb.append(dq.pollFirst());
            } else {
                sb.append(dq.pollLast());
            }
            sb.append(",");
        }
        sb.append(dq.poll());
        return sb.append("]");
    }

    private static Deque<Integer> makeDq(int n, String[] str) {
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            dq.add(Integer.parseInt(str[i]));
        }

        return dq;
    }
}
