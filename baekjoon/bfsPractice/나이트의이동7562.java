package bfsPractice;

import java.io.*;
import java.util.*;

public class 나이트의이동7562 {


	static int dx[] = {1,2,2,1,-1,-2,-2,-1};
	static int dy[] = {2,1,-1,-2,-2,-1,1,2};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t=sc.nextInt();		//테스트 케이스 개수 
		
		while(t-->0) {
		
			int n=sc.nextInt();		//범위를 입력받는다.
			
			//시작점을 입력 받는다.
			int sx=sc.nextInt();
			int sy=sc.nextInt();
			
			//끝점을 입력받는다.
			int ex=sc.nextInt();
			int ey=sc.nextInt();
			
			int d[][] = new int[n][n];		//나이트의 이동 개수를 파악하기 위한 배열 
			
			for(int i=0; i<n; i++) {
				Arrays.fill(d[i], -1);			//방문처리를 위해 -1로 채워준다. 
			}
			
			Queue<Integer> q= new LinkedList<>();
			q.add(sx); q.add(sy);				//시작점을 큐에 넣고 bfs 해준다.
			d[sx][sy]=0;						//방문처리 
			
			while(!q.isEmpty()) {
				int x=q.remove();
				int y=q.remove();
				
				for(int i=0; i<8; i++) {
					int nx=x+dx[i];
					int ny=y+dy[i];
					if(0<=nx && nx<n && ny>=0 && ny<n) {
						if(d[nx][ny]==-1) {					//방문한적 없다면 
							q.add(nx); 
							q.add(ny);
							d[nx][ny]=d[x][y]+1;			//거리를 +1해준다.
						}
					}
				}
			}
			System.out.println(d[ex][ey]);					//끝점에서 총 나이트의 이동수를 출력해준다.
		}
	}
}