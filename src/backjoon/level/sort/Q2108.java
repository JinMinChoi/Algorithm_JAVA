package level.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q2108 {
    private static List<Integer> list;
    private static int n;
    private static final int MAX = 500_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        list = new ArrayList<>(MAX);

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        sb.append(getAverage()).append('\n').append(getMedian()).append('\n').append(getMode()).append('\n').append(getScope());
        System.out.println(sb.toString());
    }

    private static int getScope() {
        return list.get(n - 1) - list.get(0);
    }

    private static int getMode() {
        int[] includeMinus = new int[8001];
        List<Integer> answer = new ArrayList<>();

        for (int i : list) {
            if (i < 0) {
                includeMinus[(-1) * i + 4000]++;
            } else {
                includeMinus[i]++;
            }
        }

        int max = 0;
        for (int minus : includeMinus) {
            if (minus != 0 && minus > max) {
                max = minus;
            }
        }

        for (int i = 0; i < includeMinus.length; i++) {
            int index = i;
            if (includeMinus[i] == max) {
                if (i > 4000) {
                    index -= 4000;
                    index *= (-1);
                    answer.add(index);
                } else{
                    answer.add(i);
                }
            }
        }

        Collections.sort(answer);

        if(answer.size() > 1) return answer.get(1);
        return answer.get(0);
    }

    private static int getMedian() {
        int centerValue = n / 2;
        return list.get(centerValue);
    }

    private static int getAverage() {
        int sum = 0;

        for (int i : list) {
            sum += i;
        }

        return Math.round((float) sum / n);
    }
}
