package level.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1806 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int first = 0;
        int second = 0;

        int sum = 0;
        int ans = n;

        while (true) {

            if (sum >= s) {
                sum -= arr[first++];
                ans = Math.min(ans, second - first);
            } else if (second == n) break;
            else {
                sum += arr[second++];
            }

            if (sum < s) {
                sum += arr[second++];
            } else if (second == n) break;
            else {
                sum -= arr[first++];
                ans = Math.min(ans, second - first);
            }
        }

        if (ans == n) {
            System.out.println(0);
        } else System.out.println(ans + 1);

    }
}
