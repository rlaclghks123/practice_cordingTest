package bfsPractice;

import java.io.*;
import java.util.*;
	

public class 촌수계산2644 {
	
	static ArrayList<Integer> list[];		//연결리스트를 만들어준다.
	static int ans = -1;					//총 촌수의 값을 나타내며, 나타낼수 없을경우 -1로 나타내기 위해 -1로 기본값을 할당 
	static boolean c[];
	
	public static void main(String[] args)throws IOException {
		
		Scanner sc = new Scanner(System.in);
	
		int n=sc.nextInt();		//총 정점의 개수 
		
		int start=sc.nextInt();		//시작 정점 
		int end=sc.nextInt();		//끝 정접 
		
		int t=sc.nextInt();			//총 간선의 개수 
		
		list = new ArrayList[n+1];
		c = new boolean[n+1];		//방문처리 
		
		for(int i=1; i<=n; i++) {
			list[i]=new ArrayList<>();
		}
		
		for(int i=1; i<=t; i++) {
			int u=sc.nextInt();
			int v=sc.nextInt();
			list[u].add(v);
			list[v].add(u);
		}
		
		dfs(start,end,0);			//시작점, 끝점, 촌수를 통해 dfs해준다.
		System.out.println(ans);
	}
	public static void dfs(int start, int end, int cnt) {
		if(start==end) {
			ans=cnt;				//시작점과 끝점이 같을경우 ans값을 cnt로 바꿔준다. 
			return;					//찾았으니 바로 종료 
		}
		
		c[start]=true;				//방문처리 
		
		for(int next:list[start]) {		//연결된 정점을 방문 
			if(!c[next]) {				//방문한적 없다면 
				dfs(next,end,cnt+1);	//연결된부분을 시작으로, cnt+1해주면서 다시 dfs탐색 
			}
		}
		
	}
}
