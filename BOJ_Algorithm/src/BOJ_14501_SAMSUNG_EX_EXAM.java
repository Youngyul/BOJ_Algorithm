import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
class BOJ_14501_SAMSUNG_EX_EXAM {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
 
        int N = Integer.parseInt(br.readLine());
 
        //N+10 �� ���� ������ �������� + 5���� �� �迭 ������ �� �� �����Ƿ� �˳��� ����ش�. 
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
        //------------�Էº�------------//
        
        
        for (int i = 1; i <=N+1; i++) {
            //���������� �ִ� ������ ���ؼ� �ִ� ������ ���翡�� �������ش�.
            //������ �ִ������ ���� �� �����Ƿ�
            //ex) 3,7,(5 ����) �̶�� �ϸ� 5�� ���� 7�� �ٲ��ִ°� �ִ������ ��µ� �´�.
            dp[i] = Math.max(dp[i], max);
            //������ ����� �ִ���� vs �̹� ���������� ���� �ִ� ����
            dp[T[i]+i] = Math.max(dp[T[i]+i],P[i]+dp[i]);
            //��µ� �ִ� ����
            max = Math.max(max, dp[i]);
            
        }
        System.out.println(max);
    }
}
