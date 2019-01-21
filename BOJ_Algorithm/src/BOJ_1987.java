import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class BOJ_1987 {
    
    static int r,c,cnt=0,max=0,ax,ay;
    static int dx[]={1,-1,0,0};
    static int dy[]={0,0,1,-1};
    static int map[][]=new int[21][21];
    static boolean check[]=new boolean[26];
    
    public static void main(String args[]) throws NumberFormatException, IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        
        for(int i = 1 ; i <= r ; i++){
            String s = br.readLine();
            for(int j = 1 ; j<= c ; j++){
                map[i][j]=s.charAt(j-1)-'0';
            }
        }
        
     
        
        dfs(1,1);
        System.out.println(max);
    }
    //��Ʈ��ŷ
    public static void dfs(int a, int b){
        cnt++;
        if(max<cnt){
            max = cnt;
        }
        //�湮�� ���ĺ� üũ 
        check[map[a][b]]=true;
        
        for(int i = 0 ; i < 4 ; i++){
            ax = a+dx[i];
            ay = b+dy[i];
            if(ax>0&&ay>0&&ax<=r&&ay<=c){
                if(!check[map[ax][ay]]){
                    dfs(ax,ay);
                }
            }
        }
        
        //Ž�� �������� ī��Ʈ����/���ĺ�üũ����
        cnt--;
        check[map[a][b]]=false;
    }
}