package backjoon.level.twopointer;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1644 {

    private static boolean[] notPrime;
    private static List<Integer> list;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        notPrime = new boolean[n + 1];
        notPrime[0] = true;
        notPrime[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (!notPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    notPrime[j] = true;
                }
            }
        }

        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (!notPrime[i]) {
                list.add(i);
            }
        }

        int firstP = 0;
        int secondP = 0;

        int cnt = 0;
        int sum = 0;

        while (true) {

            if(sum >= n){
                if(sum == n) cnt++;
                sum -= list.get(firstP++);
            } else if (secondP == list.size()) break;
            else {
                sum += list.get(secondP++);
            }
        }

        System.out.println(cnt);
    }
}
