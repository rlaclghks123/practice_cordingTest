package StringPractice;

public class newId {
	
	class Solution {
		//정규식을 활용해 문자열 풀기. 
		// [] : 모든문자,  [^] : []의 문자를 제외하고 모두, 
		// ^[]: []안의 문자열로 시작하는 문자열, []$ : []안의 문자열로 끝나는 문자열. 
		
		
	    public String solution(String new_id) {
	        String answer = "";
	        //1.
	        new_id=new_id.toLowerCase();
	        //2. 
	        answer=answer.replaceAll("[^0-9a-z-_.]","");
	        
	        //3.
	        answer=answer.replaceAll("\\.+", ".");
	        
	        //4
	        answer=answer.replaceAll("^[.]|[.]$", "");
	        
	        //5
	        answer=(answer.isEmpty() ? "a" : answer);
	        
	        //6
	        if(answer.length()>15) {
	        	answer=answer.substring(0,15);
	        	answer=answer.replaceAll("[.]$", "");
	        }
	        
	        //7
	        while(answer.length()<3) {
	        	answer += answer.charAt(answer.length()-1);
	        }
	        return answer;
	    }
	}
}
