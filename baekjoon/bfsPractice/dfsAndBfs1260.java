package bfsPractice;

import java.util.*;

public class dfsAndBfs1260 {

	static ArrayList<Integer> list[];
	static boolean c[];
	
	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
		
		
		int n=sc.nextInt();			//정점의 개수 
		int m=sc.nextInt();			//간선의 개수 
		int start=sc.nextInt();		//시작점
		
		list = new ArrayList[n+1];	//ArrayList를 통해 연결을 해준다.
		
		
		for(int i=1; i<=n; i++) {					//기본 크기를 할당해준다.
			list[i]= new ArrayList<Integer>();	
		}
		
		
		for(int i=1; i<=m; i++) {		//1부터 m까지 정점을 연결시켜준다. 
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i=1; i<=n; i++) {		//문제에서 정점의개수가 같으면 더 작은 정점부터 탐색한다 했기 때문에 정렬해준다.
			Collections.sort(list[i]);
		}
		
		c = new boolean[n+1];			
		dfs(start);
		System.out.println();
		
		c = new boolean[n+1];
		bfs(start);	
	}
	
	static public void dfs(int start) {
		c[start]=true;
		System.out.print(start+" ");
		for(int y:list[start]) {
			if(c[y]==false) {
				dfs(y);
			}
		}
	}
	
	static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		c[n]=true;
		while(!q.isEmpty()) {
			int x=q.remove();
			System.out.print(x+" ");
			for(int y:list[x]) {
				if(c[y]==false) {					
				q.add(y);
				c[y]=true;
				}
			}
		}
	}
	
 
}


//4 5 1
//1 2
//1 3
//1 4
//2 4
//3 4