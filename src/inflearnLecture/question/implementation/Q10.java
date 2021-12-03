package inflearnLecture.question.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int maxDigit = 0;

        for (int i = 0; i < arr.length; i++) {
            if (maxDigit <= digit_sum(arr[i])) {
                maxDigit = digit_sum(arr[i]);
                max = arr[i];
            }
        }
        System.out.println(max);
    }

    private static int digit_sum(int num) {
        int temp = 0;

        while (num > 0) {
            temp += num % 10;
            num /= 10;
        }

        return temp;
    }
}
