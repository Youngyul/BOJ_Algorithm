import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
class BOJ_14501_SAMSUNG_EX_EXAM {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
 
        int N = Integer.parseInt(br.readLine());
 
        //N+10 을 해준 이유는 마지막날 + 5일일 때 배열 에러가 날 수 있으므로 넉넉히 잡아준다. 
        int[] T = new int[N+10];
        int[] P = new int[N+10];
        int[] dp = new int[N+10];
        int max = 0;
        String[] str;
        for (int i = 1; i <=N; i++) {
            str = br.readLine().split(" ");
            T[i] = Integer.parseInt(str[0]);
            P[i] = Integer.parseInt(str[1]);
        }
        //------------입력부------------//
        
        
        for (int i = 1; i <=N+1; i++) {
            //이전까지의 최대 수입을 비교해서 최대 수입을 현재에도 저장해준다.
            //이전에 최대수입이 났을 수 있으므로
            //ex) 3,7,(5 예상) 이라고 하면 5의 값은 7로 바꿔주는게 최대수입을 얻는데 맞다.
            dp[i] = Math.max(dp[i], max);
            //이전에 저장된 최대수익 vs 이번 움직임으로 생긴 최대 수익
            dp[T[i]+i] = Math.max(dp[T[i]+i],P[i]+dp[i]);
            //출력될 최대 수입
            max = Math.max(max, dp[i]);
            
        }
        System.out.println(max);
    }
}
