package inflearnLecture.question.sortAndSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q38 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] answer = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int i, j;
        for (i = n - 1; i >= 0; i--) {
            int key = i + 1;
            int idx = arr[i];

            for (j = n - 1; j >= idx + 1; j--) {
                answer[j] = answer[j - 1];
            }

            answer[idx] = key;
        }

        for (i = 0; i < n; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
