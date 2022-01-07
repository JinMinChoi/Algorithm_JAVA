package inflearnLecture.question.sortAndSearch;

import java.util.Scanner;

public class Q52 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();

        int num = 0;
        int cnt = 0;

        while (cnt < r) {
            num++;
            if (checkUgly(num)) {
                cnt++;
            }
        }

        System.out.println(num);
    }

    private static boolean checkUgly(int num) {
        while (true) {
            if (num % 5 == 0) {
                num /= 5;
            } else if (num % 3 == 0) {
                num /= 3;
            } else if (num % 2 == 0) {
                num /= 2;
            } else if (num == 1) {
                return true;
            } else return false;
        }
    }
}
