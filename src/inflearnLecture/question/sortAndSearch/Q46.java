package inflearnLecture.question.sortAndSearch;

import java.util.Scanner;

public class Q46 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] workTime = new int[n + 1];
        int curTime = 0;

        int totalWorkTime = 0;
        for (int i = 1; i <= n; i++) {
            workTime[i] = sc.nextInt();
            totalWorkTime += workTime[i];
        }
        int downTime = sc.nextInt();

        if (totalWorkTime <= downTime) {
            System.out.println("-1");
            return;
        }

        int idx = 0;
        while (true) {
            idx++;
            if (idx > n) idx = 1;
            if (workTime[idx] == 0) continue;

            workTime[idx]--;
            curTime++;

            if (curTime == downTime) break;
        }

        while (true) {
            idx++;
            if (idx > n) idx = 1;
            if (workTime[idx] != 0) break;
        }

        System.out.println(idx);
    }
}
