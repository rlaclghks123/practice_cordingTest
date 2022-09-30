package sorting;
import java.util.*;


public class seventhOfNumber {

class Solution {
	    public int[] solution(int[] array, int[][] commands) {
	    	
	    	//answer배열을 commands의 크기만큼 할당   
	        int[] answer = new int[commands.length];
	        
	        //commands를 돌면서 
	        for(int i=0; i<commands.length; i++) {
	        	//정답을 담을 list를 만들어준다.
	        	ArrayList<Integer> arr = new ArrayList<>();
	        	

	        	int start = commands[i][0]-1;			        	//시작점 -1을 해준다. array는 0부터 시작하기 때문
	        	int end = commands[i][1];							//끝지점을 정해준다. -1을 안하는 이유는 j<end로 이하가 아닌 미만이므로
	        	int pick = commands[i][2]-1;						//선택할 index를 구한다.  또한 0부터 시작하기 때문에 -1을 해준다 
	        	
	        	for(int j=start; j<end; j++) {						//시작점~ 끝점까지 array값을 list에 넣어준다.
	        		arr.add(array[j]);
	        	}
	        	
	        	Collections.sort(arr);								//정렬을 한다.
	        	answer[i] = arr.get(pick);							//선택한 index번째의 수를 넣는다.
	        }
	        return answer;
	    }
	}
}
