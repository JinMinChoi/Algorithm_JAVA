package backjoon.implementation;

import java.util.Scanner;

public class Q20164 {
    private static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        dfs(num, getOddCnt(num));
        System.out.println(min + " " + max);
    }

    private static void dfs(int num, int cnt) {
        if (num <= 9) {
            min = Math.min(min, cnt);
            max = Math.max(max, cnt);
            return;
        }

        if (num <= 99) {
            int next_num = (num / 10) + (num % 10);
            dfs(next_num, cnt + getOddCnt(next_num));
        }

        String numToStr = String.valueOf(num);
        for (int i = 0; i < numToStr.length() - 2; i++) {
            for (int j = i + 1; j < numToStr.length() - 1; j++) {
                String one = numToStr.substring(0, i + 1);
                String two = numToStr.substring(i + 1, j + 1);
                String three = numToStr.substring(j + 1);

                int next_num = Integer.parseInt(one) + Integer.parseInt(two) + Integer.parseInt(three);
                dfs(next_num, cnt + getOddCnt(next_num));
            }
        }
    }

    private static int getOddCnt(int num) {
        int oddCnt = 0;
        while (num > 0) {
            int digit = num % 10;
            if (digit % 2 != 0) oddCnt++;
            num /= 10;
        }
        return oddCnt;
    }
}
