package bruteForce;

public class carpet {
	class Solution {
	    public int[] solution(int brown, int yellow) {
	        int[] answer = new int[2]; //가로와 세로 2개의 크기를 할당 
	        
	        //brown, yellow의 합의 약수중 정답이 있다.
	        int sum = brown+yellow;
	        
	        //가로(row)와 세로(col)는 3이상 이어야 한다.
	        for(int i=3; i<=sum; i++) {
	        	int col=i;
	        	int row=sum/col;
	        	
	        	if(row<3) continue;
	        	
	        	if(row>=col) {
	        		//yellow를 가운데 위치시키기 위해 row-2 * col-2 = yellow 규칙을 만족해야한다.
	        		if((row-2)*(col-2)==yellow) {
	        			answer[0]=row;
	        			answer[1]=col;

	        			return answer; 			//값을 찾았으면 return 해준다.
	        		}
	        	}
	        }
	        return answer;
	    }
	}
}
