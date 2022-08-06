package hash;

import java.util.*;


public class camouflage {
	class Solution {
	    public int solution(String[][] clothes) {
	        
	        //1 해쉬를 만든다.
	    	HashMap<String, Integer> map = new HashMap<>();
	    	
	    	for(String cloth[]:clothes) {			//cloth[1]에서 Integer형태로 개수만 파악 	
	    		String type=cloth[1];
	    		map.put(type, map.getOrDefault(type, 0)+1);
	    	}
	    	//2 옷을 입지 않는 경우를 추가해준다.
	    	
	    	Iterator<Integer> it = map.values().iterator();		//iterator을 활용해 value값을 가져와 반복한다.
	    	
	    	int answer=1;
	    	while(it.hasNext()) {
	    	answer*=it.next().intValue()+1;						//가져온값은 객체이므로 intValue를 통해 int형으로 변환 	
	    	}
	    	//3 아무 옷도 입지 않은 경우를 빼준다.
	    	return answer-1;
	    }
	}
}
