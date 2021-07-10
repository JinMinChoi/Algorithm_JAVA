package level.stack;

import java.util.Scanner;
import java.util.Stack;

public class Q17298 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        st.push(0);

        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                arr[st.pop()] = arr[i];
            }

            st.push(i);
        }

        while(!st.isEmpty()){
            arr[st.pop()] = -1;
        }

        for(int value : arr){
            sb.append(value).append(" ");
        }

        System.out.println(sb.toString());
    }
}
