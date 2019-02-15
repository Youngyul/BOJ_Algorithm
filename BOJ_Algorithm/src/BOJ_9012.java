import java.util.*;


public class BOJ_9012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i =0;i<N;i++) {
			
			Stack<Character> s = new Stack<>();
			String str = sc.next();
			int top = s.size();
			boolean IMPOSSIBLE = true;
			
			
			for(int j =0;j<str.length();j++) {
				char c = str.charAt(j);
				
				if(c=='(') {
					s.push(c);
				}
				if(c==')') {
					if(!s.isEmpty()) {
						s.pop();
					}
					else {
						IMPOSSIBLE=false;
						break;
					}
				}
			}
			
		if(!s.isEmpty()) {IMPOSSIBLE = false;}
			
		if(IMPOSSIBLE) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
		}// 테스트케이스종료
	}
}

