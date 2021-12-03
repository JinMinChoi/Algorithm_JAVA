package inflearnLecture.question.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q24{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] check = new int[n];

        for (int i = 0; i < n - 1; i++) {
            int value = Math.abs(arr[i] - arr[i + 1]);
            if (value < n) {
                check[value]++;
            }
        }

        int sum = 0;
        for (int i = 1; i < check.length; i++) {
            sum += check[i];
        }

        if (sum == n - 1) System.out.println("YES");
        else System.out.println("NO");
    }
}