package bfsPractice;

import java.io.*;
import java.util.*;

public class 보물섬2589 {

	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static char map[][];
	static int n,m;
	static int max=0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n=sc.nextInt();
		m=sc.nextInt();
		
		map = new char[n][m];
		
		for(int i=0; i<n; i++) {
			map[i]=sc.next().toCharArray();		// map을 채워준다.
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]=='L') {
					bfs(i,j);					//육지인 경우 bfs를 돌려준다.
				}
			}
		}
		System.out.println(max);
}
	
	public static void bfs(int x, int y) {
		int d[][] = new int[n][m];				//d배열을 bfs함수 내에 선언 하는 이유는, 매번 초기화 해야 하기 때문 
		for(int i=0; i<n; i++) Arrays.fill(d[i], -1);
		
		Queue<Integer> q = new LinkedList<>();
		q.add(x); q.add(y);
		d[x][y]=0;								//방문처리
		
		while(!q.isEmpty()) {
			x=q.remove();
			y=q.remove();
			for(int i=0; i<4; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(0<=nx && nx<n && ny>=0 && ny<m) {
					if(d[nx][ny]==-1 && map[nx][ny]=='L') {			//방문한적 없으면서, 육지(L)인 경우 
						q.add(nx); q.add(ny);
						d[nx][ny]=d[x][y]+1;
						max=Math.max(d[nx][ny], max);				//최대값을 찾아준다. 
					}
				}
			}
		}
	}
}
