package stackAndQueue;

import java.util.*;

public class Main {
	class Solution {
		 
		 int dx[] = {0,0,1,-1};
		 int dy[] = {1,-1,0,0};
		
	    public String solution(int n, int m, int x, int y, int r, int c, int k) {
	        String answer = "";
	        int max=50;
	        char map[][] = new char[max][max];
	        int d[][] = new int[max][max];
	        
	        for(int i=1; i<=n; i++) {
	        	for(int j=1; j<=m; j++) {
	        		d[i][j]=-1;
	                if(i==x && j==y) {
	                	map[i][j]='S';
	                }else if(i==r && j==c) {
	                	map[i][j]='E';
	                }else {
	                	map[i][j]='.';
	                }
	        	}
	        }
	        
	        Queue<Integer> q = new LinkedList<>();
	        q.add(x); 
	        q.add(y);
	        d[x][y]=0;
	        
	        
	        ArrayList<String> arr = new ArrayList<>();
	        int cnt=0;
	        while(!q.isEmpty()) {
	        	x=q.remove();
	        	y=q.remove();
	        	
	        	for(int i=0; i<4; i++) {
	        		int nx=x+dx[i];
	        		int ny=y+dy[i];
	        		if(1<=nx && nx<=n && ny>=1 && ny<=m) {
	        			
	                    if(map[nx][ny]=='.' || map[nx][ny]=='E'){
	                        if(d[nx][ny]<k){
	                        	
	                        cnt++;
	        				q.add(nx); q.add(ny);
	        				d[nx][ny]=d[x][y]+1;
	        				if(nx==1) {
	        					arr.add("r");
	        				}
	        				if(nx==-1) {
	        					arr.add("l");
	        				}
	        				if(ny==1) {
	        					arr.add("u");
	        				}
	        				if(nx==-1) {
	        					arr.add("d");
	        				}
	                        }
	        			}
	        		
	                }
	        	}
	        }
	        for(int i=1; i<=n; i++) {
	        	for(int j=1; j<=m; j++) {
	                System.out.print(d[i][j]+" ");
	            }System.out.println();
	        }
	        // System.out.println(d[r-1][c-1]);
	        
	        return answer;
	    }

	}


}

//2중 fo