package sorting;

import java.util.Arrays;

public class hIndex {
	class Solution {
	    public int solution(int[] citations) {
	        int answer = 0;
	        
	        //오름차순으로 정렬을 해준다. 논문의 인용횟수를 순차적으로 비교하기 위해서  
	        Arrays.sort(citations);;
	        
	        //반복문을 통해 h citations.length 부터 i만큼 감소시키고, 점차 증가하는 인용횟수와 비교해준다. 
	        for(int i=0; i<citations.length; i++) {
	        	int h=citations.length-i;
	        	
	        	//h가 인용횟수보다 작아지는 값중 최대값을 찾는다. (이경우 정렬을 해서 조건을 만족하는경우 값이 정답이다. 따라서 break)
	        	if(h<=citations[i]) {
	        		answer=h;
	        		break;
	        	}
	        }
	        return answer;
	    }
	}
}
