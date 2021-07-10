//https://www.acmicpc.net/problem/17609
package backjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        while ((n--) > 0) {
            String str = br.readLine();

            int ans = pNum(str);

            System.out.println(ans);
        }
    }

    private static int pNum(String str) {
        int ret = 0;
        int left = 0;
        int right = str.length() - 1;

        while (left <= right) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                int l = left;
                int r = right;

                l++;
                while (l <= r) {
                    if (str.charAt(l) == str.charAt(r)) {
                        l++;
                        r--;
                    }
                    else {
                        ret++;
                        break;
                    }
                }

                l = left;
                r = right;

                r--;
                while (l <= r) {
                    if (str.charAt(l) == str.charAt(r)) {
                        l++;
                        r--;
                    }
                    else {
                        ret++;
                        break;
                    }
                }

                return ret;

            }
        }
        return ret;
    }
}
