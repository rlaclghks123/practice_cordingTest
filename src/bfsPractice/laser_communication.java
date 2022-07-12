package bfsPractice;

import java.util.*;

//하나의 정점에서 이어지는 정점을통해 최소 거울 개수를 구하는 것 : BFS 사용 
//방향이 바뀌면 거울의 개수가 추가되는 경우이다. 
// 방향이 바뀌면 을 어떻게 표현할것인가? => while문을 통해 범위를 벗어나거나 벽을 마주치면 멈춰주는 방식 사용

public class laser_communication {

	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int m=sc.nextInt();
		int n=sc.nextInt();
		
		String a[] = new String[n];
		
		int sx=-1, sy=-1, ex=-1, ey=-1;				//시작지점(C), 끝지점 찾아주기(C) 
		
		for(int i=0; i<n; i++) {
			a[i]=sc.next();
			for(int j=0; j<m; j++) {
				if(a[i].charAt(j)=='C') {			// C를 만났을 경우 
					if(sx==-1) {					//처음 C라면 
						sx=i;						//sx,sy에 위치를 넣어준다. 
						sy=j;
					}else {							//두번째 C인경우 
						ex=i;						//ex,ey 즉 마지막 위치를 넣어준다. 
						ey=j;
					}
				}
			}
		}
		int d[][] = new int[n][m];					//최단거리 측정 배열 
		
		for(int i=0; i<n; i++) {					//방문처리를 위해 -1로 초기화 
			for(int j=0; j<m; j++) {
				d[i][j]=-1;
			}
		}
		
		Queue<Integer> q= new LinkedList<>();
		q.add(sx); q.add(sy);						//시작지점을 넣어준다. 
		d[sx][sy]=0;
		
		while(!q.isEmpty()) {
			int x=q.remove();
			int y=q.remove();
			for(int i=0; i<4; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				while(0<=nx && nx<n && ny>=0 && ny<m) {		//while을 통해, 범위를 벗어나거나 벽을 만날경우 중지 아니면 계속 이어진다. 
					if(a[nx].charAt(ny)=='*') break;		//벽을 만난경우 
					if(d[nx][ny]==-1) {						//방문한적이없다면 
						q.add(nx); q.add(ny);				
						d[nx][ny]=d[x][y]+1;
					}
					nx+=dx[i];								//움직이는 만큼 계속 추가해준다. 
					ny+=dy[i];
				}
			}
		}
		System.out.println(d[ex][ey]-1);					//레이저가 3방향으로 움직였다면 거울은 2개 이므로 -1 해준다.
	}
}
