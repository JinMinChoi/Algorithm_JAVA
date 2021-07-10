package level.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q7568 {
    private static List<Size> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        list = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            list.add(new Size(w, h));
        }

        for (int i = 0; i < n; i++) {
            int rank = 1;
            for (int j = 0; j < n; j++) {
                if (list.get(i).weight < list.get(j).weight
                        && list.get(i).height < list.get(j).height) {
                    rank++;
                }
            }
            sb.append(rank + " ");
        }

        System.out.println(sb.toString());
    }

    private static class Size {
        int weight;
        int height;

        public Size(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
}
