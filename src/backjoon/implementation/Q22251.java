package backjoon.implementation;

import java.util.Scanner;

public class Q22251 {
    private static int[][] num_digit = {
            {1, 1, 1, 0, 1, 1, 1}, //0
            {0, 0, 1, 0, 0, 1, 0}, //1
            {1, 0, 1, 1, 1, 0, 1}, //2
            {1, 0, 1, 1, 0, 1, 1}, //3
            {0, 1, 1, 1, 0, 1, 0}, //4
            {1, 1, 0, 1, 0, 1, 1}, //5
            {1, 1, 0, 1, 1, 1, 1}, //6
            {1, 0, 1, 0, 0, 1, 0}, //7
            {1, 1, 1, 1, 1, 1, 1}, //8
            {1, 1, 1, 1, 0, 1, 1} //9
    };
    private static int n, k, p, x;
    private static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        p = sc.nextInt();
        x = sc.nextInt();

        int[] x_to_digit = num_to_digit(x);
        for (int i = 1; i <= n; i++) {
            if(i == x) continue;
            if (can_reverse(i, x_to_digit)) count++;
        }

        System.out.println(count);
    }

    private static boolean can_reverse(int target, int[] x_to_digit) {
        int[] target_digit = num_to_digit(target);

        int not_equal_count=0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 7; j++) {
                if (num_digit[x_to_digit[i]][j] != num_digit[target_digit[i]][j]) {
                    not_equal_count++;
                    if(not_equal_count > p) return false;
                }
            }
        }
        return true;
    }

    private static int[] num_to_digit(int x) {
        int[] ret = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ret[i] = x % 10;
            x /= 10;
        }

        return ret;
    }
}
