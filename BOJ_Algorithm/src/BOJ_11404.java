import java.util.*;
import java.io.*;

public class BOJ_11404 {

	static int N,M;
	static int [][] arr;
	static boolean check [];
	static int result [][];
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine().trim());
		M = Integer.parseInt(br.readLine().trim());
		
		arr= new int[N+1][N+1];
		check = new boolean[N+1];
		result = new int[N+1][N+1];
		
	
	
		for(int i = 0 ; i<M;i++) {
			String [] str = br.readLine().split(" ");
			
			int start = Integer.parseInt(str[0]);
			int end = Integer.parseInt(str[1]);
			int value = Integer.parseInt(str[2]);
			
			if(arr[start][end]==0) {
				arr[start][end]=value;	
			}
			else {
				int temp = arr[start][end];
				if(temp<value) {
					arr[start][end]=temp;
				}else {
					arr[start][end]=value;
				}
			}
			
		}
		
	
		
		
		
		for(int i =1;i<=N;i++) {
			for(int j =1; j<=N;j++) {
				if(i==j) {
					arr[i][j]=0;
				}
				if(arr[i][j]==0&&i!=j) {
					arr[i][j]=100000;
				}
			}
		}
		
		//arr배열 출력
		/*
		for(int i =1;i<=N;i++) {
			for(int j =1; j<=N;j++) {
				
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		*/
		
		
		//result초기화.
		
		
		floydWarshall();
		
		
		//결과문 출력
		
		for(int i = 1; i<=N;i++) {
			for(int j = 1; j<=N;j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}
	
	static void floydWarshall() {
		
		//result < arr값을 복사.
		for(int i =1;i<=N;i++) {
			for(int j = 1; j<=N;j++) {
				result[i][j]=arr[i][j];
			}
		}
		
		//k는 경유정점
		for(int k=1;k<=N;k++) {
			//i는 시작정점
			for(int i =1;i<=N;i++) {
				// j는 도착정점
				for(int j = 1;j<=N;j++) {
					if(result[i][k]+result[k][j]<result[i][j]) {
						result[i][j]=result[i][k]+result[k][j];
					}
					
				}
			}
		}
		
	}
}
