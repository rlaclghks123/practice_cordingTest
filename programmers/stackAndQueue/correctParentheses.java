package stackAndQueue;

import java.util.*;

public class correctParentheses {

	class Solution {
	    boolean solution(String s) {
	        
	        boolean answer=true;
	        Stack<Character> st = new Stack<>();
	        
	        for(int i=0; i<s.length(); i++) {

	        	char p = s.charAt(i);

	        	if(p=='(') {          //만약 (면 스택에 추가해준다.
	        		st.push(p);
	        	}else{					// 만약 )일 경우 
                    if(st.isEmpty()){ 	// 스택이 비어있으면 false를 return 해준다.
                        return false;
                    }
	        		st.pop();			//비어있지 않다면 pop을 통해 스택에서 1개를 빼준다. 
	        	}
	        }
	          if(st.isEmpty()) {		//결과적으로 스택이 비어있으면 true,
	        	answer=true;
	        }else {
	        	answer=false;			//아닐경우 false를 출력.
	        }
	        
	        return answer;
	    }
	}
}
