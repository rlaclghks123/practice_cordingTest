package bfsPractice;

import java.io.IOException;
import java.util.*;

class Pair16236{
	int dist,x,y;
	Pair16236(int dist, int x, int y){
		this.dist = dist;
		this.x = x;
		this.y = y;
	}
}


public class Baby_shark16236 {
	
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	
	static Pair16236 bfs(int a[][], int sx, int sy, int size) {
		int n=a.length;
		int d[][] = new int [n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				d[i][j]=-1;
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(sx); q.add(sy);
		d[sx][sy]=0;								//방문처리 
		ArrayList<Pair16236> ans = new ArrayList<>();
		
		while(!q.isEmpty()) {
			int x=q.remove();
			int y=q.remove();
			
			for(int i=0; i<4; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(0<=nx && nx<n && ny>=0 && ny<n && d[nx][ny]==-1) {
					boolean ok=false;				//지나갈수 있음을 나타내기위해 
					boolean eat = false;			//먹을수 있음을 나타내기위해 
					
					if(a[nx][ny]==0) {				//빈칸일경우 
						ok = true;					//지나갈수 있음 
					}else if(a[nx][ny]<size) {		//크기가 사이즈보다 작을경우 
						eat = true; ok=true;		//지나가면서 먹기 까지 
					}else if(a[nx][ny]==size) {		//같은크기면 
						ok=true;					//지나갈수만 있음 
					}
					
					if(ok) {						
						q.add(nx); q.add(ny);
						d[nx][ny]=d[x][y]+1;
						if(eat) {					//먹으면 거리,위치를 늘려준다. 
							ans.add(new Pair16236(d[nx][ny],nx,ny));
						}
					}
				}
			}
		}
		
		if(ans.isEmpty()) {						//더이상 없다면 null return 
			return null;
		}
		
		Pair16236 best = ans.get(0);					//최소값을 구하기 위해 
		for(Pair16236 p:ans) {
			if(best.dist >p.dist) {
				best=p;
			}else if(best.dist == p.dist && best.x>p.x) {		//문제에서 거리가 같으면 왼쪽친구 먼저 
				best=p;
			}else if(best.dist == p.dist && best.x==p.x && best.y>p.y) {	//문제에서 거리가 같고, 같은친구 여러명이면 위쪽먼저 
				best=p;
			}
		}
		return best;
	}
	
	public static void main(String[] args)throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		
		int a[][] = new int[n][n];
		
		int x=0, y=0;					// 아기 상어 처음 위치 
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				a[i][j]=sc.nextInt();
				
				if(a[i][j]==9) {		//처음위치인 9를 찾았으면 
					x=i; y=j;			//x,y위치에 넣어주고 
					a[i][j]=0;			//빈칸으로 처리 
				}
			}
		}
		
		int ans=0;						//최종 최소거리값  
		int size=2;						//사이즈 
		int exp=0;						// 사이즈만큼 경험치가 커지면 사이즈가 커진다.
		
		while(true) {
			Pair16236 p = bfs(a,x,y,size);		//아기상어가 움직이는 bfs 
			if(p==null) break;				//더이상 없으면 break;
			
			a[p.x][p.y]=0;				//지나간곳은 빈칸처리 
			ans+=p.dist;				//지나간 거리는 값을 더해준다 
			exp++;						//경험치 + 
			if(exp==size) {				//사이즈만큼 경험치가 커진다면 사이즈가 커짐 
				size++;
				exp=0;					//경험치는 다시 0부터 
			}
			x=p.x;						//위치 재설정 
			y=p.y;
		}
		
		System.out.println(ans);
	}
}
