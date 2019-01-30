import java.util.*;



public class BOJ_2579 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
         
        int dp[] = new int[n+1];
        int a[] = new int[n+1];
         
        for(int i=1; i<=n; i++){
            a[i] = sc.nextInt();
        }
 
        dp[1] = a[1];
        if(n >= 2) dp[2] = dp[1]+a[2];
     
        for(int i=3; i<=n; i++){
            dp[i] = Math.max(dp[i-2]+a[i],dp[i-3]+a[i-1]+a[i]); 
        }
         
        System.out.println(dp[n]);
	}

}
