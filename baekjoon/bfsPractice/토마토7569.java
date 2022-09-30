package bfsPractice;

import java.util.*;

public class 토마토7569 {

		static int dx[] = {0,0,1,-1,0,0};			//좌우위아래상하
		static int dy[] = {1,-1,0,0,0,0};			//좌우위아래상하
		static int dz[] = {0,0,0,0,1,-1};			//좌우위아래상하
		
		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);	
			
			int m=sc.nextInt();						//가로 
			int n=sc.nextInt();						//세로 
			int h=sc.nextInt();						//높이 
			
			int a[][][] = new int[h][n][m];			//입력받은 배열 
			int d[][][] = new int[h][n][m];			//총 날짜를 세는 배열 
			
			Queue<Integer> q = new LinkedList<>();
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<n; j++) {
					for(int k=0; k<m; k++) {
						a[i][j][k]=sc.nextInt();		//입력을 받는다.		
						d[i][j][k]=-1;					//들리지 않을경우를 처리하기위해 -1로 해준다.
						
						if(a[i][j][k]==1) {				//만약 토마토가 있다면 
							q.add(i); q.add(j); q.add(k);	//q에 담아준다.
							d[i][j][k]=0;					//방문처리 
						}
					}
				}
			}
			
			while(!q.isEmpty()) {
				int f=q.remove();							//높이 
				int x=q.remove();							//가로 
				int y=q.remove();							//세로 
				
				for(int i=0; i<6; i++) {					//좌,우,앞,뒤,위,아래 총 6개 
					int nf=f+dz[i];
					int nx=x+dx[i];
					int ny=y+dy[i];
					
					if(0<=nf && 0<=nx && 0<=ny && nf<h && nx<n && ny<m) {		//범위 안에 있다면 
						if(a[nf][nx][ny]==0 && d[nf][nx][ny]==-1) {				//토마토가 익지 않았으면서 방문한적없을경우 
							q.add(nf); q.add(nx); q.add(ny);					//토마토를 익혀준
							d[nf][nx][ny]=d[f][x][y]+1;							//날짜를 1일 추가 
						}
					}
				}
			}
			int ans=0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<n; j++) {
					for(int k=0; k<m; k++) {
						if(ans<d[i][j][k]) ans=d[i][j][k];						//날짜를 찾아준다.
					}
				}
			}
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<n; j++) {
					for(int k=0; k<m; k++) {
						if(a[i][j][k]==0 && d[i][j][k]==-1) ans=-1;				//다 돌았는데 아직 익지 않았다면 익을수없기때문에 -1 
					}
				}
			}
			System.out.println(ans);
			
	}
}
