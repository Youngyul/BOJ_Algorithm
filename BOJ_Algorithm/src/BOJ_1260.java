import java.util.*;

public class BOJ_1260 {

	
	static int n,m,start;
	static boolean check[];
	static ArrayList<Integer>[] arr ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();	//n값은 정점의 갯수 1<=n<=1000임으로 Int로 선언해도 괜찮다.
		m = sc.nextInt();	//m값은 간선의 갯수 1<=m<=10,000임으로 int로 선언 
		start = sc.nextInt(); 	//시작정점
		
		
		//배열을 Generic으로 사용한것.
		arr= (ArrayList<Integer>[]) new ArrayList[n+1];
		//ArrayList a1 = new ArrayList();가 원래 모양
		//But, ArrayList의 경우 a1.add를 통해 값을 추가할 수 있는데 이때, 값의 type이 Object로 모든 값을 받아들일수 있다.
		//그렇기 때문에 처음 초기화할때, 추가하는 type를 지정해주기위해 <>를 이용하는데 , 이를 Generic법칙이라 한다.
		//ArrayList<Integer> brr = new ArrayList<Integer>();
		
		for(int i = 1;i<=n;i++) {
			arr[i]=new ArrayList<Integer>();
		}
		for(int i = 0;i<m;i++) {
			int k = sc.nextInt();
			int p = sc.nextInt();
			
			arr[k].add(p);
			arr[p].add(k);
		}
		for(int i =1;i<n;i++) {
			Collections.sort(arr[i]);
		}
		check = new boolean[n+1];
		DFS(start);
		System.out.println();
		check = new boolean[n+1];
		BFS(start);
		System.out.println();
		
		sc.close();
	}
	
	//BFS는 큐를 이용한다. 자바의 경우 큐와 LinkedList를 이용하여 문제를 해결한다.
	//1.큐에서 하나의 노드를 꺼낸다. 2. 해당 노드에 연결된 노드중 방문하지 않은 노드를 방문하고 , 차례대로 큐에 삽입한다.
	static void BFS(int k) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(k);
		check[k]=true;
		while(!q.isEmpty()) {
			int x = q.remove();
			System.out.print(x + " ");
			for(int y:arr[x]) {
				if(check[y]==false) {
					check[y]=true;
					q.add(y);
				}
			}
		}
	}

	
	//DFS는 스택을 이용한다. 단계1. 시작정점을 넣어준다. 단계2. 정점과 연결된 방문하지않은 정점에 방문하고, 더이상 방문하지 않은 정점이 없을때 정점에서 나온다.
	static void DFS(int k) {
		if(check[k]==true) {
			return;
		}
		check[k]=true;
		System.out.print(k+" ");
		for(int i:arr[k]) {
			if(check[i]==false) {
				DFS(i);
			}
		}
	}
}
