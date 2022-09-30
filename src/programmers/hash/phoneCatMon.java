package hash;

import java.util.*;

public class phoneCatMon {
	class Solution {
	    public int solution(int[] nums) {
	        int answer = 0;
	        int max=nums.length/2;		//문제에서 최대 n/2마리의 폰켄몬을 가지기 때문에 최대값을 설정한다. 
	        	
	        HashSet<Integer> hashSet = new HashSet<>();	//최대 종류의 개수를 구하는것이라 중복이 필요없으므로 HashSet사용  
	        
	        for(int num:nums) {			//입력배열을 하나씩 빼서 
	        	hashSet.add(num);		//hashSet에 담아준다. (중복제거)
	        }
	        
	        if(max<hashSet.size()) {		//폰켄몬 종류가 최대값보다 큰경우 
	        	answer=max;					//문제 최대값인 max값 출력 
	        }else {
	        	answer=hashSet.size();		//최대값보다 적은경우 중복제거된 폰켄몬 종류를 출력해준다.  
	        }
	        return answer;
	    }
	}
}
