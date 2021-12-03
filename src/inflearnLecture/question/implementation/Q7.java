package inflearnLecture.question.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] charArr = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        //대문자 65~90
        //소문자 97~112
        for (int i = 0; i < charArr.length; i++) {
            char alpha = charArr[i];

            if (alpha >= 'a' && alpha <= 'z') {
                sb.append(alpha);
            } else if (alpha >= 'A' && alpha <= 'Z') {
                alpha += 32;
                sb.append(alpha);
            }
        }
        System.out.println(sb);
    }
}
