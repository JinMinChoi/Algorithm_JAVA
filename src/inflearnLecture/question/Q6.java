package inflearnLecture.question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String ans = "";

        for (int i = 0; i < str.length(); i++) {
            char num = str.charAt(i);
            if (num >= '0' && num <= '9') {
                ans += num;
            }
        }
        int ansInt = Integer.parseInt(ans);
        int count = getDivisor(ansInt);
        System.out.println(ansInt + "\n" + count);
    }

    private static int getDivisor(int ansInt) {
        int cnt = 0;
        for (int i = 1; i <= ansInt; i++) {
            if (ansInt % i == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
