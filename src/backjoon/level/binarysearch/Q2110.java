package level.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2110 {
    private static int n, c;
    private static long[] houses;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        houses = new long[n];

        for (int i = 0; i < n; i++) {
            houses[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(houses);
        long left = 1; //최소 거리
        long right = houses[n - 1] - houses[0]; //최대 거리

        long ans = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            int cnt = 1; // 공유기를 설치한 집의 갯수
            long startingHouse = houses[0];

            //공유기 설치 여부 확인
            //현재(i)집과 startingHouse 집의 차이가 mid(중간 거리)보다 크다면 공유기를 설치할 수 있다.
            for (int i = 1; i < n; i++) {
                if (houses[i] - startingHouse >= mid) {
                    cnt++;
                    startingHouse = houses[i];
                }
            }

            //if, 설치한 공유기의 갯수(cnt)가 필요한 갯수(c)를 오바하거나
            //갯수는 들어맞지만 거리가 너무 가까워 최대거리를 갱신하지 못할 때,
            //거리를 벌린다.
            if (cnt >= c) {
                left = mid + 1;
                ans = mid;
            }
            else {
                //else, 거리가 너무 멀어져 공유기 갯수를 채우지 못하면,
                //거리를 좁혀준다.
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
