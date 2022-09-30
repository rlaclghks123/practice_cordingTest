package kakaoBlindRecruiment2022;

public class 파괴되지않는건물 {

	class Solution {
		
		int n,m;
		int sum[][];
		
	    public int solution(int[][] board, int[][] skill) {
	    	
	    	//skill : [type, r1, c1, r2, c2, degree] 형태를 가진다.
	    	//board : 처음 board값을 가진다.
	    	
	    	//n,m,sum[][]를 생성 및 초기화 해준다.
	    	n=board.length;
	    	m=board[0].length;
	    	sum = new int[n+1][m+1]; 		//sum 배열은 누적합으로 나타내기 위해 크기를 +1 해준다.
	    	int answer = 0;					//부서지지않은 총 건물의 개수를 찾을 변수 
	    	
	    	for(int s[]:skill) {
	    		int type = s[0];
	    		int r1 = s[1];
	    		int c1 = s[2];
	    		int r2 = s[3];
	    		int c2 = s[4];
	    		int degree = s[5] * (type==1 ? -1 : 1);		//type이 1일경우 degree를 지우고(공격), type이 0일경우 degree를 더해준다(회복).
	    		
	    		//누적합 알고리즘에 의해 a~d의 값을 구하는 방법은 모든합인 d에서 b와 c를 빼준뒤, a는 두번제거 됐으므로 a를 더해준다.
	    		sum[r1][c1]+=degree;			//a
	    		sum[r1][c2+1]+=-degree;			//b
	    		sum[r2+1][c1]+=-degree;			//c
	    		sum[r2+1][c2+1] +=degree;		//d	
	    	}
	    	
	    	
	    	
	    	fill();
	    	
	    	//부서지지 않은 건물을 찾아준다.
	    	for(int i=0; i<n; i++) {
	    		for(int j=0; j<m; j++) {
	    			if(board[i][j]+sum[i][j]>0) {
	    				answer++;
	    			}
	    		}
	    	}	    	
	        return answer;
	    }
	    
	    public void fill(){
			   for(int i=1; i<n; i++) {
				   for(int j=0; j<m; j++) {
					   sum[i][j]+=sum[i-1][j];
				   }
			   }
			   
			   for(int i=0; i<n; i++) {
				   for(int j=1; j<m; j++) {
					   sum[i][j]+=sum[i][j-1];
				   }
			   }
		   }
	}
	
}
