package inflearnLecture.question.recursion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q71 {
    private static int[] map = new int[10_001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        Arrays.fill(map, Integer.MAX_VALUE);
        map[s] = 0;

        while (!q.isEmpty()) {
            int curPos = q.poll();

            for (int i = 0; i < 3; i++) {
                int nextPos = 0;

                if (i == 0) {
                    nextPos = curPos + 1;
                } else if (i == 1) {
                    nextPos = curPos - 1;
                } else {
                    nextPos = curPos + 5;
                }

                if(nextPos < 0 || nextPos >= 10001) continue;

                if (map[nextPos] > map[curPos] + 1) {
                    map[nextPos] = map[curPos] + 1;
                    q.add(nextPos);
                }
            }
        }

        System.out.println(map[e]);
    }
}
