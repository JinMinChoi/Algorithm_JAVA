//https://programmers.co.kr/learn/courses/30/lessons/12927
package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q_야근_지수 {
    public static void main(String[] args) {
        Q_야근_지수 q = new Q_야근_지수();

        int n = 4;
        int[] w = {4, 3, 3};

        System.out.println(q.solution(n, w));
    }

    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int work : works) {
            pq.add(work);
        }

        while (n > 0) {
            int max = pq.poll();
            System.out.println(max);
            pq.add(--max);
            n--;

            if(pq.peek() == 0 && n > 0) break;
        }

        for (Integer num : pq) {
            answer += Math.pow(num, 2);
        }

        if(n != 0) answer = 0;

        return answer;
    }
}
