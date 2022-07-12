package bfsPractice;

import java.io.IOException;
import java.util.*;

class Pair{
	int dist,x,y;
	Pair(int dist, int x, int y){
		this.dist = dist;
		this.x = x;
		this.y = y;
	}
}


public class baby_shark {
	
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	
	static Pair bfs(int a[][], int sx, int sy, int size) {
		int n=a.length;
		int d[][] = new int [n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				d[i][j]=-1;
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(sx); q.add(sy);
		d[sx][sy]=0;
		ArrayList<Pair> ans = new ArrayList<>();
		
		while(!q.isEmpty()) {
			int x=q.remove();
			int y=q.remove();
			
			for(int i=0; i<4; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(0<=nx && nx<n && ny>=0 && ny<n && d[nx][ny]==-1) {
					boolean ok=false;
					boolean eat = false;
					
					if(a[nx][ny]==0) {
						ok = true;
					}else if(a[nx][ny]<size) {
						eat = true; ok=true;
					}else if(a[nx][ny]==size) {
						ok=true;
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
		
		Pair best = ans.get(0);
		for(Pair p:ans) {
			if(best.dist >p.dist) {
				best=p;
			}else if(best.dist == p.dist && best.x>p.x) {
				best=p;
			}else if(best.dist == p.dist && best.x==p.x && best.y>p.y) {
				best=p;
			}
		}
		return best;
	}
	
	public static void main(String[] args)throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		
		int a[][] = new int[n][n];
		
		int x=0, y=0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				a[i][j]=sc.nextInt();
				
				if(a[i][j]==9) {
					x=i; y=j;
					a[i][j]=0;
				}
			}
		}
		
		int ans=0;
		int size=2;
		int exp=0;
		
		while(true) {
			Pair p = bfs(a,x,y,size);
			if(p==null) break;
			
			a[p.x][p.y]=0;
			ans+=p.dist;
			exp++;
			if(exp==size) {
				size++;
				exp=0;
			}
			x=p.x;
			y=p.y;
		}
		
		System.out.println(ans);
	}
}
