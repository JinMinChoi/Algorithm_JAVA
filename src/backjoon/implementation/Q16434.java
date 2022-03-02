package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16434 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int warrior_atk = Integer.parseInt(st.nextToken());

        int warrior_cur_hp = 0;
        int warrior_max_hp = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int atk = Integer.parseInt(st.nextToken());
            int hp = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int cnt = hp / warrior_atk - (hp % warrior_atk == 0 ? 1 : 0);
                warrior_cur_hp += atk * cnt;
                warrior_max_hp = Math.max(warrior_cur_hp, warrior_max_hp);
            } else {
                warrior_atk += atk;
                warrior_cur_hp = Math.max(warrior_cur_hp - hp, 0);
            }

            System.out.print(warrior_cur_hp + " ");
        }

        warrior_max_hp++;
        System.out.println(warrior_max_hp);
    }
}
