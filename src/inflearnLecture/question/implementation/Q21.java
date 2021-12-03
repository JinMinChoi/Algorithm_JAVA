package inflearnLecture.question.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q21 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] a = new int[10];
        int[] b = new int[10];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        String lastWin = "";
        int aScore = 0;
        int bScore = 0;
        for (int i = 0; i < 10; i++) {
            if (a[i] < b[i]) {
                bScore += 3;
                lastWin = "B";
            } else if (a[i] == b[i]) {
                aScore++;
                bScore++;
            } else {
                aScore += 3;
                lastWin = "A";
            }
        }

        String ans;
        System.out.println(aScore + " " + bScore);
        if (aScore > bScore) {
            ans = "A";
        } else if (aScore == bScore) {
            ans = lastWin;
            if (lastWin.equals("")) {
                ans = "D";
            }
        } else {
            ans = "B";
        }
        System.out.println(ans);

    }
}
