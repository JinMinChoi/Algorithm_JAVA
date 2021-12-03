package inflearnLecture.question.implementation;

import java.util.Scanner;

public class Q29 {
    private static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            cal(i);
        }
        System.out.println(count);
    }

    private static void cal(int num) {
        while (num > 0) {
            int a = num % 10;
            if (a == 3) {
                count++;
            }
            num /= 10;
        }
    }
}
