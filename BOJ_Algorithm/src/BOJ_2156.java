import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class BOJ_2156 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        // ù���� ���
        if (N >= 1) {
            dp[0] = arr[0];
        }
        // ������ ���
        if (N >= 2) {
            dp[1] = arr[0] + arr[1];
        }
        // ������ ���
        if (N >= 3) {
            dp[2] = Math.max(dp[1], Math.max(dp[0] + arr[2], arr[1] + arr[2]));
        }
        for (int i = 3; i < N; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
        }
        System.out.println(dp[N - 1]);
    }
}
