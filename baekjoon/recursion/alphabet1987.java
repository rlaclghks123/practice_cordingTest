package recursion;

import java.util.*;

public class alphabet1987 {
	
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	
	static int go(String s[], boolean c[], int x, int y) {
		
		int ans=0;						//최대값을 찾기위해 
		
		for(int i=0; i<4; i++) {		//인접한부분을 찾아서 
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(0<=nx && nx<s.length && ny>=0 && ny<s[0].length()) {		//범위에 벗어나지 않는한.
				if(c[s[nx].charAt(ny)-'A']==false) {		//방문한적 없다면 
					c[s[nx].charAt(ny)-'A']=true;			//방문처리 
					
					int next=go(s,c,nx,ny);					//인접한곳으로 이동한 다음경우를 변수에담은뒤 
					if(ans<next) ans=next;					//최대값 찾고 
					
					c[s[nx].charAt(ny)-'A']=false;			//다시 돌려준다.
				}
			}
		}
		return ans+1;		//한칸 이동처리 해준다.
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		int m=sc.nextInt();
		
		String s[] = new String[n];
		boolean c[] = new boolean[26];
		
		for(int i=0; i<n; i++) {
			s[i]=sc.next();
		}
		
		c[s[0].charAt(0)-'A']=true;				//0,0에서 시작하기 때문에 방문처리.
		
		System.out.println(go(s,c,0,0));
	}

}
