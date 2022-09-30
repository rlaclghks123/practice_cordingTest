package kakaoBlindRecruiment2022;

import java.util.*;;

public class k진수에서소수구하기 {
	
	class Solution {
	    public int solution(int n, int k) {
	    	
	    	//소수의 개수를 담을 변수를 0으로 초기화해준다.
	        int answer = 0;
	        
	        // n을 k진수의 수를 재귀를 통해 string형식으로 바꿔준다.
	        String number = k==10 ? String.valueOf(n) : create(n,k);
	        
	        // k진수의 수를 만든것을 0을 기준으로 String[] 안에 나눠서 넣어준다.
	        String arr[] = number.split("0+");
	        
	        //arr 배열안의 값을 가져온다.
	        for(String value:arr) {
	        	
	        	//값이 너무 클수있기 때문에 long으로 바꿔준뒤, 소수인지 아닌지 확인해준다.
	        	if(check(Long.parseLong(value))) {
	        		answer++;
	        	}
	        }
	        return answer;
	    }
	    
	    public String create(int num, int base) {
	    
	    // n진수를 구하는법은 몫이 0이 될때까지 값을 나누고, 나머지를 더하는 것이다.
	    int p=num/base;			//나눈값을 구해준다.
	    int r=num%base;			//나머지값을 구해준다.
	    
	    if(p!=0) {				// 0이 아닐경우, 재귀를 통해 계속나눠주고, 나머지값을 더해준다.				
	    	return create(p,base)+String.valueOf(r);
	    }
	    return String.valueOf(r);	//0일경우 현재 나머지값을 더해준다. 
	    }
	    
	    public boolean check(long n) {
	    	if(n<=1) return false;
	    	if(n==2) return true;
	    	
	    	for(long i=3; i*i<=n; i++) {	//i는 long으로 해준다.
	    		if(n%i==0) {
	    			return false;
	    		}
	    	}
	    	return true;
	    }
	}
}
