package inflearnLecture.question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q16 {
    private static int[] alphaCnt = new int[58];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        //대문자 0-25(65-90)
        //소문자 32-57(97-112)

        for (int i = 0; i < a.length(); i++) {
            char aChar = a.charAt(i);
            char bChar = b.charAt(i);

            alphaCnt[aChar - 65]++;
            alphaCnt[bChar - 65]--;
        }
        boolean flag = true;

        for (int i = 0; i < alphaCnt.length; i++) {
            if (alphaCnt[i] != 0) {
                flag = false;
                break;
            }
        }

        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }
}
