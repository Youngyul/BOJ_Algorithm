import java.util.*;

public class BOJ_12761 {

	static int arr [] = new int [100001];
	static boolean check [] = new boolean [100001];
	static int N,M;
	static int A,B;
	static int value;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		//동규, 주미 일직선상 돌다리, 100001까지 존재. 동규 N,주미M.
		A = sc.nextInt();
		B = sc.nextInt();
		N = sc.nextInt();
		M = sc.nextInt();
		
		//+1,-1,-A,+A,-B,+B,NOW*A,NOW*B
		value = 0;
		
		bfs(N);
		
	}

	//현재 위치에서 bfs
	static void bfs(int now) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(now,value));
		check[now]= true;
		
		while(!q.isEmpty()) {
			Node nownode = q.poll();
			
			int nowx = nownode.position;
			int nowvalue = nownode.value;
			
					
			if(nowx==M) {
				System.out.println(nowvalue);
				return ;
			}
			
			
			int xx [] = {nowx-1,nowx+1,nowx-A,nowx+A,nowx-B,nowx+B,nowx*A,nowx*B};
			
			
			for(int i = 0 ; i<8;i++) {
				int nextx = xx[i];
				int nextvalue = nowvalue+1;
				
				if(nextx>=0&&nextx<100001) {
					if(check[nextx]==false) {
						check[nextx]=true;
						
						q.add(new Node(nextx, nextvalue));
					}
				}
			}
		}
		
	}
	
	
	static class Node{
		int position;
		int value;
		Node(int position,int value){
			this.position=position;
			this.value=value;
		}
	}
}
