package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1360 {
    private static ArrayList<Info> infos = new ArrayList<>();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        infos.add(new Info("", 0));

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("type")) {
                String pre_str = infos.get(i - 1).str;
                char c = st.nextToken().charAt(0);
                int time = Integer.parseInt(st.nextToken());
                infos.add(new Info(pre_str + c, time));
            } else {
                int undo_time = Integer.parseInt(st.nextToken());
                int end_time = Integer.parseInt(st.nextToken());
                undo(i, end_time - undo_time - 1, end_time);
            }
        }

        System.out.println(infos.get(n).str);
    }

    private static void undo(int cur_idx, int target_time, int cur_time) {
        boolean flag = false;

        for (int i = cur_idx - 1; i >= 0; i--) {
            Info target_info = infos.get(i);

            if (target_info.time <= target_time) {
                infos.add(new Info(target_info.str, cur_time));
                flag = true;
                break;
            }
        }

        if(!flag) infos.add(new Info("", cur_time)); //undo가 처음 나올 때
    }

    private static class Info {
        String str;
        int time;

        public Info(String str, int time) {
            this.str = str;
            this.time = time;
        }
    }
}
