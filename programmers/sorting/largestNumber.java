package sorting;

import java.util.Arrays;

public class largestNumber {

	class Solution {
	    public String solution(int[] numbers) {
	        String answer = "";
	        
	       //문자열 배열 생성 
	        String res[] = new String[numbers.length];
	        
	        //int를 문자열로 변환 
	        for(int i=0; i<numbers.length; i++) {
	        	res[i]=String.valueOf(numbers[i]);
	        }
	        
	        //정렬을 통해 내림차순으로 정렬. ex) 3, 30비교시 303, 330을 비교 
	       //만약 오름차순으로 정렬을 원할경우 (a+b).compareTo(a+b)
	        Arrays.sort(res,(a,b) -> {
	        return (a+b).compareTo(b+a);	
	        });
	        
	        //정렬한 값 모두 더하기 
	        for(int i=numbers.length-1; i>=0; i--) {
	        	answer+=res[i];
	        }
	        
//	        //정렬 
//	        Arrays.sort(res,(a,b)->{
//	        	return (b+a).compareTo(a+b);
//	        });
//	        
//	        //정렬한값을 모두 더하기 
//	        for(int i=0; i<res.length; i++) {
//	        	answer+=res[i];
//	        }
	        
	        //만약 0번째 값이 0일경우 "0"으로 처리 
	        if(answer.charAt(0)=='0') return "0";
	        
	        return answer;
	    }
	}
}
