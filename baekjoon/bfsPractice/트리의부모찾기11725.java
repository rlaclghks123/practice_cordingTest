package bfsPractice;

import java.io.*;
import java.util.*;

public class 트리의부모찾기11725 {
	
	static ArrayList<Integer> list[];				//arrayList를 통해 연결리스트를 만든다. 
	
	static boolean c[];								//방문처리를 위함 
	static int parent[];							//부모를 저장할 배열 
	
	public static void main(String[] args)throws IOException {
		
		Scanner sc = new Scanner(System.in);	
		
		int n=sc.nextInt();
		
		//크기를 할당 
		list = new ArrayList[n+1];						
		c = new boolean[n+1];							
		parent = new int[n+1];
		
		//빈값으로 채워준다.
		for(int i=1; i<=n; i++) {
			list[i]=new ArrayList<>();
		}
		
		//입력받은 정점들을 연결시켜준다.
		for(int i=1; i<=n-1; i++) {
			int u=sc.nextInt();
			int v=sc.nextInt();
			list[u].add(v);
			list[v].add(u);
		}
		
		//1~n까지 다 방문해야 하기 때문에, 방문한적 없다면 dfs를 통해 방문해준다.
		for(int i=1; i<=n; i++) {
			if(c[i]==false) {
				dfs(i);
			}
		}
		
		//부모의 노드를 구하기 때문에 1이 아닌 2부터 찾아준다.
		for(int i=2; i<=n; i++) {
			System.out.println(parent[i]);
		}
	}
	
	public static void dfs(int i) {
		c[i]=true;							//방문처리 
		
		for(int y:list[i]) {				//연결된 모든 부분을 반복해준다. 
			if(c[y]==false) {				//방문한적 없다면 
				parent[y]=i;				//부모배열에 값을 담는다.
				dfs(y);						//dfs처리 
			}
		}
	}
}