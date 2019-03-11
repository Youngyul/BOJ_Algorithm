import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
 
public class BOJ_2644 {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
         
        Scanner sc = new Scanner(System.in);
         
        // 사람숫자
        int n = sc.nextInt();
         
        // 문제
        int a = sc.nextInt();
        int b = sc.nextInt();
         
        // 링크갯수
        int m = sc.nextInt();
         
        // 관계
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < m; i++)   {
            int value = sc.nextInt(); // 부모
            int key = sc.nextInt();   // 자식
             
            map.put(key, value);
        }
         
        ArrayList<Integer> alist = new ArrayList<Integer>();
        ArrayList<Integer> blist = new ArrayList<Integer>();
         
        alist.add(a);
        blist.add(b);
        for(int i = 1; i <= m; i++)  {
            Integer parent = map.get(a);
            if(parent == null)  {
                break;
            }else   {
                alist.add(parent);
                a = parent;
            }
        }
         
        for(int i = 1; i <= m; i++)  {
            Integer parent = map.get(b);
            if(parent == null)  {
                break;
            }else   {
                blist.add(parent);
                b = parent;
            }
        }
         
        int rslt = -1;
        for(int i = 0; i < alist.size(); i++)    {
            for(int j = 0; j < blist.size(); j++)    {
                if(alist.get(i).equals(blist.get(j)))   {
                    rslt = i+j;
                    break;
                }
            }
             
            if(rslt != -1)  {
                break;
            }
        }
         
        System.out.println(rslt);
    }
}


//출처: https://hianna.tistory.com/163 [어제 오늘 내일]
