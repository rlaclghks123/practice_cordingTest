package bfsPractice;

public class changeWord {

	static boolean c[];			//방문처리 체크 배열 
	static int answer;			//결과값 

	class Solution {
	    
	    public int solution(String begin, String target, String[] words) {
	        c = new boolean[words.length];	

	        dfs(begin,target,words,0);
	        return answer;
	    }
	    
	    public void dfs(String begin, String target, String []words, int cnt){
	        //정답인 경우 				begin,target이 같을경우 count한 cnt값을 출력  
	    	if(begin.equals(target)){
	            answer=cnt;
	            return ;			//void형식 이므로 종료 
	        }
	        
	        for(int i=0; i<words.length; i++){	
	            if(c[i]){			//방문한적 있다면 넘겨준다.
	                continue;
	            }
	            int k=0;			//철자가 몇개 다른지 확인한느 변수   
	            for(int j=0; j<begin.length(); j++){
	                if(begin.charAt(j)!=words[i].charAt(j)){	//철자가 다르면 k에 ++
	                    k++;
	                }
	            }
	            if(k==1){			//철자가 한개 다르다면 
	                c[i]=true;		//방문처리 
	                dfs(words[i],target,words,cnt+1);	//dfs에 cnt+1을 해준다. 
	                c[i]=false;		//다음을 위해 false 처리 
	            }
	        }
	    }
	}
}
