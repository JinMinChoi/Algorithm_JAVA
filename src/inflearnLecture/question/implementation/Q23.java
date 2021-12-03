package inflearnLecture.question.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q23 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                count++;
                if (max < count) {
                    max = count;
                }
            } else {
                count = 0;
            }
        }

        System.out.println(max + 1);
    }
}
