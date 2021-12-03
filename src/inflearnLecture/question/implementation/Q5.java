package inflearnLecture.question.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5 {
    private static final String YEAR = "2019";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] id = br.readLine().split("-");
        char[] front = id[0].toCharArray();
        char[] back = id[1].toCharArray();

        int age;
        char sex = ' ';
        String birthYear = "";

        char sexValue = back[0];
        if (sexValue == '1' || sexValue == '3') {
            sex = 'M';

        } else if (sexValue == '2' || sexValue == '4') {
            sex = 'W';
        }

        if (sexValue == '1' || sexValue == '2') {
            birthYear = "19" + front[0] + front[1];
        } else if (sexValue == '3' || sexValue == '4') {
            birthYear = "20" + front[0] + front[1];
        }
        age = Integer.parseInt(YEAR) - Integer.parseInt(birthYear) + 1;

        System.out.println(age + " " + sex);
    }
}
