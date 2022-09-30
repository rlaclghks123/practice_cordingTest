package stackAndQueue;

import java.util.*;

public class hateSameNumber {

		
	public class Solution {
	    public int[] solution(int []arr) {
	    	
	    	//조건에 맞을경우 배열로 만들기 위해 arrayList 생성 
	    	ArrayList<Integer> list = new ArrayList<>();
	    	
	    	//이전값과 다를경우만 추가하기 위해 이전값을 변수로 생성 첫번째값을 담기위해 -1로 초기값설정  
	    	int prev=-1;
	    	
	    	for(int i=0; i<arr.length; i++) {
	    		if(arr[i]!=prev) {			//이전값과 다를경우만 
	    			list.add(arr[i]);		//list에 담아준다. 
	    		}
	    		prev=arr[i];			//이전값을 현재값으로 바꿔준다. 
	    	}
	    		    	
	    	int [] answer = new int[list.size()];
	    	for(int i=0; i<answer.length; i++) {
	    	answer[i]=list.get(i);	
	    	}
	    	
	        return answer;
	    }
	}
}
