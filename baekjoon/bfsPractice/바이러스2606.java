package bfsPractice;

import java.io.*;
import java.util.*;

public class 바이러스2606 {


		
		static ArrayList<Integer> list[];
		static boolean c[];
		static int ans=0;						//감염된 컴퓨터의 수 
		
		public static void main(String[] args)throws IOException {
	    	
			Scanner sc = new Scanner(System.in);	
			
				int n=sc.nextInt();				//컴퓨터의수 
				int m=sc.nextInt();				//네트워크상 연결된 컴퓨터의수 (간선의 수)
				
				list = new ArrayList[n+1];
				c = new boolean[n+1];
				
				for(int i=1; i<=n; i++) {
					list[i]=new ArrayList<>();		//기본값 할당
				}
				
				for(int i=1; i<=m; i++) {			//서로 연결시켜준다.		
					int u=sc.nextInt();
					int v=sc.nextInt();
					list[u].add(v);
					list[v].add(u);
				}
				bfs(1);								//bfs를 통해 1부터 탐색한다. 
				System.out.println(ans);
			}
		

		static public void bfs(int start) {			//bfs를 통해 탐색해준다. 
			Queue<Integer> q = new LinkedList<>();
			q.add(start);							//시작점을 넣고 
			c[start]= true;							//방문처리 
			while(!q.isEmpty()) {
				int x=q.remove();					
				for(int y:list[x]) {
					if(c[y]==false) {
						ans++;
						q.add(y);
						c[y]=true;
					}
				}
			}
		}
	}

//7
//6
//1 2
//2 3
//1 5
//5 2
//5 6
//4 7