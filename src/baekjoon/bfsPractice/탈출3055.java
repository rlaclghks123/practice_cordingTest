package bfsPractice;

import java.io.*;
import java.util.*;


public class 탈출3055 {

	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	
	public static void main(String[] args)throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();			
		int m=sc.nextInt();
		
		char map[][] = new char[n][m];
		int d[][] = new int[n][m];
		int water[][] = new int[n][m];
		
		for(int i=0; i<n; i++) {
			map[i]=sc.next().toCharArray();
		}
		
		//시작지점과 끝점을 모르기 때문에 -1로 초기화 해둔다.
		int sx=-1, sy=-1, ex=-1, ey=-1;
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				d[i][j]=-1;
				water[i][j]=-1;
				
				if(map[i][j]=='*') {			//*일 경우 물로 BFS처리 해준다.
					water[i][j]=0;
					q.add(i); q.add(j);
				}
				else if(map[i][j]=='S') {		//시작점이므로 sx,sy를 설정해준다.
					sx=i; sy=j;
				}
				else if(map[i][j]=='D') {		//끝점이므로 ex,ey를 설정해준다.
					ex=i;  ey=j;
				}
			}
		}
		
		//물을 bfs로 채워준다. 
		while(!q.isEmpty()) {	
			int x=q.remove();
			int y=q.remove();
			for(int i=0; i<4; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(0<=nx && nx<n && ny>=0 && ny<m) {
					if(water[nx][ny]==-1) {
						if(map[nx][ny]=='X') continue;		//벽일 경우 넘김 
						if(map[nx][ny]=='D') continue;		//비버굴의 경우도 넘김  
						q.add(nx); q.add(ny);
						water[nx][ny]=water[x][y]+1;
					}
				}
			}
		}
		
		//고슴도치를 이동을 bfs로 채워준다.  
		q.add(sx); q.add(sy);
		d[sx][sy]=0;
		
		while(!q.isEmpty()) {
			int x=q.remove();
			int y=q.remove();
			for(int i=0; i<4; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(0<=nx && nx<n && ny>=0 && ny<m) {
					if(map[nx][ny]=='X') continue;			//벽일 경우 넘김 
					if(d[nx][ny]==-1) {
						if(water[nx][ny]!=-1 && d[x][y]+1>=water[nx][ny]) continue;		//물이 방문했는데, 현재보다 1초후가 물로 잠긴다면 넘김
							q.add(nx); q.add(ny);
							d[nx][ny]=d[x][y]+1;
						}
				}
			}
		}
		if(d[ex][ey]==-1) {								//비버굴을 방문할수 없다면 
			System.out.println("KAKTUS");
		}else {											//최단기간을 출력
			System.out.println(d[ex][ey]);
		}
	}
}