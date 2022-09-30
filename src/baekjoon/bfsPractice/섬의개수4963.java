package bfsPractice;

import java.io.*;
import java.util.*;

public class 섬의개수4963 {
	
	static int dx[] =  {0,1,1,1, 0, -1,-1,-1};			//대각선까지 포함하기 위해 8개로 만든다.
	static int dy[] =  {1,1,0,-1,-1,-1, 0, 1};
	 
	
	public static void main(String[] args)throws IOException {
		
		Scanner sc = new Scanner(System.in);	
		
		while(true) {
			int m=sc.nextInt();
			int n=sc.nextInt();
			
			int a[][] = new int[n][m];
			int g[][] = new int[n][m];
			
			if(n==0 && m==0) break;				//0 0을 입력받을경우 반복문 탈출 
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					a[i][j]=sc.nextInt();		//입력받은 값을 배열에 담아준다. 
					g[i][j]=-1;					//방문처리를 위해 
				}
			}
			
			int cnt=0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(a[i][j]==1 && g[i][j]==-1) {			//입력받은 배열의 값이 1이면서 방문한적이 없다면 
						bfs(a,g,i,j,++cnt,n,m);				//bfs를 통해 섬의 개수를 구해준다.
					}
				}
			}
			System.out.println(cnt);
		}
	}
	
	public static void bfs(int a[][], int g[][], int x, int y, int cnt, int n, int m) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x); q.add(y);
		g[x][y]=cnt;
		
		while(!q.isEmpty()) {
			x=q.remove();
			y=q.remove();
			for(int i=0; i<8; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(0<=nx && nx<n && ny>=0 && ny<m) {
					if(a[nx][ny]==1 && g[nx][ny]==-1) {
						q.add(nx); q.add(ny);
						g[nx][ny]=cnt;
					}
				}
			}
		}
	}
}
