import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7576_LeeDongKun {

  public static void main(String args[]){
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    int M = scan.nextInt();
    int box[][] = new int[M][N];
    for(int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        box[i][j] = scan.nextInt();
      }
    }

    
    bfs(box, N, M);
  }

  
  //�μ� 3���� BFS�� �����Ѵ�. 
  
  static void bfs(int box[][], int N, int M){
	//x,y�� ���� �����¿�� �����̱� ���Ͽ� ������ ���� �����.
	int x[] = {0, -1, 0, 1};
    int y[] = {1, 0, -1, 0};
    int date = 0;

    //BFS�� �����ϱ� ���Ͽ� Queue�� �����.
    Queue<Pair> appleQueue = new LinkedList<>();
    boolean visited[][] = new boolean[M][N];
    
    for(int i = 0; i < M; i++){
      for(int j = 0; j < N; j++){
        //�丶�䰡 ���� ���(box[i][j]==1)�� ��쿡�� Ȯ���� �����ϱ� ������ 1�� ��찡 �������� �ȴ�.
    	  if(box[i][j] == 1){
          appleQueue.add(new Pair(i, j)); // �ʱ⿡ �ڽ��� �����ϴ� ������� ��ǥ�� ť�� �ִ´�.
          visited[i][j] = true;
        }
      }
    }

    //BFS�� ť�� empty�� ������!!!
    while(!appleQueue.isEmpty()){
      Pair point = appleQueue.poll();
      int pointX = point.getX();
      int pointY = point.getY();

      for(int i = 0; i < 4; i++){
        int toVisitX = pointX + x[i];
        int toVisitY = pointY + y[i];
        
        //�̵��ؾ��� ��� �� �ڽ��� �����ȿ� �־���Ѵ�!!.
        if(toVisitX >= 0 && toVisitX < M && toVisitY >= 0 && toVisitY < N){
        	//�̵����� ��찡 �丶�䰡 ���� �ʾƾ� �ϱ� ������, 0�̸�, �湮������ ���� ����̾��������.
          if(box[toVisitX][toVisitY] == 0 && visited[toVisitX][toVisitY] != true){
            appleQueue.add(new Pair(toVisitX, toVisitY));
            visited[toVisitX][toVisitY] = true;
            //�ϼ��� ���ϱ� ���Ͽ� �������� �̵��ϴ� ��� ���纸�� +1�� ���ش�.
            box[toVisitX][toVisitY] = box[pointX][pointY] + 1;
          }
        }
      }
    }
    
    //BFS�� ��� ������ �Ŀ��� box�� 0�� �����ִٸ�, ��� �丶�䰡 ���� ���ϴ� �ݷʿ� �ش��Ѵ�.
    //���� ��� �迭�� ���� ������ ���, N*M�� ���� �ȴٸ� ó������ �� �;��ִ� ����̴�.
    //�׷��� ���� ��� �迭�� ��� ���� �ִ밪�� �丶�䰡 �ʹµ� �ּڰ��� �ȴ�.
    
    int max = box[0][0];
    boolean isFill = true;
    int sum = 0;

    for(int i = 0; i < M; i++){
      for(int j = 0; j < N; j++){
        if(box[i][j] > max){
          max = box[i][j];
        }
        if(box[i][j] == 0){
          isFill = false;
        }
        sum += box[i][j];
      }
    }
    if(sum == N*M){
      System.out.println(0);
    }else if(!isFill){
      System.out.println(-1);
    }else{
      System.out.println(max - 1);
    }

  }

  static class Pair{
    private int x;
    private int y;

    Pair(int x, int y){
      this.x = x;
      this.y = y;
    }

    int getX(){return this.x;}
    int getY(){return this.y;}
  }
}