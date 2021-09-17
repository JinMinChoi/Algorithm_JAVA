//https://programmers.co.kr/learn/courses/30/lessons/84325
package programmers.weekly;

import java.util.*;

public class Q_4주차 {
    public static void main(String[] args) {
        String[] t = {"SI JAVA JAVASCRIPT SQL PYTHON C#",
                "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
                "HARDWARE C C++ PYTHON JAVA JAVASCRIPT",
                "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
                "GAME C++ C# JAVASCRIPT C JAVA"};

        String[] l = {"JAVA", "JAVASCRIPT"};
        int[] p = {7, 5};

        Q_4주차 q = new Q_4주차();
        System.out.println(q.solution(t, l, p));
    }

    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";

        Map<String, Integer> langPreMap = new HashMap<>();
        Map<String, ArrayList<Info>> coreMap = new HashMap<>();

        for (int i = 0; i < languages.length; i++) {
            langPreMap.put(languages[i], preference[i]);
        }

        for (String line : table) {
            String[] lineSplit = line.split(" ");
            String job = lineSplit[0];

            for (int i = 1; i < lineSplit.length; i++) {
                if (!coreMap.containsKey(job)) {
                    coreMap.put(job, new ArrayList<>());
                }
                coreMap.get(job).add(new Info(lineSplit[i], 6 - i));
            }
        }

        List<Info> answerList = new ArrayList<>();

        for (String line : table) {
            String[] lineS = line.split(" ");
            String job = lineS[0];
            int pointSum = 0;

            ArrayList<Info> infos = coreMap.get(job);
            for (int i = 0; i < infos.size(); i++) {
                Info info = infos.get(i);

                if (langPreMap.containsKey(info.lang)) {
                    pointSum += langPreMap.get(info.lang) * info.point;
                }
            }

            answerList.add(new Info(job, pointSum));
        }

        Collections.sort(answerList, (o1, o2) -> {
            if (o1.point == o2.point) {
                return o1.lang.compareTo(o2.lang);
            }
            return o2.point - o1.point;
        });
        answer = answerList.get(0).lang;

        return answer;
    }

    private static class Info {

        String lang;
        int point;

        public Info(String lang, int point) {
            this.lang = lang;
            this.point = point;
        }
    }
}
