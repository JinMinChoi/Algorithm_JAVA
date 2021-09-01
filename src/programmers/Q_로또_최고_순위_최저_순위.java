//https://programmers.co.kr/learn/courses/30/lessons/77484?language=java
package programmers;

import java.io.IOException;
import java.util.HashMap;

public class Q_로또_최고_순위_최저_순위 {

    public static void main(String[] args) throws IOException {
        int[] lottos = {45, 4, 35, 20, 3, 9};
        int[] win = {20, 9, 3, 45, 4, 35};
        int[] res = Solution.solution(lottos, win);
        for (int re : res) {
            System.out.println("re = " + re);
        }
    }

    static class Solution {
        public static int[] solution(int[] lottos, int[] win_nums) {
            int[] answer = new int[2];
            int hitCnt = 0;
            int zeroCnt = 0;
            HashMap<Integer, Integer> hm = new HashMap<>();
            hm.put(6, 1);
            hm.put(5, 2);
            hm.put(4, 3);
            hm.put(3, 4);
            hm.put(2, 5);
            hm.put(1, 6);
            hm.put(0, 6);

            for (int lotto : lottos) {
                if (lotto == 0) {
                    zeroCnt++;
                }
                for (int win_num : win_nums) {
                    if (lotto == win_num) {
                        hitCnt++;
                        break;
                    }
                }
            }

            int high = hm.get(hitCnt + zeroCnt);
            int low = hm.get(hitCnt);

            if (zeroCnt == lottos.length) {
                high = 1;
                low = 6;
            }
            answer[0] = high;
            answer[1] = low;

            return answer;
        }
    }
}
