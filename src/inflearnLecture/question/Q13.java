package inflearnLecture.question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q13 {
    private static int[] cnt = new int[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        for (int i = 0; i < arr.length; i++) {
            cnt[arr[i] - '0']++;
        }

        int max = 0;
        int maxIdx = 0;

        for (int i = 0; i < cnt.length; i++) {
            if (max <= cnt[i]) {
                max = cnt[i];
                maxIdx = i;
            }
        }
        System.out.println(maxIdx);
    }
}
