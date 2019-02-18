import java.io.*;
import java.util.*;

public class BOJ_10845 {

	static 	Queue<Integer> q = new LinkedList<>();
	static int last=0;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		
		for(int i =0;i<N;i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String str = st.nextToken();
			
			
			switch(str) {
			
			case "push" :
				int k = Integer.parseInt(st.nextToken());
				push(k);
				break;
				
			case "front" :
				System.out.println(front());
				break;
			
			case "back" :
				System.out.println(back());
				break;
			
			case "empty" :
				System.out.println(empty());
				break;
			
			case "size" :
				System.out.println(size());
				break;
			
			case "pop" :
				System.out.println(pop());
				break;
		
			}
			
		}	
	}
	
	static int push(int a) {
		q.add(a);
		last = a;
		return a;
	}
	
	static int front() {
		int k = -1;
		if(!q.isEmpty()) {
			k = q.peek();
		}
		return k;
	}
	
	static int back() {
		int k = -1;
		if(!q.isEmpty()) {
			k=last;
		}
		return k;
	}
	
	static int empty() {
		int k= 0;
		if(q.isEmpty()) {
			k=1;
		}
		return k;
	}
	
	static int size() {
		int k = q.size();
		return k;
	}
	static int pop() {
		int k = -1;
		if(!q.isEmpty()) {		
			k=q.poll();
		}
		return k;
	}

}
