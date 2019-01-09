import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
 
public class BOJ_11650_mygumi {
    static PriorityQueue<Point> q = new PriorityQueue<Point>(new ComparatorAscending());
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        int t = Integer.parseInt(br.readLine().trim());
        Point point;
 
        String s[] = new String[2];
        for (int i = 0; i < t; i++) {
            s = br.readLine().split(" ");
 
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
 
            point = new Point(x, y);
 
            q.add(point);
        }
 
        for (int i = 0; i < t; i++) {
            Point pp = q.poll();
            sb.append(pp.x + " " + pp.y + "\n");
        }
        System.out.println(sb.toString());
    }
}
 
class ComparatorAscending implements Comparator<Point> {
    @Override
    public int compare(Point p1, Point p2) {
        // TODO Auto-generated method stub
        if (p1.y < p2.y) {
            return -1;
        } else if (p1.y == p2.y) {
            if (p1.x < p2.x) {
                return -1;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}
 
class Point {
    int x;
    int y;
 
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


//출처: http://mygumi.tistory.com/58 [마이구미의 HelloWorld]