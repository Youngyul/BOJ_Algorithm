import java.util.*;

public class SW_6958 {

	static int testcase;
	static int arr [][] ;
	static int N,M;
	static int count [];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		testcase = sc.nextInt();
		
		for(int i =1;i<=testcase;i++) {
			N=sc.nextInt();
			M=sc.nextInt();
			
			arr  = new int[N][M];
			count = new int[N];
			
			for(int j=0;j<N;j++) {
				for(int k =0;k<M;k++) {
					int p = sc.nextInt();
					if(p==1) {
						count[j]++;
					}
				}
			}
			
			Arrays.sort(count);
			
			int max = count[N-1];
			int people = 0;
			
			for(int j =0;j<count.length;j++) {
				if(count[j]==max) {
					people++;
				}
			}
			
			System.out.println("#"+i+" "+people+" "+max);
			
			
			
			
		}
		
	}

}
