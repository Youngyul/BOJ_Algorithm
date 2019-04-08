import java.util.*;
import java.io.*;
 
// https://www.acmicpc.net/problem/14888
 
class BOJ_14888_SAMSUNG_EX_EXAM {
    static int n;
    static int[] a;
    static int[] operator;
    static int max = -987654321;
    static int min = 987654321;
 
    static int stoi(String s) { return Integer.parseInt(s); }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        n = stoi(br.readLine());
        a = new int[n];
        operator = new int[n-1];
 
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            a[i] = stoi(st.nextToken());
 
        st = new StringTokenizer(br.readLine());
        int idx = 0;
        for(int i=0; i<4; i++) {
            int temp = stoi(st.nextToken());
 
            // 1:µ¡¼À, 2:»¬¼À, 3:°ö¼À, 4:³ª´°¼À
            for(int j=0; j<temp; j++) {
                if(i == 0)  operator[idx++] = 1;
                else if(i == 1) operator[idx++] = 2;
                else if(i == 2) operator[idx++] = 3;
                else operator[idx++] = 4;
            }
        }
 
        // °è»ê ½ÃÀÛ
        permutation(0);
        System.out.println(max);
        System.out.println(min);
    }
 
    // ¼ø¿­ ±¸ÇÏ±â
    static void permutation(int depth) {
        if(depth == n-1) {            
            calculate();
            return;
        }
 
        for(int i=depth; i<n-1; i++) {
            swap(depth, i);
            permutation(depth + 1);
            swap(depth, i);
        }
    }
 
    static void swap(int i, int j) {
        int temp = operator[i];
        operator[i] = operator[j];
        operator[j] = temp;
    }
 
    // °¢ ¼ø¿­¿¡ ´ëÇØ¼­ ¿¬»ê ÈÄ max, min °ª Ã£±â
    static void calculate() {
        int result = a[0];
        
        for(int i=0; i<n-1; i++) {
            if(operator[i] == 1) result += a[i+1];
            else if(operator[i] == 2) result -= a[i+1];
            else if(operator[i] == 3) result *= a[i+1]; 
            else result /= a[i+1];
        }
 
        min = Math.min(min, result);
        max = Math.max(max, result);
    }
}