package level.recursion;

import java.util.Scanner;

public class Q10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(factorial(n));
    }

    private static int factorial(int num) {
        if (num == 0) return 1;
        if (num <= 2) return num;

        return num * factorial(num-1);
    }
}
