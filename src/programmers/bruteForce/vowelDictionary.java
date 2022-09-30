package bruteForce;

public class vowelDictionary {

	class Solution {
		//좀더 간결한 코드 
	    public int solution(String word) {
	        int answer=0;
	        int max=3905;	//781*5 
	        for(String s : word.split("")) {
	        	answer+="AEIOU".indexOf(s)* (max/=5) +1;
	        }
	        
	        return answer;
	    }
	}

}

//class Solution {
//    public int solution(String word) {
//        String alpha = "AEIOU";
//        int total[] = {781,156,31,6,1};				// 이전값 *5 +1   현재위치 = AEIOU(5개) 지나고 +1 이므로 
//        
//        int answer = word.length();					//최소값은 word.length;
//        
//        for(int i=0; i<word.length(); i++) {
//        	int index=alpha.indexOf(word.charAt(i));		//AEIOU중 index값을 찾아준다.
//        	answer+= total[i]*index;	
//        }
//        
//        return answer;
//    }
//}
