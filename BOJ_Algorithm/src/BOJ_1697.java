import java.util.*;

public class BOJ_1697 {

	static int N,K;
	static int arr [] = new int[3];
	static boolean check[]=new boolean[100001];
	static int nowpo;
	static int shortcut[]= new int[3];
	static int dist[]= new int[1000002];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		K=sc.nextInt();
		

		BFS();
		
	}
	
	static void BFS(){
		int time = 0;
		Queue<Node> q = new LinkedList<>();
	
		q.add(new Node(N,time));
	
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			//System.out.print(now.position+" ");
			
			nowpo = now.position;
			int nowtime = now.time;
			//System.out.println("현재의 위치는 :"+nowpo);
			
			if(nowpo==K) {
				System.out.println(dist[now.position]);
				return;
			}
			
				arr[0] = nowpo + (-1);
				arr[1] = nowpo + 1;
				arr[2] = nowpo*2;
						
				for(int i = 0;i<3;i++) {
				int nextpo = arr[i];
				
				if(nextpo>=0&&nextpo<=100000&& check[nextpo]==false) {
					q.add(new Node(nextpo,time+1));
					dist[nextpo]=dist[nowpo]+1;
					check[nextpo]=true;
				}
				}
	
			
			}
	}
	static class Node{
		int position;
		int time;
		
		Node(int position, int time) {
			this.position = position;
			this.time=time;
		}
	}

}
