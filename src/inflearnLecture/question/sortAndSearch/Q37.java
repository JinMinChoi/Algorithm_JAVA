package inflearnLecture.question.sortAndSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q37 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] cache = new int[n];
        int[] work = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            work[i] = Integer.parseInt(st.nextToken());
        }

        int i, j, k;


        for (i = 0; i < work.length; i++) {
            int w = work[i];
            boolean hit = false;

            for (j = 0; j < cache.length; j++) {
                if (cache[j] == w) {
                    hit = true;
                    break;
                }
            }

            if (hit) {
                for (k = j; k >= 1; k--) {
                    cache[k] = cache[k - 1];
                }
            } else {
                for (k = n - 1; k >= 1; k--) {
                    cache[k] = cache[k - 1];
                }
            }

            cache[0] = w;
        }

        for (i = 0; i < cache.length; i++) {
            System.out.print(cache[i] + " ");
        }
    }
}
