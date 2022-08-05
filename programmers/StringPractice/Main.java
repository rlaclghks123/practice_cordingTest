package StringPractice;

import java.util.*;

public class Main {

	class Solution {
    public String solution(String new_id) {
        String answer = "";
        answer = new_id.toLowerCase();
        answer = answer.replaceAll("^[0-9a-z-_.]", "");
        System.out.print(answer+" ");
        return answer;
    }
}
}
