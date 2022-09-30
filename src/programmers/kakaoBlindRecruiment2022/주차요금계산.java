package kakaoBlindRecruiment2022;

import java.util.*;

public class 주차요금계산 {


	//fee : [기본시간, 기본요금, 단위시간, 단위금액] 
	// records : [ "시간 번호 입출내용" ]
	class Solution {
	    public int[] solution(int[] fees, String[] records) {
	    	
	    	HashMap<String, Integer> inTime = new HashMap<>();		//차량이 들어왔을때 번호,시간을 담을 Map생성
	    	TreeMap<String, Integer> result = new TreeMap<>();		//각 차마다 지불해야할 금액을 담을 Map생성(정렬이 필요하므로 TreeMap)
	    	// record에서 자동차 정보를 가져온다.
	    	for(String record:records) {
	    		
	    		String car[] = record.split(" ");
	    		
	    		String time = car[0]; 		// 시간을 가져온다.
	    		String number = car[1];		//차량 번호를 가져온다.
	    		String inAndOut = car[2];	//입출 정보를 가져온다.
	    		
	    		if(inAndOut.equals("IN")) {		//차량이 들어왔을때 처리해준다.
	    			inTime.put(number, convert(time));		//시간을 분으로 바꿔 넣어준다.
	    			
	    			result.put(number, result.getOrDefault(number, 0));	//아래의 코드와 같다.
//	    			if(result.containsKey(number)==false) {
//	    				result.put(number, 0);
//	    			}
	    			
	    		}else {							//차량이 나갔을때 처리해준다.
	    			result.put(number, result.get(number)+convert(time) - inTime.get(number));
	    			inTime.remove(number);		//차량이 나갔기 때문에 inTime에서 제거해준다.
	    		}
	    	}
	    	
	    	inTime.forEach((key,value)->{		//들어왔지만 나가지 않은 차를 처리해준다.
	    		result.put(key, result.get(key)+23*60+59-value);
	    	});
	    	
	        int[] answer = new int[result.size()];
	        int index=0;
	        
	        for(int val:result.values()) {
	        	answer[index]=fees[1];
	        	if(val>fees[0]) {
	        		answer[index]+=Math.ceil((val-fees[0]) /(double)fees[2]) * fees[3];	///문제에서 올림처리 해주라 했기 때문에 올림처리 
	        	}
	        	index++;
	        }
	        
	        return answer;
	    }
	    public int convert(String times) {
	    	String time[] = times.split(":");
	    	
	    	int hour = Integer.parseInt(time[0]);
	    	int minute = Integer.parseInt(time[1]);
	    	
	    	return hour*60 + minute;
	    }
	}	

}
