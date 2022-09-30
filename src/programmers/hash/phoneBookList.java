package hash;
import java.util.*;

public class phoneBookList {
	//해시 사용 
	 
	class Solution {
	    public boolean solution(String[] phone_book) {
	        
	    	//1. hashMap 생성
	    	HashMap<String,Integer> map = new HashMap<>();
	    	
	    	//2. hashMap에 key,value값 추가  
	    	for(int i=0; i<phone_book.length; i++) {
	    		map.put(phone_book[i], 1);
	    	}
	    	
	        //3. hashMap의 key값에서 phone_book 값의 접두사가 있는지 확인 
	    	for(int i=0; i<phone_book.length; i++) {
	    		for(int j=1; j<phone_book[i].length(); j++) {		//0번째부터 j번째 까지 구하기위해 1부터 시작
	    			if(map.containsKey(phone_book[i].substring(0,j))) {
	    				return false;
	    			}
	    		}
	    	}
	    	//4. 그래도 아니면 접두어가 없으므로 true 출력.
	    	return true;
	    }
	}
}

//정렬을 통해 
	class Solution {
	    public boolean solution(String[] phone_book) {
	        boolean answer = true;
	        
	        //1. 정렬을 한다.
	        Arrays.sort(phone_book);
	        
	        //2. Loop을 돌면서 앞 번호가 뒷번호의 접두어인지 확인한다.
	        for(int i=0; i<phone_book.length-1; i++) { 		//크기 -1만큼 해주는 이유는 i, i+1을 돌아야 되기 때문 
	        	if(phone_book[i+1].startsWith(phone_book[i])) {
	        		return false;
	        	}
	        }
	        
	        //3. 그래도 아니면 접두어가 아님으로 true를 반환한다.
	        return true;
	    }
	}
