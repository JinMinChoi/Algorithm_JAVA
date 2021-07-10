package backjoon.level.math;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int cnt = 0;

        while ((n--) > 0) {
            int num = Integer.parseInt(st.nextToken());
            if (isSosu(num)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean isSosu(int num) {
        if (num < 2) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }


}
