package bfsPractice;

import java.io.*;
import java.util.*;

public class 미로탐색2178 {

		
		static int dx[] = {1,-1,0,0};
		static int dy[] = {0,0,1,-1};
		
		public static void main(String[] args)throws IOException {
	    	
			Scanner sc = new Scanner(System.in);	
			
			int n=sc.nextInt();
			int m=sc.nextInt();
			int arr[][] = new int[n+1][m+1];
			int d[][] = new int[n+1][m+1];
			
			for(int i=0; i<n; i++) {
				String s = sc.next();
				for(int j=0; j<m; j++) {
					arr[i][j]=s.charAt(j)-'0';
					d[i][j]=-1;
				}
			}
			
			d[0][0]=1;
			
			Queue<Integer> q = new LinkedList<>();
			q.add(0);
			q.add(0);
			
			while(!q.isEmpty()) {
				int x=q.remove();
				int y=q.remove();
				
				for(int i=0; i<4; i++) {
					int nx=x+dx[i];
					int ny=y+dy[i];
					if(nx>=0 && nx<n && ny>=0 && ny<m) {
						if(d[nx][ny]==-1 && arr[nx][ny]==1) {
							q.add(nx); q.add(ny);
							d[nx][ny]=d[x][y]+1;
						}
					}
				}
			}
			System.out.println(d[n-1][m-1]);
		}
	}

