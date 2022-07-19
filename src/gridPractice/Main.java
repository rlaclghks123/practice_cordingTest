package gridPractice;

import java.io.*;
import java.util.*;

public class Main {
	
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static int group[][];
	static boolean c[][];
	static int a[][];
	static int n,m;
	static ArrayList<Integer> group_size = new ArrayList<>();
	
	static void bfs(int sx, int sy) {
		
		int g=group_size.size();
		int cnt=1;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(sx); q.add(sy);
		group[sx][sy]=g;
		c[sx][sy]=true;
		
		while(!q.isEmpty()) {
			int x=q.remove();
			int y=q.remove();
			for(int i=0; i<4; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(0<=nx && nx<n && ny>=0 && ny<m) {
					if(a[nx][ny]==0 && c[nx][ny]==false) {
					q.add(nx); q.add(ny);
					group[nx][ny]=g;
					c[nx][ny]=true;
					cnt++;
					}
				}
			}
		}
		
	group_size.add(cnt);	
	}
    
    public static void main(String args[]) throws IOException {
   
//    	Scanner sc  = new Scanner(System.in);
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	String s[] = br.readLine().split(" ");
    	n = Integer.parseInt(s[0]);
    	m = Integer.parseInt(s[1]);
    	
    	a = new int[n][m];
    	group = new int[n][m];
    	c = new boolean [n][m];
    	
    	for(int i=0; i<n; i++) {
    		String str=br.readLine();
    		for(int j=0; j<m; j++) {
    			a[i][j]=str.charAt(j)-'0';
    			group[i][j]=-1;
    			c[i][j]=false;
    		}
    	}
    	
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<m; j++) {
    			if(a[i][j]==0 && c[i][j]==false) {
    				bfs(i,j);
    			}
    		}
    	}
    	
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<m; j++) {
    			if(a[i][j]==0) {
    				bw.write("0");
    			}else {
    				HashSet<Integer> near = new HashSet<>();
    				for(int k=0; k<4; k++) {
    					int x=i+dx[k];
    					int y=j+dy[k];
    					if(0<=x && x<n && y>=0 && y<m) {
    						if(a[x][y]==0) {
    							near.add(group[x][y]);
    						}
    					}
    				}
    				int ans=1;
    				for(int g:near) {
    					ans+=group_size.get(g);
    				}
    				bw.write(String.valueOf(ans%10));
    			}
    		}
    		bw.write("\n");
    	}
    	bw.flush();
    	
    }
}