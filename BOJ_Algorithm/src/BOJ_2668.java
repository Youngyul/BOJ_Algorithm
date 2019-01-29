import java.util.*;

public class BOJ_2668 {

	static int arr [] ;
	static int N;
	static int check [];

	
	//사이클이 형성되는 경우를 찾는 알고리즘.
	//int check를 이용하자. check[i]==2인경우. 싸이클형성
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		arr = new int [N+1];
		
		
		for(int j =1;j<N+1;j++) {
			arr[j]=sc.nextInt();
		}
		
		
		check = new int[N+1];
		
		for(int i =1;i<N+1;i++) {
			
			DFS(i);
			setting();
			
		}
		int max = 0;
		for(int i =1;i<N+1;i++) {
			if(check[i]==2) {
				max++;
			}
		}
		
		System.out.println(max);
		
		for(int i =1;i<N+1;i++) {
			if(check[i]==2) {
			System.out.println(i);
			}
		}
		
	
	}
	
	static void DFS(int a) {
		
		if(check[a]==2) {
			//싸이클이 형성 된경우.
			return ;
		}
		
		check[a]++;
		
		DFS(arr[a]);
	
	}
	static void setting() {
		for(int i=1;i<N+1;i++) {
			if(check[i]==2) {
				continue;
			}
			else {
				check[i]=0;
			}
		}
	}
}
