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

  
  //인수 3개의 BFS를 실행한다. 
  
  static void bfs(int box[][], int N, int M){
	//x,y는 각각 상하좌우로 움직이기 위하여 다음과 같이 만든다.
	int x[] = {0, -1, 0, 1};
    int y[] = {1, 0, -1, 0};
    int date = 0;

    //BFS를 실행하기 위하여 Queue를 만든다.
    Queue<Pair> appleQueue = new LinkedList<>();
    boolean visited[][] = new boolean[M][N];
    
    for(int i = 0; i < M; i++){
      for(int j = 0; j < N; j++){
        //토마토가 있을 경우(box[i][j]==1)인 경우에만 확산이 가능하기 때문에 1인 경우가 시작점이 된다.
    	  if(box[i][j] == 1){
          appleQueue.add(new Pair(i, j)); // 초기에 박스에 존재하는 사과들의 좌표를 큐에 넣는다.
          visited[i][j] = true;
        }
      }
    }

    //BFS는 큐가 empty할 때까지!!!
    while(!appleQueue.isEmpty()){
      Pair point = appleQueue.poll();
      int pointX = point.getX();
      int pointY = point.getY();

      for(int i = 0; i < 4; i++){
        int toVisitX = pointX + x[i];
        int toVisitY = pointY + y[i];
        
        //이동해야할 경우 가 박스의 범위안에 있어야한다!!.
        if(toVisitX >= 0 && toVisitX < M && toVisitY >= 0 && toVisitY < N){
        	//이동했을 경우가 토마토가 익지 않아야 하기 때문에, 0이며, 방문한적이 없는 경우이어야함으로.
          if(box[toVisitX][toVisitY] == 0 && visited[toVisitX][toVisitY] != true){
            appleQueue.add(new Pair(toVisitX, toVisitY));
            visited[toVisitX][toVisitY] = true;
            //일수를 구하기 위하여 다음으로 이동하는 경우 현재보다 +1을 해준다.
            box[toVisitX][toVisitY] = box[pointX][pointY] + 1;
          }
        }
      }
    }
    
    //BFS를 모두 수행한 후에도 box에 0이 남아있다면, 모든 토마토가 익지 못하는 반례에 해당한다.
    //또한 모든 배열의 합을 구했을 경우, N*M의 값이 된다면 처음부터 다 익어있는 경우이다.
    //그렇지 않은 경우 배열의 모든 값중 최대값이 토마토가 익는데 최솟값이 된다.
    
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