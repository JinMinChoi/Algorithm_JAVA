package level.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1920 {
    private static int[] arr;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            System.out.println(search(Integer.parseInt(st.nextToken())));
        }
    }

    private static int search(int num) {
        int left = 0;
        int right = n - 1;

        if (num > arr[right]) return 0;

        if (num < arr[left]) return 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (num == arr[mid]) {
                return 1;
            } else if (num > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return 0;
    }
}
