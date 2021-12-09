package inflearnLecture.question.sortAndSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q33 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] count = new boolean[101];
        for (int i = 0; i < n - 1; i++) {
            int max_idx = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[max_idx]) {
                    max_idx = j;
                }
            }

            if (i != max_idx) {
                int temp = arr[i];
                arr[i] = arr[max_idx];
                arr[max_idx] = temp;
            }

            if (!count[arr[i]]) {
                count[arr[i]] = true;
            }
        }

        int trueCount = 0;
        int ans = 0;

        for (int i = 100; i >= 0; i--) {
            if (count[i]) {
                trueCount++;
            }

            if (trueCount == 3) {
                ans = i;
                break;
            }
        }

        System.out.println(ans);
    }
}
