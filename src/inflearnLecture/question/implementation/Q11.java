package inflearnLecture.question.implementation;

import java.util.Scanner;

public class Q11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += digit(i);
        }
        System.out.println(ans);
    }

    private static int digit(int num) {
        int temp = 0;
        while (num > 0) {
            temp++;
            num /= 10;
        }
        return temp;
    }
}
