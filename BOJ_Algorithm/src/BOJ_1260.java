import java.util.*;

public class BOJ_1260 {

	
	static int n,m,start;
	static boolean check[];
	static ArrayList<Integer>[] arr ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();	//n���� ������ ���� 1<=n<=1000������ Int�� �����ص� ������.
		m = sc.nextInt();	//m���� ������ ���� 1<=m<=10,000������ int�� ���� 
		start = sc.nextInt(); 	//��������
		
		
		//�迭�� Generic���� ����Ѱ�.
		arr= (ArrayList<Integer>[]) new ArrayList[n+1];
		//ArrayList a1 = new ArrayList();�� ���� ���
		//But, ArrayList�� ��� a1.add�� ���� ���� �߰��� �� �ִµ� �̶�, ���� type�� Object�� ��� ���� �޾Ƶ��ϼ� �ִ�.
		//�׷��� ������ ó�� �ʱ�ȭ�Ҷ�, �߰��ϴ� type�� �������ֱ����� <>�� �̿��ϴµ� , �̸� Generic��Ģ�̶� �Ѵ�.
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
	
	//BFS�� ť�� �̿��Ѵ�. �ڹ��� ��� ť�� LinkedList�� �̿��Ͽ� ������ �ذ��Ѵ�.
	//1.ť���� �ϳ��� ��带 ������. 2. �ش� ��忡 ����� ����� �湮���� ���� ��带 �湮�ϰ� , ���ʴ�� ť�� �����Ѵ�.
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

	
	//DFS�� ������ �̿��Ѵ�. �ܰ�1. ���������� �־��ش�. �ܰ�2. ������ ����� �湮�������� ������ �湮�ϰ�, ���̻� �湮���� ���� ������ ������ �������� ���´�.
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
