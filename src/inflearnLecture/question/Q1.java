package inflearnLecture.question;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                sum += i;
            }
        }

        System.out.println(sum);
    }
}
