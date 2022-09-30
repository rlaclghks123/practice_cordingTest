package bfsPractice;
import java.io.*;
import java.util.*;



public class 빙산2573 {

	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int map[][];

	static int n,m;
	
	public static void main(String[] args)throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		n=sc.nextInt();
		m=sc.nextInt();
		
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j]=sc.nextInt();						//입력받은 빙산의 정보를 map에 채워준다.		
			}
		}
		
		int ans=0;											// 두덩이로 분리되는 최초의 시간 
		int cnt=0;											// 총 빙하가 몇개인지 확인
		
		
		while((cnt=seperate())<2) {							//빙하가 한덩이일 경우 녹여주고, 그 이상일경우 0을 출력 
			if(cnt==0) {
				ans=0;
				break;
			}
			
			melt();											//빙하를 녹여준다.
			ans++;											//시간을 추가해준다. 
		}
		System.out.println(ans);
		}
	
	public static int seperate() {							//총 빙하가 몇개인지 확인하는 함수 
		int cnt=0;
		boolean c[][] = new boolean[n][m];					//방문 처리
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!c[i][j] && map[i][j]!=0) {				//방문한적 없으면서, 빙산일 경우 bfs로 연결된 빙산를 찾아준다. 
					bfs(i,j,c);
					cnt++;									//연결 안되있다면 cnt++
				}
			}
		}
		return cnt;											//총 빙산개수 출력 	
	}
	
	public static void bfs(int x, int y, boolean c[][]) {		//연결된 빙산을 찾아주는 함수 
		Queue<Integer> q = new LinkedList<>();
		q.add(x); q.add(y);
		c[x][y]=true;
		
		while(!q.isEmpty()) {
			x=q.remove();
			y=q.remove();
			for(int i=0; i<4; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(0<=nx && nx<n && ny>=0 && ny<m) {
					if(map[nx][ny]!=0 && !c[nx][ny]) {			//방문한적 없으면서 빙산이면 bfs 
						bfs(nx,ny,c);
					}
				}
			}
		}
	}
	
	public static void melt() {									//빙하를 녹이는 함수 
		Queue<Integer> q = new LinkedList<>();
		boolean visit[][] = new boolean[n][m];					//방문처리가 필요한게 1,2중 1이 녹았으면 2는 1이 0으로 바껴 0으로 처리할 수 있기 때문 
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]!=0) {								//빙산일경우 q에 넣어준다. 
					q.add(i); q.add(j);
					visit[i][j]=true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int sea=0;											//연결된 바다 개수를 체크
			int x=q.remove();
			int y=q.remove();
			for(int i=0; i<4; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(0<=nx && nx<n && ny>=0 && ny<m) {
					if(!visit[nx][ny] && map[nx][ny]==0) {		//방문한적 없는 바다일경우 
						sea++;									//바다 개수 추가 
					}
				}
			}
			if(map[x][y]-sea<0) {								//빙산을 녹였는데 0미만일경우 0으로 만듦 
				map[x][y]=0;
			}else {
				map[x][y]-=sea;									//그게 아니면 주변에 있는 바다만큼 녹여준다. 
			}
		}
		
	}
//	
}

//5 7
//0 0 0 0 0 0 0
//0 2 4 5 3 0 0
//0 3 0 2 5 2 0
//0 7 6 2 4 0 0
//0 0 0 0 0 0 0
