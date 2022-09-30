package bruteForce;

public class fatigability {
	class Solution {
		
		//전역변수로 사용 dfs에서 사용하기 위해 
		boolean check[]; 	
		int answer = 0;
		
	    public int solution(int k, int[][] dungeons) {
	    	
	    	//check 배열 크기 할당 
	    	check = new boolean[dungeons.length];
	    	
	    	//dfs 실행 
	    	dfs(0,k,dungeons);
	    	
	        return answer;
	    }
	    
	    public void dfs(int depth, int k , int dungeons[][]) {
	    	for(int i=0; i<dungeons.length; i++) {
	    		if(!check[i] && dungeons[i][0]<=k) {		//방문한적 없거나, 첫번째 값이 k이하일 경우 
	    			check[i] = true;						//방문처리
	    			dfs(depth+1, k-dungeons[i][1], dungeons);	//깊이+1 , 소모될 피로도를 현재 피로도값에서 빼준다. 
	    			check[i] = false;						//다음경우를 처리하기 위해 되돌리기 
	    		}
	    	}
	    	answer = Math.max(depth, answer); 				//최대값을 찾아준다. 
	    }
	}
}
