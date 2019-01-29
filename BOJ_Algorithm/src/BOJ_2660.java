import java.util.*;

public class BOJ_2660 {

	static int N;
	static int arr [][];
	static int result [][];
	static int sum [];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();
		
		arr = new int[N+1][N+1];
		sum = new int[N+1];
		result = new int[N+1][N+1];
		
		
		for(int i =1;i<N+1;i++) {
			for(int j =1;j<N+1;j++) {
				if(i==j) {arr[i][j]=0;}
				else {
				arr[i][j]=50;
				}
			}
		}
		
		
		
		while(sc.hasNextLine()) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(a==-1&&b==-1) {
				break;
			}
			
			arr[a][b]=1;
			arr[b][a]=1;
			
		}
		
		
		
		
		floydwarshall();
		
		
		for(int i =1;i<N+1;i++) {
			int max = 0;
			
			for(int j =1;j<N+1;j++) {
				if(max<result[i][j]) {
					max = result[i][j];
				}
				sum[i]=max;
			}
		}
		
		/*
		//sum
		for(int i =1;i<N+1;i++) {
			System.out.println(sum[i]);
		
		}
		*/
		
		int min = 50;
		int result = 0;
		
		for(int i =1;i<N+1;i++) {
			if(sum[i]<min) {
				min=sum[i];
			}
		}
		
		for(int i =1;i<N+1;i++) {
			if(sum[i]==min) {
				result ++;
			}
		}
		
		System.out.println(min + " " + result);
		
		for(int i =1;i<N+1;i++) {
			if(sum[i]==min) {
				System.out.print(i + " ");
			}
		}
		
	}
	
	static void floydwarshall() {
		
		for(int i =1;i<N+1;i++) {
			for(int j =1;j<N+1;j++) {
				result[i][j]=arr[i][j];
				
				
			}
		}
		
		for(int k =1;k<N+1;k++) {
			
			for(int i =1;i<N+1;i++) {
				
				for(int j =1;j<N+1;j++) {
					if(result[i][k]+result[k][j]<result[i][j]) {
						result[i][j]=result[i][k]+result[k][j];
					}
				}
			}
		}
		
		/*
		for(int i =1;i<N+1;i++) {
			for(int j =1;j<N+1;j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
		*/
		
		
	}
	
	

}
