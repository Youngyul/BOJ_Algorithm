import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class BOJ_7569 {
    private static int M, N, H;
    private static int[][][] box;
    private static int[] dirX = {0, 1, 0, -1, 0, 0}; // X ÁÂÇ¥
    private static int[] dirY = {1, 0, -1, 0, 0, 0}; // Y ÁÂÇ¥
    private static int[] dirZ = {0, 0, 0, 0, 1, -1}; // Z ÁÂÇ¥
 
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        H = Integer.parseInt(input[2]);
        box = new int[H][N][M];
 
        for(int i=0 ; i<H ; i++){
            for(int j=0 ; j<N ; j++){
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for(int k=0 ; k<M ; k++) {
                    box[i][j][k] = Integer.parseInt(tokenizer.nextToken());
                }
            }
        }
 
        Queue<Tomato> queue = new LinkedList<>();
        for(int i=0 ; i<H ; i++){
            for(int j=0 ; j<N ; j++) {
                for(int k=0 ; k<M ; k++){
                    if (box[i][j][k] == 1) {
                        queue.offer(new Tomato(i, j, k));
                    }
                }
            }
        }
 
        bfs(queue);
 
        int count = 0;
        for(int i=0 ; i<H ; i++){
            for(int j=0 ; j<N ; j++){
                for(int k=0 ; k<M ; k++) {
                    if (box[i][j][k] == 0) {
                        System.out.println("-1");
                        return;
                    }
                    if (count < box[i][j][k]) {
                        count = box[i][j][k];
                    }
                }
            }
        }
 
        System.out.println(count-1);
    }
 
    private static void bfs(Queue<Tomato> queue){
        while(!queue.isEmpty()){
            Tomato front = queue.peek();
            queue.poll();
 
            for(int i=0 ; i<6 ; i++){ // ÀÍÀº Åä¸¶Åä ÁÖº¯ 6¹æÇâ
                int newH = front.getH() + dirZ[i];
                int newN = front.getN() + dirY[i];
                int newM = front.getM() + dirX[i];
 
                if((0 <= newH && newH < H) && (0 <= newN && newN < N) && (0 <= newM && newM < M)){
                    if(box[newH][newN][newM] == 0){
                        box[newH][newN][newM] += box[front.getH()][front.getN()][front.getM()] + 1;
                        queue.offer(new Tomato(newH, newN, newM));
                    }
                }
            }
        }
    }
 
    public static class Tomato{
        int h, n, m;
 
        Tomato(int h, int n, int m) {
            this.h = h;
            this.n = n;
            this.m = m;
        }
 
        int getH(){return h;}
 
        int getN(){return n;}
 
        int getM(){return m;}
    }
}



