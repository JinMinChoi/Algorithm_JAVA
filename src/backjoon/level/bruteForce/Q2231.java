package backjoon.level.bruteForce;

import java.util.Scanner;

public class Q2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            if(isConstructor(i, n)){
                ans = i;
                break;
            }
        }

        System.out.println(ans);
    }

    private static boolean isConstructor(int i, int num) {
        if(num == i + seperatedSum(i)){
            return true;
        }
        return false;
    }

    private static int seperatedSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
