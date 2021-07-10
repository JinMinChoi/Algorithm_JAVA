package level.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        //long start = System.currentTimeMillis();
        for (int i = m; i <= n; i++) {
            if (isSosu(i)) {
                System.out.println(i);
            }
        }
        //long end = System.currentTimeMillis();
        //System.out.println(end - start);
    }

    private static boolean isSosu(int num) {
        if (num < 2) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        return true;
    }

}
