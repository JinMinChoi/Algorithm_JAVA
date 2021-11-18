package programmers;

import java.util.HashMap;
import java.util.Map;

public class Q_다단계_칫솔_판매 {
    public static void main(String[] args) {
        Q_다단계_칫솔_판매 q = new Q_다단계_칫솔_판매();
        String[] e = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] r = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] s = {"young", "john", "tod", "emily", "mary"};
        int[] a = {12, 4, 2, 5, 10};

        int[] ret = q.solution(e, r, s, a);
        for (int i : ret) {
            System.out.print(i + " ");
        }
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        Map<String, Info> parentAndIdx = new HashMap<>(); //<자식(나), [부모, index]>

        for (int i = 0; i < enroll.length; i++) {
            parentAndIdx.put(enroll[i], new Info(referral[i], i));
        }

        for (int i = 0; i < seller.length; i++) {
            String curSeller = seller[i];
            int curMoney = amount[i] * 100;

            while (!curSeller.equals("-")) {
                int parentMoney = curMoney / 10;
                int meMoney = curMoney - parentMoney;

                answer[parentAndIdx.get(curSeller).idx] += meMoney; //내가 갖는 돈을 추가해준다.

                curSeller = parentAndIdx.get(curSeller).parent; //나의 부모가 판매자가 된다.
                curMoney /= 10;

                if (curMoney < 1) {
                    break;
                }
            }
        }
        return answer;
    }

    private static class Info {
        String parent;
        int idx;

        public Info(String parent, int idx) {
            this.parent = parent;
            this.idx = idx;
        }
    }
}
