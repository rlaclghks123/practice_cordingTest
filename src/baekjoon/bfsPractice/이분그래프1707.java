package bfsPractice;

import java.io.*;
import java.util.*;


public class 이분그래프1707 {
		
	static ArrayList<Integer> list[];

	public static void main(String[] args)throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0) {
			int n=sc.nextInt();				//정점의 개수 			
			int m=sc.nextInt();				//간선의 개수
			
			list = new ArrayList[n+1];		
			
			for(int i=1; i<=n; i++) {
				list[i] = new ArrayList<>();	
			}
			
			for(int i=1; i<=m; i++) {	
				int u=sc.nextInt();
				int v=sc.nextInt();
				
				list[u].add(v);
				list[v].add(u);
			}
			
			int c[]= new int[n+1];
			
			for(int i=1; i<=n; i++) {
				for(int y:list[i]) {			// 연결된 부분에서 
					if(c[y]==0) {				// 방문한적 없는경우 
						bfs(y,1,c);			
					}
				}
			}
			
			boolean ok = true;					//이분그래프 확인 하기 위한 변수
			for(int i=1; i<=n; i++) {
				for(int y:list[i]) {			//1부터 n까지 연결된 부분을 다 돌아서
					if(c[y]==c[i]) {			//만약 연결된 부분과 같은 그룹이라면 
						ok=false;				//이분그래프가 안되기 때문에 false 
					}
				}
			}
			
			if(ok) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}	
	}
	public static void bfs(int i, int g, int c[]) {
		c[i]=g;											//현재값을 그룹에 넣어준다.  
		
		for(int y:list[i]) {
			if(c[y]==0) {								//방문한적 없다면 
				bfs(y,3-g,c);							// 3-g에 넣어준다. 이유는 그래프가 2개 이므로, 	3-1(2), 3-2(1) 그룹에 넣어주기 위함  
			}
		}
	}
}
