package inflearnLecture.question.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q20 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        int[] b = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b.length; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < a.length; i++) {
            System.out.println(rsp(a[i], b[i]));
        }
    }

    private static String rsp(int a, int b) {
        String win = "";
        if (a == 1) {
            if (b == 1) {
                win = "D";
            } else if (b == 2) {
                win = "B";
            } else {
                win = "A";
            }
        } else if (a == 2) {
            if (b == 1) {
                win = "A";
            } else if (b == 2) {
                win = "D";
            } else {
                win = "B";
            }
        } else if (a == 3) {
            if (b == 1) {
                win = "B";
            } else if (b == 2) {
                win = "A";
            } else {
                win = "D";
            }
        }
        return win;
    }
}
