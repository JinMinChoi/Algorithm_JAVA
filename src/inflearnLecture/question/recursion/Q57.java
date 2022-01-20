package inflearnLecture.question.recursion;

import java.util.Scanner;

public class Q57 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        digit(n);
    }

    private static void digit(int n) {
        if (n == 0) {
            return;
        }
        digit(n / 2);
        System.out.print(n % 2);
    }
}
