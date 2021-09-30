//https://programmers.co.kr/learn/courses/30/lessons/17686
package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q_파일명_정렬 {
    private static List<File> list = new ArrayList<>();

    public static void main(String[] args) {
        Q_파일명_정렬 q = new Q_파일명_정렬();
        String[] f = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        String[] ret = q.solution(f);

        for (String s : ret) {
            System.out.print(s + " ");
        }
    }

    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        int idx = 0;
        for (String file : files) {
            boolean numflag = false;
            StringBuilder num = new StringBuilder();
            StringBuilder head = new StringBuilder();
            StringBuilder tail = new StringBuilder();

            for (int i = 0; i < file.length(); i++) {
                char c = file.charAt(i);
                if (c >= '0' && c <= '9') {
                    num.append(c);
                    numflag = true;
                } else {
                    if (!numflag) head.append(c);
                    else {
                        tail.append(file.substring(i));
                        break;
                    }
                }
            }
            System.out.println(head + " " + num + " " + tail);
            list.add(new File(idx, head.toString(), num.toString(), tail.toString()));
            idx++;
        }

        Collections.sort(list);

        for (int i = 0; i < answer.length; i++) {
            File file = list.get(i);
            answer[i] = file.head + file.num + file.tail;
        }

        return answer;
    }

    private static class File implements Comparable<File> {
        int idx;
        String head;
        String num;
        String tail;

        public File(int idx, String head, String num, String tail) {
            this.idx = idx;
            this.head = head;
            this.num = num;
            this.tail = tail;
        }

        @Override
        public int compareTo(File f) {
            if (this.head.equalsIgnoreCase(f.head)) {
                if (Integer.parseInt(this.num) == Integer.parseInt(f.num)) {
                    return this.idx - f.idx;
                }
                return Integer.parseInt(this.num) - Integer.parseInt(f.num);
            }
            return this.head.toLowerCase().compareTo(f.head.toLowerCase());
        }
    }
}
