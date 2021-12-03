package inflearnLecture.question.implementation;

import java.util.Scanner;

public class Q28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = 0;

        for (int i = 2; i <= n; i++) {

            int temp = i;
            int j = 2;

            while (true) {
                if (temp % j == 0) {
                    if (j == 5) {
                        count++;
                    }
                    temp /= j;
                } else {
                    j++;
                }

                if(temp == 1) break;
            }
        }

        System.out.println(count);
    }
}
