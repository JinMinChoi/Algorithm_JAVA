package backjoon.level.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14888 {
    private static int n;
    private static int[] arr;
    private static int[] cal = new int[4];
    private static int maxValue = Integer.MIN_VALUE, minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            cal[i] = Integer.parseInt(st.nextToken());
        }

        getMaxAndMin(arr[0], 1);
        System.out.println(maxValue + "\n" + minValue);
    }

    private static void getMaxAndMin(int curValue, int depth) {
        if (depth == n) {
            //maxValue, minValue
            maxValue = Math.max(maxValue, curValue);
            minValue = Math.min(minValue, curValue);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (cal[i] != 0) {
                cal[i]--;
                switch (i){
                    case 0:
                        getMaxAndMin(curValue + arr[depth], depth + 1);
                        break;
                    case 1:
                        getMaxAndMin(curValue - arr[depth], depth + 1);
                        break;
                    case 2:
                        getMaxAndMin(curValue * arr[depth], depth + 1);
                        break;
                    case 3:
                        getMaxAndMin(curValue / arr[depth], depth + 1);
                        break;
                }
                cal[i]++;
            }
        }
    }
}
