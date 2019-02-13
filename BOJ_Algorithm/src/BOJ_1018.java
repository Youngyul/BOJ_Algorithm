import java.util.Scanner;
 
public class BOJ_1018 {
    static int n,m;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 행
        m = sc.nextInt(); // 열
        arr = new int[n][m];
        for(int i=0;i<n;i++) {
            String t = sc.next();
            for(int j=0;j<m;j++)
                arr[i][j] = t.charAt(j);
        }
        // 8 * 8 을 살펴보자
        int result = Integer.MAX_VALUE;
        for(int i=0;i<=n-8;i++) {
            for(int j=0;j<=m-8;j++) {
                result = Math.min(result, solve(i,j));
            }
        }
        System.out.println(result);
    }
    
    private static int solve(int x,int y) {
        // 하나는 시작이 검은색 , 하나는 시작이 흰색
        // 검은색이 B 흰색이 W이다... C로 했었다.
        // 1. 시작이 검은색
        int result = 0;
        int temp = 'B';
        for(int i=x;i<x+8;i++) {
            // 줄의 시작은 이전과 같아야 한다.
            if(arr[i][y]!=temp) result++;
            for(int j=y+1;j<y+8;j++) {
                if(arr[i][j]==temp) {
                    result++;
                    // +1을 해주었으니 바꿔준다.
                    // (BBB 일경우 앞에 2개 비교후 중복 카운트를 막기 위해)
                    if(temp=='B') temp = 'W';
                    else temp = 'B';
                }else temp = arr[i][j];
            }
        }        
        // 2. 시작이 흰색
        int result2 = 0;
        temp = 'W';
        for(int i=x;i<x+8;i++) {
            if(arr[i][y]!=temp) result2++;
            for(int j=y+1;j<y+8;j++) {
                if(arr[i][j]==temp) {
                    result2++;
                    if(temp=='B') temp = 'W';
                    else temp = 'B';
                }else temp = arr[i][j];
            }
        }
        
        return result>result2?result2:result;
    }
}