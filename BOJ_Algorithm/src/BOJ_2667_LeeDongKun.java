//�� �ڵ�� http://baked-corn.tistory.com/86 �� �ڵ��Դϴ�. 
//���� �¶��� ���� 2667�� ���� �ذ����Դϴ�.

import java.util.*;

public class BOJ_2667_LeeDongKun {
  public static void main(String args[]){
	  
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    int arr[][] = new int[N][N];

    
    // X,Y�� �ϳ��� �̵��Ͽ� �ֱ� ���� ���.
    int x[] = {-1, 0, 1, 0};
    int y[] = {0, -1, 0, 1};

    // �湮���θ� �Ǵ��ϱ� ���� visited�迭.
    boolean visited[][] = new boolean[N][N];

    //�Է��ϱ� ���� ���. ���⼭ String���� �����Ͽ� ��� �Է°��� next()�� ������, toCharArray()�� �̿��Ͽ� ������ �迭�� �����Ͽ���.
    // ����  char�� ����� �� �迭�� int�� �迭�� �����ϱ� ���Ͽ� !!!! - '0' !!!! �� �̿��Ͽ��µ� �̴� char�� int�� �ٲٴ� ����̴�.
    for(int i = 0; i < N; i++){
      String str = scan.next();
      char[] chars = str.toCharArray();
      for(int j = 0; j < N; j++){
        arr[i][j] = chars[j] - '0';
      }
    }

    //ù ������ 1�̶� ǥ���Ͽ���.
    int areaNumber = 1;
    //BFS�� �̿��Ͽ� ������ �ذ��ϱ� ���Ͽ� ArrayList�� �������.
    List<Integer> countList = new ArrayList<>();
    for(int i = 0; i < N; i++){
      for(int j = 0; j < N; j++){
    	  //arr���� 1�̰�, �湮������ ���� ��� BFS�� �����Ͽ��ش�.
        if(arr[i][j] == 1 && visited[i][j] != true){
          int count = 1;
          arr[i][j] = areaNumber;
          
          //ť�� �������־���, Pair�� �̿��Ͽ���. �湮������ ������, arr=1�� ������ ť�� �־��ְ�, �湮ó���� ���־���.
          Queue<Pair> queue = new LinkedList<>();
          queue.add(new Pair(i, j));
          visited[i][j] = true;
          //ť�� empty�Ҷ����� �����ϸ�, x�� y���� �̵���Ű�� ���Ͽ�, x,y�� ���� -1,1�� ���Խ����ְ�, x�� y�� 0���� ũ��, n���� ���� ��츦 �������ش�.
          while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int pointX = pair.getX();
            int pointY = pair.getY();
            for(int k = 0; k < 4; k++){
              int nextX = pointX + x[k];
              int nextY = pointY + y[k];
              if(nextX >= 0 && nextX < N && nextY >=0 && nextY < N){
                if(arr[nextX][nextY] == 1 && visited[nextX][nextY] != true){
                	//���� �������� ���ϱ� ���Ͽ� ����Ǿ��ִٸ� ���� ������ȣ�� �������ְ�, �湮ó���� ���ְ�, ���� ���ڸ� �÷��ش�.
                  arr[nextX][nextY] = areaNumber;
                  visited[nextX][nextY] = true;
                  queue.add(new Pair(nextX, nextY));
                  count += 1;
                }
              }
            }
          }
          
          //�� ������ �߰����ش�.
          countList.add(count);
          areaNumber += 1;
        }
      }
    }
    //Arraylist�� �����ϱ� ���Ͽ� Collections.sort�� �̿��Ͽ� �������� �����Ͽ���.
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