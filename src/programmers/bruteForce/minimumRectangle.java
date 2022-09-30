package bruteForce;

public class minimumRectangle {
	class Solution {
	    public int solution(int[][] sizes) {
	        int answer = 0;
	        
	        // 최대 큰수와 최대 작은수를 정의한다.
	         int bigAns = 1;
	         int smallAns=1;
	         
	         //배열을 돌면서 큰수와 작은수를 찾는다.
	         for(int i=0; i<sizes.length; i++) {
	        	 int big=Math.max(sizes[i][0], sizes[i][1]);
	        	 int small = Math.min(sizes[i][0],sizes[i][1]);
	        	 
	        	 //큰수를 최대 큰수와 비교해 큰수를 찾는다.
	        	 if(big>bigAns) {
	        		 bigAns=big;
	        	 }
	        	 
	        	 //작은수를 최대작은수와 비교해 큰수를 찾는다.
	        	 if(small>smallAns) {
	        		 smallAns=small;
	        	 }
	         }
	        return answer=bigAns*smallAns;
	    }
	}
}
