package hash;
import java.util.*;

	
	import java.util.*;

class Solutions {
 
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        
        int map[][] = new int[n][m];
        int d[][] = new int[n][m];
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<m; j++) {
        		d[i][j]=-1;
        	}
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(x); q.add(y);
        d[x][y]=0;
        int cnt=1;
        
        ArrayList<String> arr = new ArrayList<>();
        
        while(!q.isEmpty()) {
        	x=q.remove();
        	y=q.remove();
        	
        	for(int i=0; i<4; i++) {
        		int nx=x+dx[i];
        		int ny=y+dy[i];
        		if(0<=nx && nx<n && ny>=0 && ny<m) {
        			
        			if(cnt<=k) {
        				if(nx==1) {
        					System.out.println("r");
        					cnt++;
        				}
        				if(nx==-1) {
        					System.out.println("l");
        					cnt++;
        				}
        				if(ny==-1) {
        					System.out.println("d");
        					cnt++;
        				}
        				if(ny==1) {
        					System.out.println("u");
        					cnt++;
        				}
        				q.add(nx); q.add(ny);
        				d[nx][ny]=d[x][y]+1;
        			}
        		}
        	}
        }
        
        for(String a:arr) {
        	System.out.println(a);
        }
        return answer;
    }

}