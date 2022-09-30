package bruteForce;

import java.util.*;
public class dividingGraphIntoTwo {
	
	class Solution {
		int arr[][];
		
	    public int solution(int n, int[][] wires) {
	        int answer = n;
	        //인접행렬 크기를 할당 
	        arr = new int[n+1][n+1];
	        
	        //인접 행렬을 통해 그래프를 만들어준다.
	        for(int i=0; i<wires.length; i++) {
	        	arr[wires[i][0]][wires[i][1]]=1;
	        	arr[wires[i][1]][wires[i][0]]=1;
	        }
	        
	        int a;
	        int b;
	        for(int i=0; i<wires.length; i++) {
	        	a=wires[i][0];					//어떤 한 
	        	b=wires[i][1];
	        	
	        	//그래프에서 모든 선을 1개씩 자른다.
	        	arr[a][b]=0;
	        	arr[b][a]=0;
	        	
	        	//bfs를 통해 송전탑의 최소값을 찾아준다.
	        	answer = Math.min(answer, bfs(n,a));
	        	
	        	//자른 선을 복구해준다.
	        	arr[a][b]=1;
	        	arr[b][a]=1;
	        }
	        return answer;
	    }
	    
	    public int bfs(int n, int start) {
	    	boolean c [] = new boolean[n+1];
	    	int cnt=1;							//송전탑의 개수 
	    	
	    	Queue<Integer> q = new LinkedList<>();
	    	q.add(start);
	    	
	    	while(!q.isEmpty()) {
	    		int x=q.remove();
	    		c[x]=true;					//방문처리 
	    		for(int i=1; i<=n; i++) {
	    			
	    			if(!c[i] && arr[x][i]==1) {		//x와 연결된 부분이 방문한적 없으면   
	    					q.add(i);				//q에 담아주고 
	    					cnt++;					//개수 추가 
	    			}
	    		}
	    	}
	    	return (int)Math.abs(cnt-(n-cnt));
	    }
	}
}
