package bfsPractice;

import java.util.*;
import java.util.*;
public class getItem {
	
}
	class Solution{
		static int answer;
		static int dx[] = {1,-1,0,0};
		static int dy[] = {0,0,1,-1};
		static int map[][];
		
		
		public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
	        answer=0;        
	        map= new int[101][101];
	        
	        //탐색은 선이 아닌 좌표를 기준으로 하기 때문에, 바로 연결되있는지 or 다른경로로 연결 됐는지 판단하기 힘들다.
	        //따라서 크기를 두배 늘려줌으로서 빈칸을 만들어 탐색을 해준다. 
	        //테두리부분은 1로, 좌표는 2배로 채워준다. 
	        for(int i=0; i<rectangle.length; i++) {
	        	fill(2*rectangle[i][0],2*rectangle[i][1],2*rectangle[i][2],2*rectangle[i][3]);
	        }
	        //2배해준 값을통해 bfs를 해준다.
	        bfs(2*characterX,2*characterY,2*itemX,2*itemY);
	        
	        //2배 해줬기 때문에 /2로 출력을 해준다. 
	        return answer/2;
	    }
		
		//테두리는 1 나머진 2로 채워준다. 
		public void fill(int x1, int y1, int x2, int y2) {
			for(int i=x1; i<=x2; i++) {
				for(int j=y1; j<=y2; j++) {
					if(map[i][j]==2) continue;	//이미 2로 됐으면 바꿀필요 없다.
					map[i][j]=2;				//2로 채워준다. 
					
					if(i==x1 || i==x2 || j==y1 || j==y2) {	//테두리 부분
						map[i][j]=1;			//1로 채워준다. 
					}
				}
			}
		}
		
		public void bfs(int sx, int sy, int ex, int ey) {
			boolean c[][] = new boolean[102][102];
			
			Queue<Integer> q = new LinkedList<>();
			q.add(sx); q.add(sy);
			c[sx][sy]=true;
			
			while(!q.isEmpty()) {
			int x=q.remove();
			int y=q.remove();
			for(int i=0; i<4; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(0<=nx && nx<101 && ny>=0 && ny<101) {			//범위 내에서 
					if(map[nx][ny]==1 && c[nx][ny]==false) {		//테두리인부분 이면서 방문한적 없을경우 
						map[nx][ny]=map[x][y]+1;					//크기를 늘려준다.
						
						if(nx==ex && ny==ey) {						//목표지점 도달했다면 
							answer=(answer==0) ? map[nx][ny] : Math.min(answer, map[nx][ny]); //0인경우 처리 및 최소값을 찾아준다.
						}
						q.add(nx); q.add(ny);
						c[nx][ny]=true;
					}
				}
			}
			
		}
	}	
	}