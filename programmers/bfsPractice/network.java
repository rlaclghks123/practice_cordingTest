package bfsPractice;

public class network {
	//네트워크의 개수, 즉 그래프의 개수를 찾는 문제.
	class Solution {
	    public void dfs(int i, int [][] computers, boolean []check){
	        check[i]=true;							//방문처리 
	        
	        for(int j=0; j<computers.length; j++){		
	            if(check[j]==false && computers[i][j]==1){		//방문한적 없으면서, 연결되어있으면 
	                dfs(j,computers,check);						//거기서 또 연결된부분 찾는다. 
	            }
	        }
	    }
	    public int solution(int n, int[][] computers) {
	        int answer = 0;
	        boolean [] check = new boolean[n];		//정점방문을 확인하기 위함 
	        
	        for(int i=0; i<n; i++){					//방문한적 없다면 
	            if(check[i]==false){				
	                answer++;						//개수추가 
	                dfs(i,computers,check);			//연결되있는 부분찾는다.
	            }
	        }
	        return answer;							//개수 출력.
	    }
	}

}
