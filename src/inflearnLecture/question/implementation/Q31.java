package inflearnLecture.question.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q31 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ch = br.readLine();

        ch = ch.replace("C", "");

        String c = "";
        String reverseH = "";
        for (int i = 0; i < ch.length(); i++) {
            if (ch.charAt(i) == 'H') break;
            c += ch.charAt(i);
        }

        for (int i = ch.length() - 1; i >= 0; i--) {
            if (ch.charAt(i) == 'H') break;
            reverseH += ch.charAt(i);
        }

        String h = "";
        if (!reverseH.equals("")) {
            h = reverse(reverseH);
        }

        int cInt = 0;
        int hInt = 0;

        if (c.equals("")) {
            cInt = 1;
        } else {
            cInt = Integer.parseInt(c);
        }

        if (h.equals("")) {
            hInt = 1;
        } else {
            hInt = Integer.parseInt(h);
        }

        System.out.println(cInt * 12 + hInt);

    }

    private static String reverse(String reverseH) {
        String temp = "";
        for (int i = reverseH.length() - 1; i >= 0; i--) {
            temp += reverseH.charAt(i);
        }

        return temp;
    }
}
