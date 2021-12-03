package inflearnLecture.question.implementation;

import java.util.Scanner;

public class Q27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n + 1];

        System.out.print(n + "! = ");

        for (int i = 2; i <= n; i++) {
            int temp = i;
            int check = 2;

            while (true) {
                if (temp % check == 0) {
                    arr[check]++;
                    temp /= check;
                } else {
                    check++;
                }

                if(temp == 1) break;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (arr[i] != 0) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
