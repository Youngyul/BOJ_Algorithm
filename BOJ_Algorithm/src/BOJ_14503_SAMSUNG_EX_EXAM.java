import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
 


//��ó : https://zoonvivor.tistory.com/130\



public class BOJ_14503_SAMSUNG_EX_EXAM {
 
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int N;
    static int M;
    static int count = 0;
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        String[] str = br.readLine().split(" ");
 
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        str = br.readLine().split(" ");
        int start_x = Integer.parseInt(str[0]);
        int start_y = Integer.parseInt(str[1]);
        int start_dir = Integer.parseInt(str[2]);
 
        int[][] arr = new int[N][M];
 
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        //--------------�Է�--------------
        
        Search(arr, start_x, start_y, start_dir);    //û�� ���� �Լ�
        Check(arr);    //û���� ĭ�� ������ ����
        System.out.println(count);
    }
 
    public static void Search(int[][] arr, int start_x, int start_y, int start_dir) {
        Queue<Dot> q = new LinkedList<Dot>();
        arr[start_x][start_y] = 9;
        q.add(new Dot(start_x, start_y, start_dir));
        while (!q.isEmpty()) {
            Dot d = q.poll();
            int currentX = d.x;    //���� x��ǥ
            int currentY = d.y;    //���� y��ǥ
            int currentD = d.dir;    //���� ����
            Boolean flags = false;    //4������ �� û�ҵ��ְų� ���� ��츦 �Ǵ�����.
            int nextX;
            int nextY;
            int nextD;
 
            for (int i = 0; i < 4; i++) {
                currentD = (currentD + 3) % 4;    //���� �̵��� ����
                nextX = currentX + (dx[currentD]);    //���� �̵��� X��ǥ
                nextY = currentY + (dy[currentD]);    //���� �̵��� Y��ǥ
 
                Dot nextDot = new Dot(nextX, nextY, currentD);
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }
                //���� �̵��� ��ġ��  û�ҵ��� ���� ���̶�� ����.
                if (arr[nextX][nextY] == 0) {
                    q.add(nextDot);
                    arr[nextX][nextY] = 9;
                    flags = true;
                    break;
                }
            }
            //4����� û�ҵưų� ���� ��쿡�� �����ؾ��Ѵ�.
            if (!flags) {
                nextD = (currentD + 2) % 4;
                nextX = currentX + dx[nextD];
                nextY = currentY + dy[nextD];
 
                //���� ������ ���� ���� �ƴ϶��, �̵� �׷��� �ʴٸ� �����Ѵ�.
                if (arr[nextX][nextY] != 1) {
                    arr[nextX][nextY] = 9;
                    q.add(new Dot(nextX, nextY, currentD));
                }
            }
        }
    }
 
    //û���� ĭ�� ������ ���ϴ� �Լ�
    public static void Check(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 9)
                    count++;
                //System.out.print(arr[i][j] + "\t");
            }
            //System.out.println();
        }
    }
}
 
class Dot {
    int x;
    int y;
    int dir;
 
    Dot(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}
