//https://programmers.co.kr/learn/courses/30/lessons/17677?language=java
package programmers;

import java.util.ArrayList;
import java.util.List;

public class Q_뉴스_클러스터링 {
    public static void main(String[] args) {
        Q_뉴스_클러스터링 q = new Q_뉴스_클러스터링();

        String s1 = "aa1+aa2";
        String s2 = "AAAA12";

        System.out.println(q.solution(s1, s2));
    }

    public int solution(String str1, String str2) {
        int answer = 0;

        String temp1 = str1.toLowerCase();
        String temp2 = str2.toLowerCase();

        List<String> strList1 = getSet(temp1);
        List<String> strList2 = getSet(temp2);

        double j = strList1.size() <= strList2.size() ? calculate(strList1, strList2) : calculate(strList2, strList1);

        return (int) Math.floor(j * 65536);
    }

    private double calculate(List<String> strList1, List<String> strList2) {
        int sumSize = strList1.size() + strList2.size();
        int sameCount = 0;

        for (String target : strList1) {
            if (strList2.contains(target)) {
                sameCount++;
                strList2.remove(target);
            }
        }

        //System.out.println(sumSize + " " + sameCount);
        if(sumSize == 0) return 1.0;
        return (double) sameCount / (sumSize - sameCount);
    }

    public static ArrayList<String> getSet(String target){
        ArrayList<String> ret = new ArrayList<>();
        for (int i = 1; i < target.length(); i++) {
            if (isAlpha(target.charAt(i - 1)) && isAlpha(target.charAt(i))) {
                String component = target.charAt(i - 1) + String.valueOf(target.charAt(i));
                ret.add(component);
            }
        }
        return ret;
    }

    public static boolean isAlpha(char c) {
        return c >= 'a' && c <= 'z';
    }
}
