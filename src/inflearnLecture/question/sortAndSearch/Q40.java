package inflearnLecture.question.sortAndSearch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q40 {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int p1 = 0, p2 = 0;

        while (p1 < n && p2 < m) {
            if (a[p1] > b[p2]) {
                p2++;
            } else if (a[p1] == b[p2]) {
                list.add(a[p1]);
                p1++;
                p2++;
            } else {
                p1++;
            }
        }

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
