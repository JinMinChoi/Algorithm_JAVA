//https://www.acmicpc.net/problem/14719
package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] arr = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = W - 1;

        int maxL = arr[left];
        int maxR = arr[right];

        int sum = 0;

        while (left != right) {
            int curL = arr[left];
            int curR = arr[right];

            maxL = Math.max(curL, maxL);
            maxR = Math.max(curR, maxR);

            if (maxL > maxR) {
                sum += maxR - curR;
                right--;
            } else {
                sum += maxL - curL;
                left++;
            }
        }
        System.out.println(sum);
    }
}
