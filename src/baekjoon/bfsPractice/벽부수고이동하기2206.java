package bfsPractice;

import java.io.*;
import java.util.*;

public class 벽부수고이동하기2206 {

	
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	
	public static void main(String[] args)throws IOException {
		
		Scanner sc = new Scanner(System.in);	
		
		int n=sc.nextInt();
		int m=sc.nextInt();

		int a[][] = new int[n][m];				//입력받을 배열 
		int d[][][] = new int[n][m][2];			//벽을 부순경우, 안부순 경우를 담을 배열.  배열로 담는 이유는 부순경우와 안부순경우중 더 적은값을 찾기위해 
		
		for(int i=0; i<n; i++) {
			String s = sc.next();
			for(int j=0; j<m; j++) {
				a[i][j]=s.charAt(j)-'0';
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(0); q.add(0); q.add(0);				//0부터 시작하므로  0,0을 담아주고 시작점은 무조건 0이므로 0을 담아준다.
		d[0][0][0]=1; 								//방문처리 
		
		while(!q.isEmpty()) {
			int x=q.remove();
			int y=q.remove();
			int z=q.remove();
			
			for(int i=0; i<4; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				if(0<=nx && nx<n && ny>=0 && ny<m) {	//범위 안에 있다면 
					
					//다음값이 0이면서, 벽을 부순적 없는경우 
					if(a[nx][ny]==0 && d[nx][ny][z]==0) {	
						q.add(nx); q.add(ny); q.add(z);
						d[nx][ny][z] = d[x][y][z]+1; 			//1칸 이동했으므로 1을 더해준다.
					}
					
					// 다음값이 1이면서, 벽을 부순적이 없는경우 
					if(z==0 && a[nx][ny]==1 && d[nx][ny][z+1]==0) {
						q.add(nx); q.add(ny); q.add(z+1);			//+1을 해줌으로서 벽을 부쉈다 처리한다.
						d[nx][ny][z+1] = d[x][y][z]+1;
					}
				}
			}
		}
		
		//벽을 부수지 않은 경우 , 벽을 부순경우 둘다 방문한적 있다면 최소값을 찾아준다.
		if(d[n-1][m-1][0]!=0 && d[n-1][m-1][1]!=0) {
			System.out.println(Math.min(d[n-1][m-1][0], d[n-1][m-1][1]));
		}
		
		// 벽을 부수지 않은경우 처리 
		else if(d[n-1][m-1][0]!=0) {
			System.out.println(d[n-1][m-1][0]);
		}
		
		//벽을 부순경우 처리 
		else if(d[n-1][m-1][1]!=0) {
			System.out.println(d[n-1][m-1][1]);
		}
		
		// 그외의 경우는 -1로 처리 
		else {
			System.out.println(-1);
		}
	}
}