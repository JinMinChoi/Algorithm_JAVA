package inflearnLecture.question.implementation;

import java.util.Scanner;

public class Q9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print(divisor(i) + " ");
        }
    }

    private static int divisor(int num) {
        int cnt = 0;

        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
