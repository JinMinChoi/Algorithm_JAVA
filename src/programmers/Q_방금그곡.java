//https://programmers.co.kr/learn/courses/30/lessons/17683
package programmers;

public class Q_방금그곡 {
    public static void main(String[] args) {
        Q_방금그곡 q = new Q_방금그곡();
        String m = "ABCDEFG";
        String[] mu = {
                "12:00,12:14,HELLO,CDEFGAB",
                "13:00,13:05,WORLD,ABCDEF"
        };

        System.out.println(q.solution(m, mu));
    }

    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int maxPlayTime = -1;
        m = removeToSharp(m);

        for (String musicinfo : musicinfos) {
            String[] infoSplit = musicinfo.split(",");
            int start = convertToMinute(infoSplit[0]);
            int end = convertToMinute(infoSplit[1]);
            String title = infoSplit[2];
            String melody = infoSplit[3];

            int time = end - start;
            melody = removeToSharp(melody);

            if (melody.length() >= time) {
                melody = melody.substring(0, time);
            } else {
                StringBuilder tempMelody = new StringBuilder();

                for (int i = 0; i < time / melody.length(); i++) {
                    tempMelody.append(melody);
                }

                tempMelody.append(melody.substring(0, time % melody.length()));
                melody = tempMelody.toString();
            }

            if (melody.contains(m) && time > maxPlayTime) {
                answer = title;
                maxPlayTime = time;
            }

        }

        return maxPlayTime == -1 ? "(None)" : answer;
    }

    private static String removeToSharp(String s) {
        s = s.replace("C#", "c");
        s = s.replace("D#", "d");
        s = s.replace("F#", "f");
        s = s.replace("G#", "g");
        s = s.replace("A#", "a");
        return s;
    }

    private static int convertToMinute(String s) {
        int allMin = 0;
        String[] hourAndMinute = s.split(":");
        int hourToMin = Integer.parseInt(hourAndMinute[0]) * 60;
        allMin = hourToMin + Integer.parseInt(hourAndMinute[1]);
        return allMin;
    }
}
