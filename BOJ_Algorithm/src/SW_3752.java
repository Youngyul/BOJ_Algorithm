import java.io.*;
import java.util.StringTokenizer;
 
public class SW_3752 {
    static int n;
    static int[] arr;
    static int sum,result;
    static boolean[] dp;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        for(int z=1;z<=tc;z++){
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            sum = 0;
            for(int i=0;i<n;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }
 
            dp = new boolean[sum+10];
            dp[0] = true;
            // 각 점수별로 만들 수 있는 점수를 만들어 주자.
            for(int i=0;i<n;i++){
                for(int j=sum;j>=0;j--){
                    // 가능한 점수를 만나면 현 점수 더해주기
                    if(dp[j])
                        dp[arr[i]+j] = true;
                }
            }
            result = 0;
            for(int i=0;i<=sum;i++)
                if(dp[i]) result++;
            System.out.println("#"+z+" "+result);
        }
    }
}
