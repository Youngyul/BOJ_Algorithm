import java.util.*;

public class BOJ_2606 {

	static boolean check[];
	static ArrayList<Integer> [] a;
	static int start = 1;
	static int count;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n  = sc.nextInt();	//n = ��ǻ���� ��, ������ �� n<=100
		int m = sc.nextInt(); // m = ������ ����. 
		
		a= (ArrayList<Integer>[]) new ArrayList[n+1];
		
		for(int i =1;i<=n;i++) {
			a[i]=new ArrayList<Integer>();
		}
		
		for(int i =0;i<m;i++) {
			int k = sc.nextInt();
			int p = sc.nextInt();
			
			a[k].add(p);
			a[p].add(k);
		}
		check = new boolean[n+1];
		count = 0;
		DFS(start);
		System.out.println(count);
	}
	
	//DFS ���̿켱Ž��  1. �������� �湮, 2. ������ ����� �湮�������� ���� �湮
	static void DFS(int q) {
		if(check[q]==true) {
			return;
		}
		check[q]=true;
		//System.out.print(q+" ");
		for(int i: a[q]) {
			if(check[i]==false) {
				count++;
				DFS(i);
			}
		}
	}

}
