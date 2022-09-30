package bfsPractice;

import java.io.*;
import java.util.*;

public class 영역구하기2583 {
	
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int map[][];
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);	
		
		int n=sc.nextInt();		//x축 
		int m=sc.nextInt();		//y축 
		int t=sc.nextInt();		//총 직사각형 개수
		
		map= new int[n][m];
		
		for(int i=0; i<t; i++) {		
			int sy=sc.nextInt();		
			int sx=sc.nextInt();
			
			int ey=sc.nextInt();
			int ex=sc.nextInt();
			fill(sx,sy,ex,ey);			//주어진 직사각형을 map에 1로 채워준다.
		}
		
		Queue<Integer> q = new LinkedList<>();
		int d[][] = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				d[i][j]=-1;
			}
		}
		int cnt=0;						//영역의 개수 
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]==0 && d[i][j]==-1) {			//직사각형이 없으면서 방문한적 없으면 
					bfs(d,i,j,++cnt,n,m);					//영역을 만들어준다. 
				}
			}
		}
		System.out.println(cnt);						//영역의 개수 출력 
		
		int ans[] = new int[cnt+1];						//1부터 사용하기 때문에 +1 
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				for(int k=1; k<=cnt; k++) {				//각 영역의 개수를 추가해준다.
					if(d[i][j]==k) {
						ans[d[i][j]]++;
					}
				}
			}
		}
		Arrays.sort(ans);								//오름차순으로 나타내기 위해 정렬 해준다.
		
		for(int i=1; i<=cnt; i++) {
			System.out.print(ans[i]+" ");
		}
	}
	
	public static void fill(int sx, int sy, int ex, int ey) {
		for(int i=sx; i<ex; i++) {
			for(int j=sy; j<ey; j++) {
				map[i][j]=1;
			}
		}
	}
	
	public static void bfs(int d[][], int x, int y, int cnt, int n, int m) {
		Queue<Integer> q =new LinkedList<>();
		q.add(x); q.add(y);
		d[x][y]=cnt;
		
		while(!q.isEmpty()) {
			x=q.remove();
			y=q.remove();
			for(int i=0; i<4; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(0<=nx && nx<n && ny>=0 && ny<m) {
					if(map[nx][ny]==0 && d[nx][ny]==-1) {
						q.add(nx); q.add(ny);
						d[nx][ny]=cnt;
					}
				}
			}
		}
	}
}
