package inflearnLecture.question.recursion;

import java.util.Scanner;

public class Q56 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        recur(n);
    }

    private static void recur(int n) {
        if (n == 0) {
            return;
        }

        recur(n - 1);
        System.out.print(n + " ");
    }

}
