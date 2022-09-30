package bfsPractice;

import java.io.*;
import java.util.*;

 class Pair{						//x,y,거리를 사용하기 위해 Pair클래스를 만들어 값을 담아준다.
	int dist;
	int x;
	int y;
	
	public Pair(int dist, int x, int y) {
		this.dist=dist;
		this.x=x;
		this.y=y;
	}
}

public class 아기상어16236 {
	
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	
	
	public static void main(String[] args)throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		int a[][] = new int[n][n];			//입력받은 값을 담을 배열 			
		
		
		int x=0;							//아기상어의 위치를 담을 변수
		int y=0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				a[i][j]=sc.nextInt();	
				
				if(a[i][j]==9) {			//현재 아기상어의 위치를 찾은경우 
					x=i; y=j;				//좌표 바꿔주고 
					a[i][j]=0;				//빈칸처리 
				}
			}
		}
		
		int size=2;							//처음에 크기가 2부터 시작 
		int ans=0;							
		int exp=0;			
		
		while(true) {
			Pair p = bfs(a,x,y,size);				//bfs를 통해 아기상어가 움직인 거리,좌표를 p에 담아준다.
			
			if(p==null) break;					//아기상어가 지나갈수 없다면 종료 
			
			a[p.x][p.y]=0;						//방문한곳은 0으로 바꿔준다.
			exp++;								//경험치 +1 
			ans+=p.dist;						//총 거리를 더해준다. 
			if(size==exp) {						//경험치가 크기와 같아진다면 
				size++;							//크기를 늘려주고 
				exp=0;							//경험치는 다시 0부터 
			}
			x=p.x;								//좌표수정 
			y=p.y;								//좌표수정 		
		}
		System.out.println(ans);				//총 거리 출력 
	}
	
	public static Pair bfs(int a[][], int x, int y, int size) {
		Queue<Integer> q = new LinkedList<>();
		int n=a.length;
		int d[][] = new int[n][n];
		
		for(int i=0; i<n; i++) {
			Arrays.fill(d[i], -1);
		}
		
		q.add(x); q.add(y);
		d[x][y]=0;
		
		ArrayList<Pair> ans = new ArrayList<>();
		
		while(!q.isEmpty()) {
			x=q.remove();
			y=q.remove();
			for(int i=0; i<4; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				if(0<=nx && nx<n && ny>=0 && ny<n && d[nx][ny]==-1) {
					boolean ok=false;				//이동 가능한 경우 
					boolean eat=false;				//먹을수 있는 경우 
					
					if(a[nx][ny]==0 || a[nx][ny]==size) {
						ok=true;
					}else if(a[nx][ny]<=size) {
						ok=true; eat=true;
					}
					
					if(ok) {
						q.add(nx); q.add(ny);
						d[nx][ny]=d[x][y]+1;
						if(eat) {
							ans.add(new Pair(d[nx][ny],nx,ny));
						}
					}
				}
			}
		}
		
		if(ans.isEmpty()) {
			return null;
		}
		
		Pair res = ans.get(0);
		
		for(Pair p:ans) {
			if(res.dist>p.dist) {			//거리 최소값을 나타낸다. 
				res=p;
			}
			else if(res.dist==p.dist && res.x>p.x) {		//거리가 같으면 더 위에 있는 놈  
				res=p;
			}
			else if(res.dist==p.dist && res.x==p.x && res.y>p.y) {		//그거 또한 같으면 가장 왼쪽에 있는 놈 
				res=p;
			}
		}
		return res;
	}
}
