package StringPractice;

import java.util.*;

public class Main {

	class Solution {
    public String solution(String new_id) {
        String answer = "";
        answer = new_id.toLowerCase();
        answer = answer.replaceAll("[^0-9a-z-_.]", "");
        answer=answer.replaceAll("\\.+", ".");
        answer=answer.replaceAll("^[.]|[.]$", ".");
        answer = (answer.isEmpty() ? "a" : answer);
        if(answer.length()>15) {
        	answer=answer.substring(0, 15);
        	answer=answer.replaceAll("[.]$", "");
        }
        while(answer.length()<3) {
        	answer+=answer.charAt(answer.length()-1);
        }
        return answer;
    }
}
}
