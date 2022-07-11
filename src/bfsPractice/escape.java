package bfsPractice;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class escape {
	static int dx[] = {1,-1,0,0};	//상하좌우,대각,제자리 
	static int dy[] = {0,0,1,-1};
	
	public static void main(String[] args)throws IOException {
    	
	Scanner sc = new Scanner(System.in);	
	
	int n=sc.nextInt();
	int m=sc.nextInt();
	
	int sx=0,sy=0;  			//고슴도치 위치 초기화 
	int ex=0,ey=0;				//비버굴 위치 초기화
	
	int d[][] = new int[n][m];		//고슴도치 이동 배열
	int water[][] = new int[n][m];	//물 이동 배열 
	String s[] = new String[n];		//입력값 
	
	for(int i=0; i<n; i++) {
		s[i]=sc.next();
		for(int j=0; j<m; j++) {
			d[i][j]=-1;				// 방문처리를 위해 -1로 초기화 
			water[i][j]=-1;			//  //
		}
	}
	
	Queue<Integer> q = new LinkedList<>();
	
	
	for(int i=0; i<n; i++) {
		for(int j=0; j<m; j++) {
			if(s[i].charAt(j)=='*') {  		//물이 있을경우 
				q.add(i); q.add(j);			//인접한부분 물로 바꾸기 위한 초기값 
				water[i][j]=0;
			}else if(s[i].charAt(j)=='S') {	//고슴도치 위치
				sx=i;						//위치값을 넣어 준다. 
				sy=j;
			}else if(s[i].charAt(j)=='D') {	//비버굴 위치 
				ex=i;						//위치값을 넣어준다. 
				ey=j;
			}
		}
	}
	
	//물과 인접한 경우 물로 채우는 BFS 
	while(!q.isEmpty()) {
		int x=q.remove();
		int y=q.remove();
		for(int i=0; i<4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(0<=nx && nx<n && ny>=0 && ny<m) {
				if(water[nx][ny]!=-1) continue;			//방문한적 있으면 넘김 
				if(s[nx].charAt(ny)=='X')continue;		//X== 벽 일 경우 넘김 
				if(s[nx].charAt(ny)=='D')continue;		//D 비버굴일경우 넘김 
				q.add(nx); q.add(ny);					//인접한 부분 물로 채워준다. 
				water[nx][ny]=water[x][y]+1;			//크기측정 
			}
		}
	}
	
	q.add(sx); q.add(sy);		//고슴도치 처음위치 값을 넣어준다. 
	d[sx][sy]=0;				//방문처리 
	
	//고슴도치 이동부분을 위한 BFS 
	while(!q.isEmpty()) {
		int x=q.remove();
		int y=q.remove();
		for(int i=0; i<4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(0<=nx && nx<n && ny>=0 && ny<m) {
				if(d[nx][ny]!=-1) continue;				//방문한적 있으면 넘김 
				if(s[nx].charAt(ny)=='X')continue;		//벽일경우 넘김 
				if(water[nx][ny]!=-1 && d[x][y]+1>=water[nx][ny]) continue;	//고슴도치 이동크기가 물크키보다 작아야 함(클경우 넘김)  
				q.add(nx); q.add(ny);					//고슴도치 이동 
				d[nx][ny]=d[x][y]+1;
			}
		}
	}
	if(d[ex][ey]==-1) {						//만약 고슴도치가 방문 못했으면 
		System.out.println("KAKTUS");
	}else {									//고슴도치가 방문했으면 최소거리 
		System.out.println(d[ex][ey]);
	}
   }
}
