package level.numbertheory;

import java.util.Scanner;

public class Q11050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        long start = System.currentTimeMillis();
        System.out.println(bc(n,k));
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    private static int bc(int n, int k) {
        return factorial(n) / (factorial(n - k) * factorial(k));
    }

    private static int factorial(int value) {
        int ans = 1;

        if (value == 0) return 1;

        for (int i = value; i >= 1; --i) {
            ans *= i;
        }

        return ans;
    }
}
