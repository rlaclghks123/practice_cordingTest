package sorting;

import java.util.*;


public class Main {

	class Solution {
	    public int solution(int[] citations) {
	        int answer = 0;
	        
	        //오름차순을 정렬을 한다
	        Arrays.sort(citations);
	        
	        for(int i=0; i<citations.length; i++) {
	        	//h값의 최대값을 구하기 위해 제일 큰값부터 i씩 줄이면서 h값이 citation의 값보다 작아질때(최대값) 을 구한다. 
	        	int h = citations.length-i;
	        	
	        	if(h<=citations[i]) {
	        		answer=h;
	        		break;
	        	}
	        }
	        return answer;
	    }
	}
	
}
