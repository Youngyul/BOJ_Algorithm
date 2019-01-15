import java.util.*;

//���ͽ�Ʈ�� �˰����� ���. ���������� �������� ������������ ���� value�� ���� ������ �������� PriorityQueue�� �����ϸ�ȴ�.
//�÷��̵�ͼ� �˰����� ���. �ܹ����� ������ �־����� ��찡 �ٹݻ��̰�, �� ��� �������� ������ �������� �����Ѵ�.




public class BOJ_1238 {

	static int N,M,X;
	static boolean check [][];
	static int time [][];
	static int max = 100000;
	static int result [][];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();	//������ ����
		M=sc.nextInt();	//���� ����
		X=sc.nextInt();	//X�� �������� ��ġ.
		
		time = new int [N+1][N+1];
		check = new boolean [N+1][N+1];
		
		for(int i = 0;i<M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			time[a][b]= c;
			check[a][b]=true;
		}
		
		for(int i = 1 ; i<=N;i++) {
			for(int j = 1 ; j<=N;j++) {
				if(i==j) {
					time[i][j]=0;
				}
				if(i!=j&&check[i][j]==false) {
					time[i][j]=max;
				}
			}
		}
		
		floydWarshall();
		//���� ���� �ɸ��� �л��� �ҿ�ð��� ���Ѵ�.
		//System.out.println();
		int arr [] = new int [N+1];
		int max = 0;
		for(int i = 1; i<=N;i++) {
			arr[i]= result[i][X]+result[X][i];
			if(max<arr[i]) {
				max = arr[i];
			}
		}
		System.out.println(max);
		
		
	}
	
	
	//I���� X�� �̵��ϴ� �÷��̵� �ͼ� �ѹ�, X���� I�� �̵��ϴ� �÷��̵� �ͼ� �ѹ�.
	
	static void floydWarshall() {
		 result = new int[N+1][N+1];
		
		for(int i = 1 ; i<=N;i++) {
			for(int j = 1; j<=N;j++) {
				result[i][j]=time[i][j];
			}
		}
		
		//k�� ���İ��� ���
		for(int k = 1 ; k<=N;k++) {
			//���۳��
			for(int i = 1 ; i<=N;i++) {
				//�������
				for(int j = 1; j<=N;j++) {
					if(result[i][k]+result[k][j]<result[i][j]) {
						result[i][j]= result[i][k]+result[k][j];
					}
				}
			}
		}
		
		/*�÷��̵� �ͼ� �˰��� ���
		for(int i = 1 ; i<=N;i++) {
			for(int j = 1; j<=N;j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
		*/
		
	}
	


	static class Node{
	
		int end;
		int value;
		
		Node(int end,int value){
			this.end=end;
			this.value = value;
		}
	}
	
	
}
