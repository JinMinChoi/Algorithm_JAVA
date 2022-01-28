package inflearnLecture.question.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q73 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        String input;
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            if (input.equals("0") && !pq.isEmpty()) {
                System.out.println(pq.poll());
            } else if (input.equals("-1")) {
                return;
            } else {
                pq.add(Integer.parseInt(input));
            }
        }
    }
}
