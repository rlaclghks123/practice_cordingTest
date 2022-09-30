package bruteForce;

import java.util.*;

public class findingPrimeNumber {

	
	class Solution {
		
		HashSet<Integer> set = new HashSet<>();
		
		public void recursive(String com, String other) {
			
			if(!com.equals("")) {
			set.add(Integer.valueOf(com));	
			}
			
			for(int i=0; i<other.length(); i++) {
				recursive(com+other.charAt(i), other.substring(0,i)+other.substring(i+1));
			}
		}
		
		public boolean isPrime(int num) {
			
			if(num==0 || num==1) {
				return false;
			}
			
			int limit = (int)Math.sqrt(num);
			
			for(int i=2; i<=limit; i++) {
				if(num%i==0) {
					return false;
				}
			}
			
			return true;	
		}
		
	    public int solution(String numbers) {
	        int answer = 0;
	        
	        //만들수 있는 모든 숫자 조합을 set안에 넣어준다. 
	        recursive("", numbers);
	        
	        //set안의 모든값을 반복문을 통해 소수인지 아닌지 확인한다.
	        Iterator<Integer> it =set.iterator();
	        
	        while(it.hasNext()) {
	        	int next=it.next();
	        	if(isPrime(next)) {
	        		answer++;
	        	}
	        }
	       
	        //소수일경우 answer++해줌으로서 개수를 세어준다.		
	        return answer;
	    }
	}
}
