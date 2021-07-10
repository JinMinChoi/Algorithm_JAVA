package backjoon.level.math;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        isSoinsu(n);
    }

    private static void isSoinsu(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            while(num % i == 0){
                System.out.println(i);
                num /= i;
            }
        }
        if(num > 1) System.out.println(num);
    }
}
