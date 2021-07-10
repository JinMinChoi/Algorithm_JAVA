//https://programmers.co.kr/learn/courses/30/lessons/42578
package programmers.level2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Q42578 {
    public static void main(String[] args) {
        String[][] sArr = {
                {"yellowhat", "headgear"},
                {"bluesunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };

        System.out.println(solution(sArr));
    }

    static int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1];

            hm.put(key, hm.getOrDefault(key, 0) + 1);
        }

        Set<String> keySet = hm.keySet();

        for (String s : keySet) {
            answer *= hm.get(s) + 1;
        }

        return answer - 1;
    }
}
