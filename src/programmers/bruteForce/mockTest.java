package bruteForce;

import java.util.*;

public class mockTest {
	
	class Solution {
	    public int[] solution(int[] answers) {
	        int[] answer = new int[10001];
	        
	        //문제에서 수포자 1,2,3의 반복되는 부분을 배열로 가져온다. 
	        int first[] = {1, 2, 3, 4, 5};
	        int second[] = {2, 1, 2, 3, 2, 4, 2, 5};
	        int third[] = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
	        
	        // 정답의 개수를 나타낼 배열을 생성 
	        int score[] = new int[4];
	        
	        //문제에서 주어진 정답과 수포자1,2,3의 정답과 비교해서 개수를 담아준다. 
	        for(int i=0; i<answers.length; i++) {
	        	if(answers[i]==first[i%first.length]) score[1]++;
	        	if(answers[i]==second[i%second.length]) score[2]++;
	        	if(answers[i]==third[i%third.length]) score[3]++;
	        }
	        
	        //최종적으로 답을 많이구한 사람을 담을 list를 생성 
	        List<Integer> list = new ArrayList<>();
	        
	        //최대로 많이 맞춘사람을 찾아준다.
	        int max = Math.max(score[1], Math.max(score[2], score[3]));
	        
	        //최대값과 같은 수포자를 list에 담아준다.
	        if(max==score[1]) list.add(1);
	        if(max==score[2]) list.add(2);
	        if(max==score[3]) list.add(3);
	        
	        //list를 배열에 담아준다.
	        return answer = list.stream().mapToInt(i->i.intValue()).toArray();
	    }
	}

}
