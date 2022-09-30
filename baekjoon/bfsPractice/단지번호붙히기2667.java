package bfsPractice;

import java.io.*;
import java.util.*;

public class 단지번호붙히기2667 {
		
		 static int dx[] = {1,-1,0,0};
		 static int dy[] = {0,0,1,-1};
		
		public static void main(String[] args)throws IOException {
	    	
			Scanner sc = new Scanner(System.in);	
			
				int n=sc.nextInt();				 
				int a[][] = new int[n][n];		//입력배열 
				int g[][] = new int[n][n];		//group지을 배열
				
				for(int i=0; i<n; i++) {
					String s = sc.next();
					for(int j=0; j<n; j++) {
						a[i][j]=s.charAt(j)-'0';
					}
				}
				
				int cnt=0;						//배열의 개수를 나타낼 변수
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
						if(a[i][j]==1 && g[i][j]==0) {	//1이면서 그룹이 없다면 
							bfs(a,g,i,j,++cnt,n);		//++cnt로 bfs해준다. 
						}
					}
				}
				
				int ans[] = new int[cnt];				//그룹 개수만큼 정답을 배열에 담아준다.
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
						if(g[i][j]!=0) {
							ans[g[i][j]-1]++;			//-1 해주는 이유는 1부터 시작하는데, 배열은 0부터 크기를 할당하기 위해
						}
					}
				}
				
				Arrays.sort(ans);						//오름차순으로 나타내기위해 정렬 
				System.out.println(cnt);				//총 개수 출력 
				for(int i=0; i<cnt; i++) {				//개수만큼 최대 크기를 구해준다. 
					System.out.println(ans[i]);
				}
		}
		
		static public void bfs(int a[][], int g[][], int x, int y, int cnt, int n) {
			g[x][y]=cnt;								//그룹을 cnt크기로 만들어준다. 
			Queue<Integer> q = new LinkedList<>();
			q.add(x); q.add(y);
			
			while(!q.isEmpty()) {
				x=q.remove();
				y=q.remove();
				for(int i=0; i<4; i++) {
					int nx=x+dx[i];
					int ny=y+dy[i];
					if(0<=nx && nx<n && ny>=0 && ny<n) {
						if(a[nx][ny]==1 && g[nx][ny]==0) {
							q.add(nx); q.add(ny);
							g[nx][ny]=cnt;
						}
					}
				}
				
			}
		}
}
