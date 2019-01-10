import java.util.Scanner;

public class InputChar {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		String map[][] = new String[a][b];
		
		for(int i = 0;i<a;i++) {
			String str = sc.next();
			for(int j = 0;j<b;j++) {
				map[i][j]=str.substring(j,j+1);
			}
		}
		
		for(int i = 0;i<a;i++) {
			for(int j = 0;j<b;j++) {
				System.out.print(map[i][j]);
			}System.out.println();
		}
		
		
	}

}
