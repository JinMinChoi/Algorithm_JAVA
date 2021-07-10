package level.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        Set<String> stringSet = new HashSet<>(list);
        List<String> list2 = new ArrayList<>(stringSet);

        Collections.sort(list2, (o1, o2) -> {
            if (o1.length() == o2.length()) return o1.compareTo(o2);
            return o1.length() - o2.length();
        });

        for (String str : list2) {
            System.out.println(str);
        }
    }
}
