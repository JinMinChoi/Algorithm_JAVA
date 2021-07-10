package level.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10989 {
    private static final int MAX = 10_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[MAX];

        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 1; i < MAX; i++) {
            while(arr[i] > 0){
                sb.append(i).append('\n');
                arr[i]--;
            }
        }
        System.out.println(sb.toString());
    }
}
