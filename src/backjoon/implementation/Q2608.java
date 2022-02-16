package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Q2608 {
    private static HashMap<String, Integer> hm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        hm = initHm();
        String[] a = br.readLine().split("");
        String[] b = br.readLine().split("");

        int aInt = convertStrToInt(a);
        int bInt = convertStrToInt(b);

        System.out.println(aInt + bInt);
        System.out.println(convertIntToStr(aInt + bInt));
    }

    private static String convertIntToStr(int n) {
        StringBuilder sb = new StringBuilder();

        ArrayList<Map.Entry<String, Integer>> entryList = new ArrayList<>(hm.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        while (n != 0) {
            int temp = 0;

            for (Map.Entry<String, Integer> entry : entryList) {
                temp = n / entry.getValue();

                if (temp != 0) {
                    while ((temp-- > 0)) {
                        sb.append(entry.getKey());
                    }
                }
                n %= entry.getValue();
            }
        }
        return sb.toString();
    }

    private static int convertStrToInt(String[] strList) {
        int ret = 0;
        for (int i = 0; i < strList.length; i++) {
            String alpha = strList[i];
            if (isIXC(alpha) && i < strList.length - 1) {
                String addTwoAlpha = strList[i] + strList[i + 1];
                if (hm.containsKey(addTwoAlpha)) {
                    ret += hm.get(addTwoAlpha);
                    i++;
                    continue;
                }
            }
            ret += hm.get(alpha);
        }

        return ret;
    }

    private static boolean isIXC(String alpha) {
        return alpha.equals("I") || alpha.equals("X") || alpha.equals("C");
    }

    private static HashMap<String, Integer> initHm() {
        HashMap<String, Integer> temp = new HashMap<>();
        temp.put("I", 1);
        temp.put("IV", 4);
        temp.put("V", 5);
        temp.put("IX", 9);
        temp.put("X", 10);
        temp.put("XL", 40);
        temp.put("L", 50);
        temp.put("XC", 90);
        temp.put("C", 100);
        temp.put("CD", 400);
        temp.put("D", 500);
        temp.put("CM", 900);
        temp.put("M", 1000);
        return temp;
    }
}
