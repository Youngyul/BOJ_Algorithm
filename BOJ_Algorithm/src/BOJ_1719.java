import java.util.*;
import java.io.*;

public class BOJ_1719 {

	static int n,m;
	static int arr [][];
	static int result [][];
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str [] = br.readLine().split(" ");
		
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		
		arr = new int[n+1][n+1];
		result = new int[n+1][n+1];
	
		
		for(int i =0;i<m;i++) {
			String str2 [] = br.readLine().split(" ");
			
			int a = Integer.parseInt(str2[0]);
			int b = Integer.parseInt(str2[1]);
			int c = Integer.parseInt(str2[2]);
			
			arr[a][b]=c;
			arr[b][a]=c;
			result[a][b]=b;
			result[b][a]=a;
			//arr의 경우 바로 연결된 경우.
		}
		/*
		for(int i =1;i<n+1;i++) {
			for(int j =1;j<n+1;j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
		*/
		
		dijkstra();
		//System.out.println();
		//System.out.println();
		for(int i =1;i<n+1;i++) {
			for(int j =1;j<n+1;j++) {
				if(result[i][j]==0) {System.out.print("-");}
				else {
				System.out.print(result[i][j]+" ");
				}
			}
			System.out.println();
		}
		
	}

	static void dijkstra() {
		
	
		for(int i =1;i<n+1;i++) {
			for(int j =1;j<n+1;j++) {
				if(i==j) {
					arr[i][j]=0;
					result[i][j]=0;
				}
				if(i!=j&&arr[i][j]==0) {
					arr[i][j]=1000;
				}
			}
		}
	
		//k를 지나는 정점
		for(int k =1;k<n+1;k++) {
			for(int i = 1;i<n+1;i++) {
				for(int j =1;j<n+1;j++) {
					if(arr[i][k]+arr[k][j]<arr[i][j]) {
							arr[i][j]=arr[i][k]+arr[k][j];
							result[i][j]=k;
					}
				}
			}
		}
		
		for(int i =1;i<n+1;i++) {
			for(int j=1;j<n+1;j++) {
				int k = result[i][j];
				if(result[i][k]!=k) {
					result[i][j]=result[i][k];
				}
			}
		}
		
	}
	
	
}
