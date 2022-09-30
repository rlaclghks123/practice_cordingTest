package bfsPractice;

import java.io.*;
import java.util.*;

public class 유기농배추1012 {
		
		static int dx[] = {0,0,1,-1};
		static int dy[] = {1,-1,0,0};
		
		public static void main(String[] args)throws IOException {
	    	
			Scanner sc = new Scanner(System.in);	
			
				int t=sc.nextInt();
				while(t-->0) {
					int n=sc.nextInt();				//가로의 길이 
					int m=sc.nextInt();				//세로의 길이 
					int total = sc.nextInt();		//배추의 총 개수 
					int arr[][] = new int[n][m];	//1의 위치를 담는 배열 
					int d[][] = new int[n][m];		//방문처리를 할 배열 
					
					int cnt=0;						//배추흰지렁이의 마리수를 담을 변수  
					
					for(int i=0; i<total; i++) {	//배추의 위치를 arr배열에 담아준다.
						int a=sc.nextInt();
						int b=sc.nextInt();
						arr[a][b]=1;
					}
					
					for(int i=0; i<n; i++) {
						for(int j=0; j<m; j++) {
							if(arr[i][j]==1 && d[i][j]==0) {		//배추가 존재하면서, 방문한적 없다면 
								 bfs(arr,d,i,j,++cnt,n,m);			//bfs를 통해 방문해준다.
								 
							}
						}
					}
					System.out.println(cnt);	
				}	
		}
		public static void bfs(int arr[][], int d[][], int x, int y, int cnt, int n, int m) {
			Queue<Integer> q = new LinkedList<>();
			d[x][y]=cnt;								//방문한곳은 같은 지렁이로 d배열을 채워준다.
			q.add(x); q.add(y);
			
			while(!q.isEmpty()) {
				x=q.remove();
				y=q.remove();
				for(int i=0; i<4; i++) {
					int nx=x+dx[i];
					int ny=y+dy[i];
					if(0<=nx && nx<n && ny>=0 && ny<m) {
						if(arr[nx][ny]==1 && d[nx][ny]==0) {
							q.add(nx); q.add(ny);
							d[nx][ny]=cnt;
						}
					}
				}
			}
		}
	}

	//1
	//5 3 6
	//0 2
	//1 2
	//2 2
	//3 2
	//4 2
	//4 0
