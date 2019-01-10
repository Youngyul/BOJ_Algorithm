import java.util.*;

public class BOJ_5014 {

	static int nowstair;
	static int cal;
	static int f,s,g,u,d;
	static int[] dx= {-1,1};
	static boolean []check = new boolean[1000001];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		f=sc.nextInt();
		s=sc.nextInt();
		g=sc.nextInt();
		u=sc.nextInt();
		d=sc.nextInt();
		
		//S층에서 G층으로 이동하기 위한 버튼의 이동 최소수
		
		dx[0]*=d;
		dx[1]*=u;
		
		System.out.println(bfs(s));
	}
		
	static String bfs(int v) {
		Queue<Pair> q = new LinkedList<>();
		
		q.add(new Pair(0,v));
		check[v]=true;
		
		while(!q.isEmpty()) {
			Pair p = q.remove();
			int cnt = p.count;
			int floor = p.value;
			
			if(floor==g) {
				return String.valueOf(cnt);
			}
			
			for(int i = 0;i<2;i++) {
				int next = dx[i]+floor;
				
				if(0<next&& next<1000001) {
					if(!check[next]) {
						q.add(new Pair(cnt+1,next));
						check[next]=true;
					}
				}
			}
		}
		
		return "use the stairs";
	}
	
	static class Pair{
		int count; int value;
		
		Pair(int count,int value){
			this.count=count;
			this.value = value;
		}
	}
}
