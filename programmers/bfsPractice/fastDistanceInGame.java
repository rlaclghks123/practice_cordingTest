package bfsPractice;
import java.util.*;

public class fastDistanceInGame {

	class Solution {
	    
	        int dx[] = {1,-1,0,0};
	        int dy[] = {0,0,1,-1};
	        
	    
	    public int solution(int[][] maps) {
	        
	        int n=maps.length;		
	        int m=maps[0].length;
	    
	        int d[][] = new int[n][m];
	        Queue<Integer> q = new LinkedList<>();
	        
	        for(int i=0; i<n; i++){
	            for(int j=0; j<m; j++){
	                d[i][j]=-1;				//거리를 위한 배열 -1로 초기화 함으로서 방문처리  
	            }
	        }
	        q.add(0); q.add(0);				//시작점 q에 넣어준다. 
	        d[0][0]=1;						//방문처리 
	        while(!q.isEmpty()){
	            int x=q.remove();
	            int y=q.remove();
	            for(int i=0; i<4; i++){
	                int nx=x+dx[i];
	                int ny=y+dy[i];
	                if(0<=nx && nx<n && ny>=0 && ny<m){
	                    if(d[nx][ny]==-1 && maps[nx][ny]==1){		//방문한적 없으면서 입력값이 1일경우 
	                        q.add(nx); q.add(ny);
	                        d[nx][ny]=d[x][y]+1;
	                    }
	                }
	            }
	        }
	        return d[n-1][m-1];
	    }
	}

}
