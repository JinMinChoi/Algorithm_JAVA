package inflearnLecture.question.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] charArray = br.readLine().toCharArray();

        int count = 0;

        if (charArray[0] == ')' || charArray[charArray.length-1] == '(') {
            System.out.println("NO");
            return;
        }

        for (int i = 0; i < charArray.length; i++) {
            char bracket = charArray[i];

            if (bracket == '(') {
                count++;
            } else if (bracket == ')') {
                count--;
            }
        }

        if (count == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
