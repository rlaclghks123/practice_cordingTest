package hash;

import java.util.*;

public class phoneCatMon {
	class Solution {
	    public int solution(int[] nums) {
	        int answer = 0;
	        int max=nums.length/2;		//문제에서 n/2마리의 폰켄몬을 가져갈수 있기때문 
	        	
	        HashSet<Integer> hashSet = new HashSet<>();	//중복을 제거하기 위해 HashSet사용 
	        
	        for(int num:nums) {			//입력배열을 하나씩 빼서 
	        	hashSet.add(num);		//hashSet에 담아준다. (중복제거)
	        }
	        
	        if(max<hashSet.size()) {		//최대값보다 큰경우 
	        	answer=max;					//문제최대값인 max값 출력 
	        }else {
	        	answer=hashSet.size();		//최대값보다 적은경우 중복제거된 개수 출력 
	        }
	        return answer;
	    }
	}
}
