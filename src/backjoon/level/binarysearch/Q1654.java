package level.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1654 {
    private static int n, k;
    private static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new long[k];

        for (int i = 0; i < k; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        System.out.println(getAns());
    }

    private static long getAns() {
        long left = 1;
        long right = arr[k - 1];

        while (left <= right) {
            long mid = (left + right) / 2;

            if (getPartitionN(arr, mid) < n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    private static int getPartitionN(long[] arr, long value) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] / value;
        }

        return sum;
    }
}
