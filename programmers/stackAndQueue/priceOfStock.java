package stackAndQueue;

import java.util.*;

public class priceOfStock {

	//stack을 활용한 정답 
	
	class Solution {
	    public int[] solution(int[] prices) {
	    	
	    	//answer의 크기 할당 
	    	int answer[] = new int[prices.length];
	    	
	    	//stack생성 
	    	Stack<Integer> s = new Stack<>();
	    	int n=prices.length;
	    	
	    	for(int i=0; i<n; i++) {
	    		
	    		//스택이 비어있지 않으면서,  스택에 값(이전값)이 현재값보다 클경우 (감소한 경우) answer 배열에 담아준다.
	    		while(!s.isEmpty() && prices[i]<prices[s.peek()]) {
	    			int temp = s.pop();
	    			//몇초걸렸는지 확인하기 위해 i-temp
	    			answer[temp] = i-temp;
	    		}
	    		
	    		//값이 같거나 증가한 경우는 스택에 넣어준다.
	    		s.push(i);
	    	}
	    	
	    	//스택에 있는 모든값을 몇초걸렸는지 확인해서 answer에 담아준다.
	    	while(!s.isEmpty()) {
	    		int temp = s.pop();
	    		answer[temp] = n-temp-1;
	    	}
	    	return answer;
	    }
	}
}
	



//2중 for문을 활용한 정답 

//class Solution {
//    public int[] solution(int[] prices) {
//        int[] answer = new int[prices.length];
//        int n=prices.length;
//        for(int i=0; i<n; i++) {
//        	for(int j=i+1; j<n; j++) {
//        		answer[i]++;
//        		if(prices[i] > prices[j]) {
//        			break;
//        		}
//        	}
//        }
//        return answer;
//    }
//}
