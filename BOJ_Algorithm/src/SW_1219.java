import java.util.*;
import java.io.*;

public class SW_1219 {

	
	static ArrayList<Integer> arr [];
	static boolean check [];
	static int result;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		
		int T = 10;
		
		while(T-->0) {
		
			int testcase = sc.nextInt();
		
		
		
		int N = sc.nextInt();
		
		check = new boolean[100];
		
		arr = new ArrayList [100];
		
		
		for(int i = 0 ; i<100;i++) {
			arr[i]=new ArrayList<Integer>();
		}
		
		for(int i =0;i<N;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			arr[a].add(b);
			
		}
		result = 0;
		
		dfs(0);
		
		if(check[99]==true) {
			result = 1;
		}
		if(check[99]==false) {
			result = 0;
		}
		
		
		System.out.println("#"+testcase + " "+result);
		
		
		
		}	//testcase end
	}//main end

	static void dfs(int a) {
		
		
		if(check[a]==true) {
			return ;
		}
		
		check[a]=true;
		
		for(int y:arr[a]) {
			if(check[y]==false) {
				dfs(y);
			}
		}
	}
	
	
}// all end
