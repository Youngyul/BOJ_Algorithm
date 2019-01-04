//본 코드는 http://baked-corn.tistory.com/86 의 코드입니다. 
//백준 온라인 저지 2667번 문제 해결방법입니다.

import java.util.*;

public class BOJ_2667_LeeDongKun {
  public static void main(String args[]){
	  
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    int arr[][] = new int[N][N];

    
    // X,Y를 하나식 이동하여 주기 위한 방법.
    int x[] = {-1, 0, 1, 0};
    int y[] = {0, -1, 0, 1};

    // 방문여부를 판단하기 위한 visited배열.
    boolean visited[][] = new boolean[N][N];

    //입력하기 위한 방법. 여기서 String으로 선언하여 모든 입력값을 next()로 받은후, toCharArray()를 이용하여 각각을 배열에 저장하였다.
    // 이후  char로 저장된 각 배열을 int로 배열에 저장하기 위하여 !!!! - '0' !!!! 을 이용하였는데 이는 char을 int로 바꾸는 방법이다.
    for(int i = 0; i < N; i++){
      String str = scan.next();
      char[] chars = str.toCharArray();
      for(int j = 0; j < N; j++){
        arr[i][j] = chars[j] - '0';
      }
    }

    //첫 구역을 1이라 표현하였다.
    int areaNumber = 1;
    //BFS를 이용하여 문제를 해결하기 위하여 ArrayList를 만들었다.
    List<Integer> countList = new ArrayList<>();
    for(int i = 0; i < N; i++){
      for(int j = 0; j < N; j++){
    	  //arr값이 1이고, 방문한적이 없는 경우 BFS를 실행하여준다.
        if(arr[i][j] == 1 && visited[i][j] != true){
          int count = 1;
          arr[i][j] = areaNumber;
          
          //큐를 생성해주었고, Pair를 이용하였다. 방문한적이 없으며, arr=1인 지역을 큐에 넣어주고, 방문처리를 해주었다.
          Queue<Pair> queue = new LinkedList<>();
          queue.add(new Pair(i, j));
          visited[i][j] = true;
          //큐가 empty할때까지 시행하며, x와 y값을 이동시키기 위하여, x,y에 각각 -1,1을 대입시켜주고, x와 y가 0보다 크고, n보다 작은 경우를 제한해준다.
          while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int pointX = pair.getX();
            int pointY = pair.getY();
            for(int k = 0; k < 4; k++){
              int nextX = pointX + x[k];
              int nextY = pointY + y[k];
              if(nextX >= 0 && nextX < N && nextY >=0 && nextY < N){
                if(arr[nextX][nextY] == 1 && visited[nextX][nextY] != true){
                	//값은 구역으로 정하기 위하여 연결되어있다면 같은 구역번호를 지정해주고, 방문처리를 해주고, 집의 숫자를 올려준다.
                  arr[nextX][nextY] = areaNumber;
                  visited[nextX][nextY] = true;
                  queue.add(new Pair(nextX, nextY));
                  count += 1;
                }
              }
            }
          }
          
          //총 갯수를 추가해준다.
          countList.add(count);
          areaNumber += 1;
        }
      }
    }
    //Arraylist를 정렬하기 위하여 Collections.sort를 이용하여 오름차순 정렬하였다.
    Collections.sort(countList);
    System.out.println(areaNumber - 1);
    for (int number: countList){
      System.out.println(number);
    }
  }

  static class Pair{
    private int x;
    private int y;

    Pair(int x, int y){
      this.x = x;
      this.y = y;
    }

    int getX(){
      return x;
    }

    int getY(){
      return y;
    }
  }
}