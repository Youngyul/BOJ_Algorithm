import java.io.*;
import java.util.*;

public class BOJ_1389 {

	static int N;
	static int M;
	static boolean check [][];
	static int arr [][];
	static int max = 10000;
	static int result [][];
	static int kevin [] ;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		arr = new int[N+1][N+1];
		check = new boolean[N+1][N+1];
		kevin = new int[N+1];
		
		for(int i = 0 ; i<M;i++) {
			String [] str2 = br.readLine().split(" ");
			int a = Integer.parseInt(str2[0]);
			int b = Integer.parseInt(str2[1]);
			
			check[a][b]=true;
			check[b][a]=true;

		}
		
		
		for(int i = 1 ; i<=N;i++) {
			for(int j = 1 ; j<=N;j++) {
				if(i==j) {
					arr[i][j]=0;
				}
				if(i!=j&&check[i][j]==false) {
					arr[i][j]=max;
				}
				if(i!=j&&check[i][j]==true) {
					arr[i][j]=1;
				}
			}
		}
		
		/*
		for(int i =1 ;i<N+1;i++) {
			for(int j = 1; j<N+1;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
		System.out.println();
		*/
		floydWarshall();
		
		
		/*
		for(int i =1 ;i<N+1;i++) {
			for(int j = 1; j<N+1;j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
		*/
		
		for(int i = 1;i<N+1;i++) {
			for(int j = 1; j<N+1;j++) {
				kevin[i]+=result[i][j];
			}
		}
		
		int min = 10000;
		int temp = 0;
		
		for(int i = 1; i<N+1;i++) {
			if(kevin[i]<min) {
				temp = i;
				min = kevin[i];
			}
		}
		
		System.out.println(temp);
	}	//Main함수 종료.

	
	//i에서 j로가는 floydWarshall // 특정정점을 경유하는 것으로 계속 
	static void floydWarshall() {
		
		//k정점을 지날 때를 생각해보자.
		//check배열는  간선정보 true
		//arr배열은 베이컨수 저장할 공간.
		
		result = new int[N+1][N+1];
		
		for(int i =1;i<N+1;i++) {
			for(int j =1 ;j<N+1;j++) {
				result[i][j]=arr[i][j];
			}
		}
		
		//경유할 정점
		for(int k=1;k<=N;k++) {
			//시작점
			for(int m = 1 ; m<=N;m++) {
				//도착지점
				for(int n = 1; n<=N;n++) {
					if(result[m][k]+result[k][n]<result[m][n]) {
						result[m][n]= result[m][k]+result[k][n];
					}
				
				}
			}
		}
		
	}
	
}//전체함수 종료
