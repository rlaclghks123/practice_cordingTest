package bfsPractice;

import java.io.*;
import java.util.*;


public class 토마토7576 {
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int m=sc.nextInt();
		int n=sc.nextInt();
		
		int a[][] = new int[n][m];
		int d[][] = new int[n][m];
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				a[i][j]=sc.nextInt();
				d[i][j]=-1;					//방문하지 못한곳을 -1로 초기화 해준다.
				
				if(a[i][j]==1) {			//토마토가 있는곳은 
					q.add(i); q.add(j);		//bfs를 처리하기 위해 큐에 담아준다.
					d[i][j]=0;				//방문처리 해준다.
				}
			}
		}
		
		//bfs 실행 
		while(!q.isEmpty()) {
			int x=q.remove();
			int y=q.remove();
			for(int i=0; i<4; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(0<=nx && nx<n && ny>=0 && ny<m) {		//범위를 벗어나지 않는 선에서 
					if(a[nx][ny]==0 && d[nx][ny]==-1) {		//토마토가 익지 않았으면서 방문한적 없는 인접한곳을 방문해준다.
						q.add(nx); q.add(ny);
						d[nx][ny]=d[x][y]+1;				//방문한곳의 날짜를 하루씩 늘려준다.
					}
				}
			}
		}
		
		int ans=0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(ans<d[i][j]) ans=d[i][j];					//토마토가 익는데 얼마나 걸리는지 출력해준다.
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(a[i][j]==0 && d[i][j]==-1) ans=-1;			//아직까지 토마토가 익지 않았으며, 방문한적이 없으면 익지못하기 때문에 -1로 처리 
			}
		}
		System.out.println(ans);
	}
}

//6 4
//0 0 0 0 0 0
//0 0 0 0 0 0
//0 0 0 0 0 0
//0 0 0 0 0 1