import java.util.*;

//다익스트라 알고리즘의 경우. 시작정점을 기준으로 시작정점에서 가장 value가 작은 순서를 기준으로 PriorityQueue를 진행하면된다.
//플로이드와샬 알고리즘의 경우. 단방향의 정보가 주어지는 경우가 다반사이고, 이 경우 지나가는 정점을 기준으로 생각한다.




public class BOJ_1238 {

	static int N,M,X;
	static boolean check [][];
	static int time [][];
	static int max = 100000;
	static int result [][];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();	//정점의 숫자
		M=sc.nextInt();	//간선 길이
		X=sc.nextInt();	//X는 지나가는 위치.
		
		time = new int [N+1][N+1];
		check = new boolean [N+1][N+1];
		
		for(int i = 0;i<M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			time[a][b]= c;
			check[a][b]=true;
		}
		
		for(int i = 1 ; i<=N;i++) {
			for(int j = 1 ; j<=N;j++) {
				if(i==j) {
					time[i][j]=0;
				}
				if(i!=j&&check[i][j]==false) {
					time[i][j]=max;
				}
			}
		}
		
		floydWarshall();
		//가장 오래 걸리는 학생의 소요시간을 구한다.
		//System.out.println();
		int arr [] = new int [N+1];
		int max = 0;
		for(int i = 1; i<=N;i++) {
			arr[i]= result[i][X]+result[X][i];
			if(max<arr[i]) {
				max = arr[i];
			}
		}
		System.out.println(max);
		
		
	}
	
	
	//I에서 X로 이동하는 플로이드 와샬 한번, X에서 I로 이동하는 플로이드 와샬 한번.
	
	static void floydWarshall() {
		 result = new int[N+1][N+1];
		
		for(int i = 1 ; i<=N;i++) {
			for(int j = 1; j<=N;j++) {
				result[i][j]=time[i][j];
			}
		}
		
		//k는 거쳐가는 노드
		for(int k = 1 ; k<=N;k++) {
			//시작노드
			for(int i = 1 ; i<=N;i++) {
				//도착노드
				for(int j = 1; j<=N;j++) {
					if(result[i][k]+result[k][j]<result[i][j]) {
						result[i][j]= result[i][k]+result[k][j];
					}
				}
			}
		}
		
		/*플로이드 와샬 알고리즘 출력
		for(int i = 1 ; i<=N;i++) {
			for(int j = 1; j<=N;j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
		*/
		
	}
	


	static class Node{
	
		int end;
		int value;
		
		Node(int end,int value){
			this.end=end;
			this.value = value;
		}
	}
	
	
}
