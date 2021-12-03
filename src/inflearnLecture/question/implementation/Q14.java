package inflearnLecture.question.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            int reverseNum = reverse(arr[i]);
            if (isPrime(reverseNum)) {
                sb.append(reverseNum).append(" ");
            }
        }

        System.out.println(sb);
    }

    private static boolean isPrime(int num) {
        if (num == 0 || num == 1) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int reverse(int num) {
        String temp = "";

        while (num > 0) {
            temp += (num % 10) + "";
            num /= 10;
        }

        return Integer.parseInt(temp);
    }
}
