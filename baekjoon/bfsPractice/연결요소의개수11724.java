package bfsPractice;

import java.io.*;
import java.util.*;

public class 연결요소의개수11724 {

	static ArrayList<Integer> list[];
	static boolean c[];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();		//정점의 개수 
		int m=sc.nextInt();		//간선의 개수 
		
		list = new ArrayList[n+1];		//list의 크기를 정점의 개수만큼 할당한다.
		c = new boolean[n+1];
		
		for(int i=1; i<=n; i++) {
			list[i]=new ArrayList<>();	
		}
		
		for(int i=1; i<=m; i++) {
			int u=sc.nextInt();			//입력받은 정점들을 list를 통해 연결시켜준다. 
			int v=sc.nextInt();
			list[u].add(v);
			list[v].add(u);
		}
		
		int ans=0;						//총 연결요소의 개수  
		
		for(int i=1; i<=n; i++) {
			if(c[i]==false) {			//방문하지 않은 정점들을 bfs로 다 방문해준다.
				dfs(i);
				ans++;
			}
		}
		System.out.println(ans);
	}

	public static void dfs(int start) {		
		c[start]=true;
		
		for(int y:list[start]) {			//연결된 모든 정점들중 
			if(c[y]==false) {				//방문하지 않았다면 
				dfs(y);						//dfs해준다. 
			}
		}
	}
}
