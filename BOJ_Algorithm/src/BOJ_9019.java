import java.util.*;
import java.io.*;

public class BOJ_9019 {

	static int Testcase;
	static int before,after;
	static boolean check [] = new boolean [100001];
	static String times = "";
	static String result [] = new String [100001];
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		Testcase = Integer.parseInt(br.readLine().trim());
		
		for(int i = 0; i<Testcase;i++) {
			String str [] = br.readLine().split(" ");
			before = Integer.parseInt(str[0]);
			after = Integer.parseInt(str[1]);
			
			BFS(before,after);
		}
	
	}
	
	static void BFS(int a, int b) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(a,""));
		check[a]=true;
		
		while(!q.isEmpty()) {
			Node now= q.poll();
			int nowpo = now.end;
			String value = now.value;
			
			if(now.end==b) {
				System.out.println(now.value);
				return ;
			}
			
			
			for(int i = 0; i<4;i++) {
				int next = 0;
			
				if(i==0) {
					next = D(nowpo);
					if(check[next]==false) {
						check[next]=true;
						q.add(new Node(next,value+"D"));
						result[next]=value+"D";
					}
					
				}else if(i==1) {
					next = S(nowpo);
					if(check[next]==false) {
						check[next]=true;
						q.add(new Node(next,value+"S"));
						result[next]=value+"S";
					}
				}else if(i==2) {
					next = L(nowpo);
					if(check[next]==false) {
						check[next]=true;
						q.add(new Node(next,value+"L"));
						result[next]=value+"L";
					}
				}else {
					next = R(nowpo);
					if(check[next]==false) {
						check[next]=true;
						q.add(new Node(next,value+"R"));
						result[next]=value+"R";
					}
				}
				
				
				
			}
			
			
		}
	}
	
	static int D(int a) {
		int k = a*2;
		int result =0;
		
		if(k>=0&&k<9999) {
			result = k;
		}else {
			result = k%10000;
		}
		
		return result;
	}
	static int S(int a) {
		
		int result = 0;
		int k = a-1;
		if(k==0) {
			result = 9999;
		}else {
			result = k;
		}
		
		return result;
	}
	static int L(int a) {
		int k=a;
		int result=0;
		
		int q = k/1000;
		int w = (k%1000)/100;
		int e = (k%100)/10;
		int r = (k%10);
		
		result = w*1000+e*100+r*10+q;
		return result;
		
	}
	static int R(int a) {
		int k = a;
		int result=0;
		
		int q = k/1000;
		int w = (k%1000)/100;
		int e = (k%100)/10;
		int r = (k%10);
		
		result = r*1000+q*100+w*10+e;
		return result;
	}

	
	static class Node{
		int end;
		String value;
		Node(int end,String value){
			this.end=end;
			this.value=value;
		}
	}
	
}
