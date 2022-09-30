package hash;
import java.util.*;

public class unsuccessfulRunner {
	//해시를 사용한 정답
	class Solution {
	    public String solution(String[] participant, String[] completion) {
	    	String answer = "";
	    	
	    	// hashMap 생성 
	    	HashMap<String,Integer> map = new HashMap<>();
	    	for(String player:participant) {
	    		map.put(player,map.getOrDefault(player,0)+1);		//hashMap participant를 기반으로 만든뒤 존재하는경우 +1 해준다. 
	    	}
	    	
	    	for(String player:completion) {							//map에서 completion한 player를 지워준다 -1
	    		map.put(player, map.get(player)-1);
	    	}
	    	
	    	for(String key:map.keySet()) {							//모든 key를 가져와서 0이아닌 key를 찾아준다.
	    		if(map.get(key)!=0) {
	    			answer=key;										//0이 아닌 key값을 출력 
	    		}
	    	}
	    	return answer;
	    }
	}
}


//정렬을 이용한 정답
//class Solution {
//    public String solution(String[] participant, String[] completion) {
//    	String answer = "";

//		정렬을 통해 처음부터 순차적으로 비교하면서 값이 다를경우 출력해주고, 마지막앞까지 다 같을경우 마지막을 출력해준다. 
//    	Arrays.sort(participant);				//정렬을 한다 
//    	Arrays.sort(completion);				//정렬을 한다. 
//    	
//    	int i=0;	//마지막번째 값을 출력하기위해 i를 빼준다.
//    	for(; i<completion.length; i++) {	    		
//    		if(!participant[i].equals(completion[i]))	//처음부터 completion길이만큼 비교한뒤 다르면 stop 
//    			break;
//    	}
//    	return participant[i];					//break하지 않았으면 마지막이 정답.
//    }
//}