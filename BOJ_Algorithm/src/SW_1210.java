import java.util.*;

public class SW_1210 {

	static int N;
	static int arr[][];
	static boolean check [][];
	static int result ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int testcase = 10;
		
		while(testcase-->0) {
			
			N=sc.nextInt();
			arr = new int[100][100];
			check = new boolean [100][100];
		
		
			result = 0;
			
			for(int i =0;i<100;i++) {
				for(int j =0;j<100;j++) {
					arr[i][j]=sc.nextInt();
					
				}
			}//배열입력 완료.
		
			for(int i =0;i<100;i++) {
				if(arr[99][i]==2) {
					result =BFS(i);
					System.out.println("#"+N+" "+ result);
				}
			}
			
		
			
			
		}//testcase while구문 완료
		
	}//main완료
	
	static int BFS(int k) {
		
		int x = 99;
		int y = k;
		int result = 0;
		
		Queue<Node> q = new LinkedList<>();
		check[x][y]=true;
		q.add(new Node(x,y));
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			int nowx = now.x;
			int nowy = now.y;
		
			result = nowy;
		
			int xx [] = {0,0,-1};
			int yy [] = {1,-1,0};
			
			for(int i =0;i<3;i++) {
				int nextx = nowx+xx[i];
				int nexty = nowy+yy[i];
				
				
				if(nextx<0||nextx>99||nexty<0||nexty>99) {
					continue;
				}
				
				if(check[nextx][nexty]==false&&arr[nextx][nexty]==1) {
					check[nextx][nexty]=true;
					q.add(new Node(nextx,nexty));
					break;
				}
				
			}
		}
		
		return result;
		
	}

	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x=x;
			this.y=y;
		}
	}

}//전체완료
